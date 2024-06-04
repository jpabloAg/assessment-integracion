FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/torneo.micro-one.jar /app
EXPOSE 8080
CMD ["java", "-jar", "torneo.micro-one.jar"]