# Use the official Maven image to build the application
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use the official OpenJDK image to run the application
FROM openjdk:17-jdk-alpine
WORKDIR /opt
COPY --from=build /app/target/*.jar /opt/ubuntuconnect.jar
COPY src/main/resources/application.properties /opt/application.properties
CMD ["java", "-jar", "/opt/ubuntuconnect.jar", "--spring.config.location=file:/opt/application.properties"]
