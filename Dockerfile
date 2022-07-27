FROM openjdk:11

EXPOSE 8080

RUN apt-get update && \
apt-get install -y netcat;

COPY /target/sales-management-0.0.1-SNAPSHOT.jar /app/sales_management.jar
COPY /wait-for-mysql.sh /app/wait-for-mysql.sh
WORKDIR /app
# ENTRYPOINT [ "java", "-jar", "/app/sales_management.jar"]