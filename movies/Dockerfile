# ---- Build Stage ----
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# ---- Run Stage ----
FROM eclipse-temurin:17-jdk

WORKDIR /app

# ✅ Add certificates for secure MongoDB connection
RUN apt-get update && apt-get install -y ca-certificates

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
