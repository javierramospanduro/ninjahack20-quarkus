FROM php

RUN apt-get update && apt-get install -y libpq-dev && docker-php-ext-install pdo pdo_pgsql 

RUN set -ex; \
        docker-php-source extract; \
        { \
                echo '# https://github.com/docker-library/php/issues/103#issuecomment-271413933'; \
                echo 'AC_DEFUN([PHP_ALWAYS_SHARED],[])dnl'; \
                echo; \
                cat /usr/src/php/ext/odbc/config.m4; \
        } > temp.m4; \
        mv temp.m4 /usr/src/php/ext/odbc/config.m4; \
        apt-get update; \
        apt-get install -y --no-install-recommends unixodbc-dev; \
        docker-php-ext-configure odbc --with-unixODBC=shared,/usr; \
        docker-php-ext-install odbc; \
        docker-php-source delete; \
        apt-get purge -y --auto-remove
		
RUN docker-php-ext-install odbc

WORKDIR /app
EXPOSE 8080

COPY www /app
CMD ["-S","0.0.0.0:8080"]
