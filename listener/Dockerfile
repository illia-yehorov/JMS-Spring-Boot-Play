FROM openjdk:11
COPY target/*.jar listener.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "/listener.jar"]