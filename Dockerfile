FROM amazoncorretto:11-alpine-jdk
MAINTAINER Luis Serrano
COPY target/ap-0.0.1-SNAPSHOT.jar portfolioArgProg-app.jar
ENTRYPOINT ["java","-jar","portfolioArgProg-app.jar"]
