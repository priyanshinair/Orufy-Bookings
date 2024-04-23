# Use a base image with OpenJDK and Maven installed
FROM maven:3.8-openjdk-17 AS builder

# Set the working directory
WORKDIR /app

# Copy the pom.xml to the working directory
COPY pom.xml .

# Resolve Maven dependencies
RUN mvn dependency:go-offline -B

# Copy the rest of the project
COPY src ./src

# Build the application
RUN mvn package

# Download and unzip Chromedriver
RUN apt-get update && \
    apt-get install -y unzip && \
    apt-get clean && \
    wget -O chromedriver_linux64.zip https://chromedriver.storage.googleapis.com/123.0.6312.122/chromedriver_linux64.zip && \
    unzip chromedriver_linux64.zip -d /usr/local/bin && \
    rm chromedriver_linux64.zip

# Start a new stage for the runtime image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the built artifact from the builder stage
COPY --from=builder /app/target/*.jar ./app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]
