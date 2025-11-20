#!/bin/bash

# Navigate into your webservice folder if your pom.xml is there
cd webservice

# Build the app using Maven (if you use Gradle, adjust accordingly)
mvn clean package

# Run the Spark server
java -cp target/spark-hello-1.0-SNAPSHOT-jar-with-dependencies.jar org.global.academy.Server
