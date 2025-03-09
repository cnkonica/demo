# 该镜像需要依赖的基础镜像
FROM azul/zulu-openjdk-alpine:11-jre
# 指定维护者的名字
MAINTAINER kony
# 将本地文件夹挂载到当前容器
# VOLUME ["/tmp"]
# 将指定目录下的jar包复制到docker容器的/目录下
COPY target/exampleApp8092.jar exampleApp8092.jar
# CMD ["--server.port=8080"]
# 声明服务运行在8080端口
EXPOSE 32013
# 切换WORKDIR
# WORKDIR /opt/web/
# 指定docker容器启动时运行jar包
ENTRYPOINT ["sh","-c","java ${PROFILE} -Djava.security.egd=file:/dev/./urandom -Duser.timezone=GMT+08 -jar exampleApp8092.jar ${JAVA_OPTS}"]