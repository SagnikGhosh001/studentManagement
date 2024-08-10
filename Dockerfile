FROM maven:3.8.8-eclipse-temurin-21-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-slim
COPY --from=build /target/springrest-0.0.1-SNAPSHOT.jar springrest.jar
EXPOSE 9090
ENTRYPOINT [ "java","-jar","springrest.jar" ]