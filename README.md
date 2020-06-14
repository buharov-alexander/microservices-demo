# Microservices Demo

It is demo project where we created two services and configured communication via Kafka.

![](https://github.com/buharov-alexander/microservices-demo/blob/master/common/src/main/resources/Schema.png)

- Producer service takes jokes from third party service and sends them to Kafka.
- Consumer service takes jokes from Kafka and saves them to MongoDB.

## Launch
I have created docker images for producer and consumer services.
You can use Docker Compose to fast deploy.
```
docker-compose up
```
This command starts next containers:
- Zookeeper
- Kafka
- MongoDB
- Producer
- Consumer

When all containers will be ran you can send HTTP request `localhost:8080/jokes/random/send` and a random joke will be saved into MongoDB.
