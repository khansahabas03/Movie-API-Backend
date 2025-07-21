# Use a lightweight Java runtime
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy project files into the container
COPY . .

# Package the application (you must have mvnw and pom.xml)
RUN ./mvnw clean package -DskipTests

# Run the built JAR file
CMD ["java", "-jar", "target/ems-backend-0.0.1-SNAPSHOT.jar"]
