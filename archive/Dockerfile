FROM openjdk:11
COPY target/*.jar archive.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "/archive.jar"]