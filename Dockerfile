
FROM openjdk:11-jre-slim
ARG JAR_FILE=target/*.jar''
COPY ${JAR_FILE} msusers.jar
ENTRYPOINT ["java","-jar","/msusers.jar"]