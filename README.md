# JMS-Spring-Boot-Play

```bash
$ mvn package
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
