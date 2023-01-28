FROM eclipse-temurin:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} consumer.jar
ENTRYPOINT ["java","-jar","/consumer.jar"]