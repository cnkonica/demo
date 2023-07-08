#!/bin/bash
# place in /home/konyliu/application/script
# 操作名称
operation=$1
# Jar项目名称
appName=$2
# 项目路径
artifactId=$3
# 创建项目目录
appPath="/home/konyliu/application/$artifactId"
if [ ! -d "$appPath" ];
then
    mkdir -p "$appPath"
fi

# 帮助说明
function usage()
{
  echo "Usage:   sh /home/konyliu/application/script/app-cloud-devops.sh [-operation] [appName] [artifactId]"
  echo "Example: sh /home/konyliu/application/script/app-cloud-devops.sh restart eurekaApp8090 demo-eureka "
  echo "where options include:"
  echo "     start        启动app"
  echo "     stop         停止app"
  echo "     restart      重启app"
  echo "     status       查看状态"
}

if [ "$operation" == "--help" ];
then
  usage;
  exit 1
fi

if [ "$operation" == "" ];
then
    echo -e "\033[0;31m 未输入操作名 \033[0m"
    exit 1
fi

if [ "$appName" == "" ];
then
    echo -e "\033[0;31m 未输入应用名 \033[0m"
    exit 1
fi

if [ "$artifactId" == "" ];
then
    echo -e "\033[0;31m 未输入项目路径 \033[0m"
    exit 1
fi


# 统计运行应用数
function getCount()
{
    count=$(ps -ef |grep java|grep "$appName.jar"|grep -v grep|wc -l)
    echo $count
}

# 获取pid
function getPid()
{
    pid=$(ps -ef | grep "$appName.jar" | grep -v grep | awk '{print $2}')
    echo $pid
}

# 启动应用
function start()
{
    source /etc/profile
    # 统计运行应用数
    count=$(getCount)
    if [ $count != 0 ];then
        echo "$appName is running..."
    else
        echo "$appName is start..."
        # 拷贝并覆盖Jenkins生成在builds文件下的jar 到所属的项目路径下
        cp -rf /var/lib/jenkins/workspace/$artifactId/$artifactId/target/"$appName.jar" "$appPath"
        chmod 775 -R "$appPath"
        cd "$appPath" || exit
        echo "before start..."
        nohup java -jar -Dspring.profiles.active=prod "$appName.jar" >/dev/null 2>&1 &
        echo "after start..."
    fi
}

# 停止应用
function stop()
{
    echo "stop $appName..."
    count=`getCount`
    echo "count: $count"
    if [ $count != 0 ];then
        pid=$(getPid)
        echo "stop $appName kill pid $pid"
        kill "$pid"
        sleep 2
        count=$(getCount)
        if [ "$count" != 0 ];then
            echo "stop $appName kill -9 pid $pid"
            kill -9 "$pid"
        fi
    fi
}

# 备份应用
function bak()
{
    echo "bak start..."
    bakPath="/home/konyliu/application/$artifactId/bk"
    if [ ! -d "$bakPath" ];
    then
        mkdir -p "$bakPath"
    fi
    bakName="/home/konyliu/application/$artifactId/$appName.jar"
    if [ -f "$bakName" ];
    then
        mv -f "$bakName" "$bakPath"/"$appName"_$(date +%Y%m%d%H%M%S).jar
    fi

}

# 删除过期的备份程序只保留最新3次的
function del_bak
{
    echo "del_bak start..."
    bak_DIR=/home/konyliu/application/$artifactId/bk
    if [ -d "$bak_DIR" ]; then
        cd "$bak_DIR" || exit
        bak_count=$(ls -lthr | grep -v 'total' | grep  "$appName" |  wc -l)
        if (("$bak_count" > 3));then
            del_count=$(expr "$bak_count" - 3)
            ls -thr | grep -v 'total' | grep  "$appName"| head -"$del_count" | xargs rm -rf
        fi
    fi
    echo "del_bak success..."
}


# 重启应用
function restart()
{
    stop
    del_bak
    bak
    start
    status
}

# 打印启动状态
function status()
{
    count=$(getCount)
    if [ $count != 0 ];then
        echo "$appName is success..."
    else
        echo "$appName is not success..."
    fi
}

case $1 in
    start)
    start;;
    stop)
    stop;;
    restart)
    restart;;
    status)
    status;;
    --help)
    usage;;
    *)
    echo -e "请使用--help察看可用选项" ;;
esac