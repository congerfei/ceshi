package com.xl.springboot5wxgzh.domain.event;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class TicketEventMessage extends BaseEventMessage {
    private String eventKey;
    private String ticket;
}
