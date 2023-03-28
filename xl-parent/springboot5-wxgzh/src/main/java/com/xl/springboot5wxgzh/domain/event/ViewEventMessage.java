package com.xl.springboot5wxgzh.domain.event;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class ViewEventMessage extends BaseEventMessage {
    private String eventKey;
}