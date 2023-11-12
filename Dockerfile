# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 as build

# Copy source code to the container
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

# Set the current working directory inside the container
WORKDIR /usr/src/app

# Run mvn clean install to build the application
RUN mvn clean install -DskipTests

# Stage 2: Create the runtime image
FROM openjdk:17-oracle

# Add Maintainer Info
LABEL maintainer="tmatheesh@example.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Copy the jar from the build stage to the runtime image
COPY --from=build /usr/src/app/target/developerIQ-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
