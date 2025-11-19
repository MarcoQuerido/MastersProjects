FROM openjdk:11
ADD target/ReviewQuery-1.0-SNAPSHOT.jar reviewQuery.jar
ENTRYPOINT ["java", "-jar","reviewQuery.jar"]
EXPOSE 8080