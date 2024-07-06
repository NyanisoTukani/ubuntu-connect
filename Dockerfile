# Stage 1: Build
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY settings.xml /root/.m2/settings.xml
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:17-jdk-alpine
WORKDIR /opt
COPY --from=build /app/target/*.jar /opt/ubuntuconnect.jar
COPY src/main/resources/application.properties /opt/application.properties
CMD ["java", "-jar", "/opt/ubuntuconnect.jar", "--spring.config.location=file:/opt/application.properties"]
