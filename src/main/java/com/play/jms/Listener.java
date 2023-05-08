package com.play.jms;

import static com.play.Application.QUEUE_DESTINATION;
import static com.play.Application.TOPIC_DESTINATION;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @JmsListener(destination = TOPIC_DESTINATION, containerFactory = "myFactory")
    public void topic1(String string) {
        LOGGER.info("[topic1] Received message <" + string + ">");
    }

    @JmsListener(destination = TOPIC_DESTINATION, containerFactory = "myFactory")
    public void topic2(String string) {
        LOGGER.info("[topic2] Received message <" + string + ">");
    }

    @JmsListener(destination = TOPIC_DESTINATION, containerFactory = "myFactory")
    public void topic3(String string) {
        LOGGER.info("[topic3] Received message <" + string + ">");
    }

    @JmsListener(destination = QUEUE_DESTINATION, containerFactory = "myFactory")
    public void queue(String string) {
        LOGGER.info("[queue] Received message <" + string + ">");
    }

}
