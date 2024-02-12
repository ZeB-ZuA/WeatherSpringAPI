FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
COPY ./target/crud-1.0.jar app.jar
COPY ./src/main/resources/application.properties /config/application.properties
ENTRYPOINT ["java","-jar","/app.jar","--spring.config.location=/config/application.properties"]
