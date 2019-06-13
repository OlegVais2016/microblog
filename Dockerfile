FROM openjdk:8

COPY target/microblog-0.0.1-SNAPSHOT.jar /microblog-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "microblog-0.0.1-SNAPSHOT.jar"]