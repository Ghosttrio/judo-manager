FROM openjdk:17-alpine
ARG JAR_FILE=/build/libs/judo-manager-eurekaserver.jar
COPY ${JAR_FILE} judo-manager-eurekaserver.jar

ENTRYPOINT ["java","-jar", "judo-manager-eurekaserver.jar"]