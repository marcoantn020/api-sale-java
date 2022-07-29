## Iniciar aplicação
    - docker-compose up [digite o comando na raiz do projeto]


## Erro ao iniciar container
    - na raiz do projeto de permissao ao arquivo wait-for-mysql.sh
        - rode o comando:
            - sudo chmod 777 wait-for-mysql.sh
   

## Dependencias
	- spring-boot-starter-data-jpa
	- spring-boot-starter-web
	- spring-boot-devtools
	- mysql-connector-java
	- spring-boot-starter-test
	- flyway-core
	- spring-boot-starter-validation
	- springfox-swagger2
	- springfox-swagger-ui
	- opentracing-spring-jaeger-web-starter
	- opentracing-jdbc
	- spring-boot-starter-actuator
	- micrometer-registry-prometheus

## Endpoint da Doc
    - http://localhost:8080/swagger-ui.html

## Endpoint do Jaeger
    - http://localhost:16686/search

## Endpoint do Prometheus
    - http://localhost:9090

## Endpoint do Grafana
    - http://localhost:3000
        - user: admin
        - pass: admin