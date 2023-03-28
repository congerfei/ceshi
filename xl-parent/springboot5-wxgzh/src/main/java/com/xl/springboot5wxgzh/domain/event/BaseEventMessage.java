package com.xl.springboot5wxgzh.domain.event;

import com.xl.springboot5wxgzh.domain.msg.BaseMessage;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class BaseEventMessage extends BaseMessage {
    private String event;
}
