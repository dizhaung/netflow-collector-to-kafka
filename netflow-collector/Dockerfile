FROM openjdk:8-jre-alpine
ADD target/netflow-collector-1.0-jar-with-dependencies.jar app.jar
EXPOSE 4445
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]