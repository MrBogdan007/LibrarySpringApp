FROM openjdk:19

WORKDIR /

COPY build/libs/*.jar /app/my-spring-boot-app.jar

ENTRYPOINT ["java", "-jar", "/app/my-spring-boot-app.jar"]