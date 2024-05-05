FROM maven:3.9.6-eclipse-temurin-21-alpine as build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN --mount=type=cache,target=/root/.m2 mvn -f $HOME/pom.xml clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /usr/app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
