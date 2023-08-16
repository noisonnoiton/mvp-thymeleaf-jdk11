FROM maven:3.8.5-openjdk-11 as build
WORKDIR /workspace/app
COPY pom.xml .
COPY src src
RUN mvn clean package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:11-slim-buster
RUN mkdir -p /app/bin
COPY --from=build /workspace/app/target/mvp-thymeleaf-jdk11-0.0.1-SNAPSHOT.jar /app/bin/app.jar
CMD java $JAVA_OPTS -jar /app/bin/app.jar
