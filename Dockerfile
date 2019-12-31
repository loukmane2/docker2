FROM openjdk:8
ADD target/projet.jar projet.jar
ENTRYPOINT ["java","-jar","projet.jar"]
EXPOSE 8080