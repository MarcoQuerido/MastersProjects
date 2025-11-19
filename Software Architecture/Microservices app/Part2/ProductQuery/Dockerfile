FROM openjdk:11
ADD target/ProductQuery-1.0-SNAPSHOT.jar productQuery.jar
ENTRYPOINT ["java", "-jar","productQuery.jar"]
EXPOSE 8080