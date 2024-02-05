FROM eclipse-temurin:17-jdk-alpine
WORKDIR /

CMD ["./gradlew clean bootJar"]
COPY /build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./app.jar"]