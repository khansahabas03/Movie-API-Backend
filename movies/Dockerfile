# Use an official Maven image with JDK 17
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy the project files
COPY movies/pom.xml .
COPY movies/src ./src

# Package the application
RUN mvn clean package -DskipTests

# ---- Create a lightweight image for runtime ----
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy only the jar from the builder stage
COPY --from=build /app/target/ems-backend-0.0.1-SNAPSHOT.jar app.jar

# Run the app
CMD ["java", "-jar", "app.jar"]
