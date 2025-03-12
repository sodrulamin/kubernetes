# First stage: Build the application
FROM eclipse-temurin:21-jdk-ubi9-minimal as builder
WORKDIR /application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar

# Second stage: Create the runtime environment
FROM eclipse-temurin:21-jre-ubi9-minimal
WORKDIR /application

# Copy the JAR file from the builder stage
COPY --from=builder /application/application.jar .

# Run the application with java -jar
ENTRYPOINT ["java", "-jar", "application.jar"]
