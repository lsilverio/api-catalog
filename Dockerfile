FROM openjdk:17

WORKDIR /app

COPY target/api-catalog-0.0.1-SNAPSHOT.jar api-catalog.jar

EXPOSE 8080

CMD ["java", "-jar", "api-catalog.jar"]
