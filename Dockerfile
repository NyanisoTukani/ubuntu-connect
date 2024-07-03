FROM maven:3.8.5-openjdk-17 AS build
COPY . . 
RUN maven clean package -DskipTest

FROM openjdk:17.0.1-jdk-slim 
COPY --from=build /target/ubuntu_connect-0.0.1-SNAPSHOT.jar ubuntu_connect.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","ubuntu_connect.jar"]