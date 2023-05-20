FROM openjdk:11
COPY target/*.jar sender.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "/sender.jar"]