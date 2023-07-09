# 该镜像需要依赖的基础镜像
FROM adoptopenjdk/openjdk11
# 指定维护者的名字
MAINTAINER kony
# 将本地文件夹挂载到当前容器
# VOLUME ["/tmp"]
# 将指定目录下的jar包复制到docker容器的/目录下
COPY gateway8091.jar gateway8091.jar
# CMD ["--server.port=8080"]
# 声明服务运行在8080端口
EXPOSE 8091
# 切换WORKDIR
# WORKDIR /opt/web/
# 指定docker容器启动时运行jar包
ENTRYPOINT ["sh","-c","java ${PROFILE} -Djava.security.egd=file:/dev/./urandom -Duser.timezone=GMT+08 -jar gateway8091.jar ${JAVA_OPTS}"]