FROM openjdk:17-alpine

ARG JAR_FILE=/build/libs/judomanager.jar
ARG JASYPT_PASSWORD

ENV jasypt_password=${JASYPT_PASSWORD}

COPY ${JAR_FILE} judomanager.jar

ENTRYPOINT ["java","-jar", "-Djasypt.encryptor.password=${JASYPT_PASSWORD}", "/judomanager.jar"]