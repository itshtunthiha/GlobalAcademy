# Use the Eclipse Temurin JDK Alpine image
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory to the webservice folder
WORKDIR /app/webservice

# Copy the webservice folder contents into the container
COPY webservice/ ./ 

# Make mvnw executable
RUN chmod +x mvnw

# Build the app with Maven
RUN ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install

# Expose default Spark/HTTP port
EXPOSE 8080

# Run the app
CMD ["sh", "-c", "java -jar target/*.jar"]
