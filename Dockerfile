FROM amazoncorretto:17
WORKDIR /app
ARG JAR_FILE=target/rowr.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]