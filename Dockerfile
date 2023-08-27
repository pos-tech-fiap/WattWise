# docker build -f Dockerfile -t wattwise-local .
# docker run -p 5432:5432 -v $(pwd):/wattwise/ wattwise-local
####POSTGRES INTERFACE
##docker network create pg_network
#docker run -d --network pg_network -p 5050:5050 --name pgadmin-container -e PGADMIN_DEFAULT_EMAIL=wattwise@wattwise.com -e PGADMIN_DEFAULT_PASSWORD=postgres dpage/pgadmin4
###

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