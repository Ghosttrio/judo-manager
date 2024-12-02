FROM openjdk:17-alpine

ARG JAR_FILE=/build/libs/judomanager.jar

COPY ${JAR_FILE} judomanager.jar

ENTRYPOINT ["java","-jar", "-Djasypt.encryptor.password=${JASYPT_PASSWORD}", "/judomanager.jar"]