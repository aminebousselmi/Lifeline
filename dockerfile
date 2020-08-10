FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/lifeline-0.0.1-SNAPSHOT.jar lifeline.jar
ENTRYPOINT ["java", "-jar","lifeline.jar"]