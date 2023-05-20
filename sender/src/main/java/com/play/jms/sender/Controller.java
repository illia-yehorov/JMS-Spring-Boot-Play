/*
 * © EVRY. All rights reserved.
 * This code/information is protected by national and international law and may not be used, copied, amended, compiled,
 * decompiled, transferred etc. without the explicitly written prior consent from EVRY.
 * Any use in violation of the said will be prosecuted and compensation will be claimed.
 */
package com.play.jms.sender;

import static com.play.jms.sender.SenderApplication.QUEUE_DESTINATION;
import static com.play.jms.sender.SenderApplication.TOPIC_DESTINATION;

import com.play.common.Event;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jms")
@CommonsLog
public class Controller {

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
            log.info("!Sent to queue: " + message);
        }
    }

    @GetMapping("topic")
    public void sendToTopic(@RequestParam String event, @RequestParam int number){
        if (number < 0) return;
        for (int i = 0; i < number; i++) {
            String message = "id" + topicMessageId++ + ", " + event;
            jmsTemplate.convertAndSend(TOPIC_DESTINATION, new Event(topicMessageId, message));
            log.info("!Sent to topic: " + message);
        }
    }

}
