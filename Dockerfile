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

# Start a new stage for the runtime image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the built artifact from the builder stage
COPY --from=builder /app/target/*.jar ./app.jar

# Add WebDriver for your browser testing (e.g., ChromeDriver)
# Example for ChromeDriver
ADD https://storage.googleapis.com/chrome-for-testing-public/123.0.6312.122/linux64/chrome-linux64.zip .
RUN unzip chromedriver_linux64.zip -d /usr/local/bin && rm chromedriver_linux64.zip

# Define any environment variables needed
# ENV VARIABLE_NAME=value

# Run the application
CMD ["java", "-jar", "app.jar"]
