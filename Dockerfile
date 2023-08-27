# docker build -f Dockerfile -t wattwise-local .
# docker run -p 5432:5432 -v $(pwd):/wattwise/ wattwise-local
FROM postgres:latest

ENV POSTGRES_DB wattwise
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres

COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 5432

#ADICIONAR PARA SUBIR A APP NO MESMO CONTAINER DO BANCO:
## Use a base image with Java 17
#FROM adoptopenjdk/openjdk17:latest

## Set the working directory
#WORKDIR /app

## Copy the .jar file into the container
#COPY YourApp.jar /app/WattWise.jar

## Run the Java application
#CMD ["java", "-jar", "WattWise.jar"]