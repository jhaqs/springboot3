FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY . /app
EXPOSE 8085
ENTRYPOINT ["java"]
CMD ["-jar","target/demo-jpa-0.0.1-SNAPSHOT.jar"]
