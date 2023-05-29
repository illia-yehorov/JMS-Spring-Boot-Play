package com.play.listener.jms;

import static com.play.listener.ListenerApplication.QUEUE_DESTINATION;
import static com.play.listener.ListenerApplication.TOPIC_DESTINATION;

import com.play.common.Event;
import com.play.common.EventEntity;
import com.play.listener.jpa.EventRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@CommonsLog
public class RabbitListener {

    @Autowired
    private EventRepository repository;

    @JmsListener(destination = TOPIC_DESTINATION, containerFactory = "myFactory")
    public void topic1(Event event) {
        saveEvent(event, TOPIC_DESTINATION + "_1");
    }

    @JmsListener(destination = TOPIC_DESTINATION, containerFactory = "myFactory")
    public void topic2(Event event) {
        saveEvent(event, TOPIC_DESTINATION + "_2");
    }

    @JmsListener(destination = TOPIC_DESTINATION, containerFactory = "myFactory")
    public void topic3(Event event) {
        saveEvent(event, TOPIC_DESTINATION + "_3");
    }

    @JmsListener(destination = QUEUE_DESTINATION, containerFactory = "myFactory")
    public void queue(Event event) {
        saveEvent(event, QUEUE_DESTINATION);
    }

    private void saveEvent(Event event, String destination) {
        log.info("[" + destination + "] Received event object <" + event.getMessage() + ">");
        repository.save(new EventEntity(event.getId(), event.getMessage(), destination));
        log.info("[" + destination + "] event saved");
    }

}
