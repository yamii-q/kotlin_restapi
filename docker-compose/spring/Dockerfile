# use alpine as base image
FROM openjdk:jdk-alpine
# recommended by spring boot
VOLUME /tmp
# create directory for application
RUN mkdir /app
WORKDIR /app
# set entrypoint to execute spring boot application
ENV JAR_TARGET "kotlin_restapi-0.0.1-SNAPSHOT.jar"
ENTRYPOINT ["sh","-c","java -jar -Dspring.profiles.active=docker-compose ./build/libs/${JAR_TARGET}"]