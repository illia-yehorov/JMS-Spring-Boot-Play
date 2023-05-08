# JMS-Spring-Boot-Play

## Native run (jdk 17 required)

```bash
$ docker run \
    --name rabbitmq \
    -p 5672:5672 \
    -p 15672:15672 \
    -d rabbitmq:3-management

$ mvn spring-boot:run
```

Open RabbitMQ dashboard [http://localhost:15672](http://localhost:15672) with `guest / guest`.

---

## Running with containers (docker & docker-compose required)

```bash
$ mvn install
$ docker-compose build
$ docker-compose up
```

Open RabbitMQ dashboard [http://localhost:15672](http://localhost:15672) with `guest / guest`.


## Sending messages


```bash
curl --location "http://localhost:58080/jms/topic?event=stop&number=2"
```

```bash
curl --location "http://localhost:58080/jms/queue?event=run&number=3"
```
