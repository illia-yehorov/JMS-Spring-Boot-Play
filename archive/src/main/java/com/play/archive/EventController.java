/*
 * © EVRY. All rights reserved.
 * This code/information is protected by national and international law and may not be used, copied, amended, compiled,
 * decompiled, transferred etc. without the explicitly written prior consent from EVRY.
 * Any use in violation of the said will be prosecuted and compensation will be claimed.
 */
package com.play.archive;

import com.play.archive.jpa.EventRepository;
import com.play.common.EventEntity;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/archive")
@CommonsLog
public class EventController {

    @Autowired
    private EventRepository repository;

    @GetMapping(path="/events", produces="application/json")
    public Iterable<EventEntity> getPayments() {
        Iterable<EventEntity> eventEntities = repository.findAll();
        return eventEntities;
    }


}
