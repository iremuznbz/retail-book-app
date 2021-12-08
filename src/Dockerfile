FROM maven:3.8.4-jdk-11-slim
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn package
CMD java -jar -Dspring.profiles.active=docker target/retail-book-0.0.1-SNAPSHOT.jar
