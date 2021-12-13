FROM maven:3.8.4-jdk-11-slim
WORKDIR /retail-book
COPY pom.xml ./
COPY src ./src
RUN mvn clean
RUN mvn package
CMD java -jar target/retail-book-0.0.1-SNAPSHOT.jar

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} retail-book-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/retail-book-1.0-SNAPSHOT.jar"]