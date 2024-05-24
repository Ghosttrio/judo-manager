FROM openjdk:17-alpine

ARG JAR_FILE=/build/libs/judo-manager-chat.jar
ARG JASYPT_PASSWORD

ENV jasypt_password=${JASYPT_PASSWORD}

COPY ${JAR_FILE} judo-manager-chat.jar

ENTRYPOINT ["java","-jar", "-Djasypt.encryptor.password=${JASYPT_PASSWORD}", "/judo-manager-chat.jar"]