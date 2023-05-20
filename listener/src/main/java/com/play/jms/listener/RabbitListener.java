package com.play.jms.listener;

import static com.play.jms.listener.ListenerApplication.QUEUE_DESTINATION;
import static com.play.jms.listener.ListenerApplication.TOPIC_DESTINATION;

import com.play.common.Event;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@CommonsLog
public class RabbitListener {

    @JmsListener(destination = TOPIC_DESTINATION, containerFactory = "myFactory")
    public void topic1(Event event) {
        log.info("[topic1] Received event object <" + event.getMessage() + ">");
    }

    @JmsListener(destination = TOPIC_DESTINATION, containerFactory = "myFactory")
    public void topic2(Event event) {
        log.info("[topic2] Received event object <" + event.getMessage() + ">");
    }

    @JmsListener(destination = TOPIC_DESTINATION, containerFactory = "myFactory")
    public void topic3(Event event) {
        log.info("[topic3] Received event object <" + event.getMessage() + ">");
    }

    @JmsListener(destination = QUEUE_DESTINATION, containerFactory = "myFactory")
    public void queue(Event event) {
        log.info("[queue] Received event object <" + event.getMessage() + ">");
    }

}
