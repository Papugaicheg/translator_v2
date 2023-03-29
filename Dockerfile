
FROM openjdk:17-jdk-alpine as build
WORKDIR translator
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
ARG ApiKey
RUN ./mvnw -DApiKey=${ApiKey} clean package

FROM openjdk:17-jdk-alpine
WORKDIR translator
ARG ApiKey
ENV ApiKey ${ApiKey}

EXPOSE 8080
COPY --from=build /translator/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
