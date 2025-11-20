# Use the Eclipse Temurin JDK Alpine image
FROM eclipse-temurin:21-jdk-alpine

# Install bash and any necessary tools
RUN apk add --no-cache bash

# Set working directory
WORKDIR /app/webservice

# Copy the webservice folder into container
COPY webservice/ ./

# Copy start.sh if needed
COPY start.sh /app/start.sh
RUN chmod +x /app/start.sh

# Make mvnw executable and run with bash
RUN chmod +x mvnw
RUN bash mvnw -B -DskipTests clean install

# Expose Spark/HTTP port
EXPOSE 4567

# Run the app
CMD ["bash", "-c", "java -jar target/*.jar"]
