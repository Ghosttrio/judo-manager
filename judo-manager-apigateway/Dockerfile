FROM openjdk:17-alpine
ARG JAR_FILE=/build/libs/judo-manager-apigateway.jar
COPY ${JAR_FILE} judo-manager-apigateway.jar

ENTRYPOINT ["java","-jar", "judo-manager-apigateway.jar"]