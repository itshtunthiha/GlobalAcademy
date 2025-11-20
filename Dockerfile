# Use Maven + OpenJDK image
FROM maven:3.9.2-eclipse-temurin-17

# Set working directory
WORKDIR /app

# Copy everything
COPY . .

# Build the Maven project
RUN mvn clean package -f webservice/pom.xml

# Expose the port Spark uses
EXPOSE 4567

# Run the Spark app
CMD ["java", "-cp", "webservice/target/spark-hello-1.0-SNAPSHOT-jar-with-dependencies.jar", "org.global.academy.Server"]
