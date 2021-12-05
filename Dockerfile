FROM openjdk:16-jdk-alpine
COPY target/PetShelter-0.0.1-SNAPSHOT.jar petshelter-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/petshelter-api.jar"]
