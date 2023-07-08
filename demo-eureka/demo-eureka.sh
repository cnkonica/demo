#!/bin/bash
# 操作名称
operation=$1
shellPath=/home/konyliu/application/script/app-cloud-devops.sh
appName=eurekaApp8090
artifactId=demo-eureka
# 帮助说明
function usage()
{
  echo "Usage:   sh demo-eureka.sh [-operation]"
  echo "where operation include:"
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

sh $shellPath "$operation" "$appName" "$artifactId"