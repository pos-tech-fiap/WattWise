# docker build -f Dockerfile -t wattwise-local .
# docker run -p 5432:5432 -v $(pwd):/wattwise/ wattwise-local

FROM postgres:latest

ENV POSTGRES_DB wattwise
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres

COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 5432