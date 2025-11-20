# Use the Eclipse Temurin JDK Alpine image
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory to the webservice folder
WORKDIR /app/webservice

# Copy the webservice folder contents into the container
COPY webservice/ ./ 

# Copy the start.sh if needed
COPY start.sh /app/start.sh
RUN chmod +x /app/start.sh

# Build the app with Maven
RUN ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install

# Expose default Spark/HTTP port if needed
EXPOSE 4567

# Run the app (finds the JAR inside target folder)
CMD ["sh", "-c", "java -jar target/*.jar"]
