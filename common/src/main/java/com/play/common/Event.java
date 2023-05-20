/*
 * © EVRY. All rights reserved.
 * This code/information is protected by national and international law and may not be used, copied, amended, compiled,
 * decompiled, transferred etc. without the explicitly written prior consent from EVRY.
 * Any use in violation of the said will be prosecuted and compensation will be claimed.
 */
package com.play.common;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Event {

    private int id;
    private String message;

    public Event(int id, String message) {
        this.id = id;
        this.message = message;
    }
}
