/*
 * © EVRY. All rights reserved.
 * This code/information is protected by national and international law and may not be used, copied, amended, compiled,
 * decompiled, transferred etc. without the explicitly written prior consent from EVRY.
 * Any use in violation of the said will be prosecuted and compensation will be claimed.
 */
package com.play.jms;

import static com.play.Application.QUEUE_DESTINATION;
import static com.play.Application.TOPIC_DESTINATION;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jms")
public class Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    private int topicMessageId = 0;
    private int queueMessageId = 0;

    @Autowired
    JmsTemplate jmsTemplate;

    @GetMapping("queue")
    public void sendToQueue(@RequestParam String event, @RequestParam int number){
        if (number < 0) return;
        for (int i = 0; i < number; i++) {
            String message = "id" + queueMessageId++ + ", " + event;
            jmsTemplate.convertAndSend(QUEUE_DESTINATION, new Event(queueMessageId, message));
            LOGGER.info("Sent message to queue: " + message);
        }
    }

    @GetMapping("topic")
    public void sendToTopic(@RequestParam String event, @RequestParam int number){
        if (number < 0) return;
        for (int i = 0; i < number; i++) {
            String message = "id" + topicMessageId++ + ", " + event;
            jmsTemplate.convertAndSend(TOPIC_DESTINATION, new Event(topicMessageId, message));
            LOGGER.info("message sent to topic: " + message);
        }
    }

}
