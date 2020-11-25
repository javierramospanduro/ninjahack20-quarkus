FROM nginx

RUN sed -i 's/ 80;$/ 8080;/g' /etc/nginx/conf.d/default.conf
EXPOSE 8080

COPY www /usr/share/nginx/html
