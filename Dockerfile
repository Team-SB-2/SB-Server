FROM openjdk:17-jdk-slim

EXPOSE 8080

ADD build/libs/SB-Server-0.0.1-SNAPSHOT.jar SB-Server-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","SB-Server-0.0.1-SNAPSHOT.jar"]