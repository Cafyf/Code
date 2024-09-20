# Use an official OpenJDK image as the base image
FROM openjdk:17-jdk

# Set the working directory inside the container
WORKDIR /application

# Copy the JAR file to the container
COPY target/springboot-backend-0.0.1-SNAPSHOT.jar /application/app.jar

# Expose the port that the Spring Boot app listens on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/application/app.jar"]
