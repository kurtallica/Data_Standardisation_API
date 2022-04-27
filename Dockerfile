#docker run 8080:8080 standardisation-api

FROM openjdk:11

RUN mkdir -p /kurt/app

COPY ./target/data-standardisation-api-1.0.0-spring-boot.jar /kurt/app

WORKDIR /kurt/app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "data-standardisation-api-1.0.0-spring-boot.jar"]