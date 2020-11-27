FROM php

RUN apt-get update && apt-get install -y libpq-dev && docker-php-ext-install pdo pdo_pgsql 
RUN docker-php-ext-install odbc

WORKDIR /app
EXPOSE 8080

COPY www /app
CMD ["-S","0.0.0.0:8080"]
