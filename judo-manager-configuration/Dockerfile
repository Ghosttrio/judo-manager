FROM openjdk:17-alpine
ARG JAR_FILE=/build/libs/judo-manager-configuration.jar
COPY ${JAR_FILE} judo-manager-configuration.jar

ENTRYPOINT ["java","-jar", "judo-manager-configuration.jar"]