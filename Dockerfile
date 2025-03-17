FROM openjdk:17-jdk-alpine

RUN addgroup -S app && adduser -S app -G app

# Copy JAR before switching user
COPY target/*.jar /app.jar

# Ensure correct permissions
RUN chown app:app /app.jar

USER app

ENTRYPOINT ["java", "-jar", "/app.jar"]