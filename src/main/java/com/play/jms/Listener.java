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
    public void topic1(Event event) {
        LOGGER.info("[topic1] Received event object <" + event.getMessage() + ">");
    }

    @JmsListener(destination = TOPIC_DESTINATION, containerFactory = "myFactory")
    public void topic2(Event event) {
        LOGGER.info("[topic1] Received event object <" + event.getMessage() + ">");
    }

    @JmsListener(destination = TOPIC_DESTINATION, containerFactory = "myFactory")
    public void topic3(Event event) {
        LOGGER.info("[topic1] Received event object <" + event.getMessage() + ">");
    }

    @JmsListener(destination = QUEUE_DESTINATION, containerFactory = "myFactory")
    public void queue(Event event) {
        LOGGER.info("[queue] Received event object <" + event.getMessage() + ">");
    }

}
