package com.xl.springboot5wxgzh.domain.event;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class LocationEventMessage extends BaseEventMessage {
    private String latitude;
    private String longitude;
    private String precision;
}
