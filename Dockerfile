FROM maven:3.9.8-eclipse-temurin-21 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests
EXPOSE 8081
ENTRYPOINT ["java","-jar","/home/app/target/crud-demo-product-supplier-0.0.1-SNAPSHOT.jar"]