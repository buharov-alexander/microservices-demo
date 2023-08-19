# Microservices Demo

It is a demo project where we created two services and configured communication via Kafka.

![](https://github.com/buharov-alexander/microservices-demo/blob/master/common/src/main/resources/Schema.png)

- Producer service takes jokes from third party service and sends them to Kafka.
- Consumer service takes jokes from Kafka and saves them to MongoDB.

## Build JARs
Create JAR artifacts for producer and consumer.
Execute command in corresponded folder:
```
mvn clean package
```
JAR file will be created in `target` folder.

## Build docker images
Each service has `Dockerfile` to create the docker image ([producer](https://hub.docker.com/repository/docker/buharovalexander/microservices-demo-producer/general) and [consumer](https://hub.docker.com/repository/docker/buharovalexander/microservices-demo-consumer/general)).  
Commands to create docker images:
```
docker build -t buharovalexander/microservices-demo-producer:latest ./producer
docker build -t buharovalexander/microservices-demo-consumer:latest ./consumer
```
Commands to push images into dockerhub:
```
docker push buharovalexander/microservices-demo-producer:latest
docker push buharovalexander/microservices-demo-consumer:latest
```

## Launch using docker-compose
You can use Docker Compose to fast deploy ([configuration](https://github.com/buharov-alexander/microservices-demo/blob/master/common/src/main/docker-compose.yml)).
```
docker-compose up
```
This command starts next containers:
- Zookeeper
- Kafka
- MongoDB
- Producer
- Consumer

## Launch using k8s
Minikube was used to test deploy ([Helm configuration](https://github.com/buharov-alexander/microservices-demo/blob/master/common/src/main/helm-chart)).
Manage Minikube:
```
minikube status|start|stop
```
Deploy the demo project into Minikube:
```
helm install my-release ./helm-chart
```
This command starts next deployments and services:
- Zookeeper
- Kafka
- MongoDB
- Producer
- Consumer

Command to get access to services:
```
minikube service producer-service consumer-service
```

## Test services
Send HTTP request `GET-/jokes/random/send` to producer and a random joke will be saved into MongoDB.  
Send HTTP request `GET-/jokes/list` to consumer and you will get list of saved jokes.
