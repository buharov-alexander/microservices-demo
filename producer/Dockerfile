FROM eclipse-temurin:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} producer.jar
ENTRYPOINT ["java","-jar","/producer.jar"]