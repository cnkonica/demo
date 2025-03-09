# Base image
FROM azul/zulu-openjdk-alpine:11-jre

# Maintainer
LABEL maintainer="kony"
# Copy JAR file
COPY target/exampleApp8092.jar exampleApp8092.jar
# Expose the application port
EXPOSE 32013
# Set default environment variable (can be overridden)
ENV SPRING_PROFILES_ACTIVE=local
# Run the application
ENTRYPOINT ["sh", "-c", "java -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -Djava.security.egd=file:/dev/./urandom -Duser.timezone=GMT+08 -jar exampleApp8092.jar"]