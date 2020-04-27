# Spring Kafka Consumer Example

Exemplo de consumer com Spring Kafka

## Requerimentos

- JDK 1.8
- Acesso ao repositório https://repo.maven.apache.org/maven2/ ou uma 
alternativa com acesso às dependências presentes no `pom.xml`

## Configurações

Não se preocupe, pois apesar de existirem atalhos pelas variávies
de ambiente, você pode utilizar tranquilamente aquilo que o Spring Boot
oferece. Então veja todos as propriedades no 
[application.properties](./src/main/resources/application.properties)

No caso do Kafka, utilizamos Spring Kafka, então você utilizar 
o modo Spring para configurações.

## Build & Run

### Maven

Para montar o fatjar, execute o comando:

__Linux__

```bash
./mvnw clean package
```

__Windows__

```powershell
.\mvnw.cmd clean package
```

Para executar:

> Você pode utilizar o [`docker-compose.yaml`](./docker-compose.yaml) para
subir um Kafka em sua máquina

```bash
java \
  -Dspring.kafka.bootstrap-servers='localhost:9092' \
  -Dspring.kafka.consumer.client-id='spring-kafka-ex' \
  -Dspring.kafka.consumer.group-id='meu-grupo' \
  -jar target/app-spring-boot.jar
```

### Docker

A definição [Dockerfile](./Dockerfile) desta aplicação emprega 
[multi-stage builds](https://docs.docker.com/develop/develop-images/multistage-build/).
Isso significa que nela acontece o build da aplicação e a criação da imagem.

Se for necessário somente a criar a imagem, pode-se utilizar a definição 
[Dockerfile-image](./Dockerfile-image). Mas antes é necessário montar
o fatjar através do maven.

Para build do fatjar e montar a imagem, execute o comando:

```bash
docker build . -t sk-consumer-ex:1.0
```

Para montar apenas a imagem (antes é necessário o build do maven):

```bash
docker build -f Dockerfile-image . -t sk-consumer-ex:1.0
```

Para rodar o container:

> Utilize o [docker-compose](./docker-compose.yaml) e inicie todos os serviços
para testes

```bash
docker run -p 8080:8080 \
       -i --rm \
       sk-consumer-ex:1.0
```

## Cobertura

- Executar os testes

```bash
mvn clean test
```

- Acessar o relatório: `target/site/jacoco/index.html`

## Caminho HTTP p/ Verificações de Saúde

> Health Checks

Essas são configurações comuns quando a implantação do aplicação 
é feita em container, especificamente no Kubernetes.

- [Liveness Probe](https://kubernetes.io/docs/tasks/configure-pod-container/configure-liveness-readiness-startup-probes/#define-a-liveness-http-request)
  - `/actuator/info`

- [Readiness Probe](https://kubernetes.io/docs/tasks/configure-pod-container/configure-liveness-readiness-startup-probes/#define-readiness-probes)
  - `/actuator/health`

## Dicas

### Docker Compose

Neste repositório existe o arquivo [docker-compose.yaml](./docker-compose.yaml),
que inicia todas as partes móveis que a aplicação depende.

Iniciar a stack:

```bash
docker-compose up
```

Serviços presentes na stack

- Kafka: `localhost:9092`
