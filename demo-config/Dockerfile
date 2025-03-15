# Base image
FROM azul/zulu-openjdk-alpine:11-jre

# Maintainer
LABEL maintainer="kony"

# Copy JAR file
COPY demo-config/target/ConfigApp.jar /ConfigApp.jar

# Expose the application port
EXPOSE 32011

# Set default environment variable (can be overridden)
ENV SPRING_PROFILES_ACTIVE=local

# Run the application
ENTRYPOINT ["sh", "-c", "java -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -Djava.security.egd=file:/dev/./urandom -Duser.timezone=GMT+08 -jar /ConfigApp.jar"]
