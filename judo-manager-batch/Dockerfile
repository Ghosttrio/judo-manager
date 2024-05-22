FROM openjdk:17-alpine

ARG JAR_FILE=/build/libs/judo-manager-batch.jar
ARG JASYPT_PASSWORD

ENV jasypt_password=${JASYPT_PASSWORD}

COPY ${JAR_FILE} judo-manager-batch.jar

ENTRYPOINT ["java","-jar", "-Djasypt.encryptor.password=${JASYPT_PASSWORD}", "/judo-manager-batch.jar"]