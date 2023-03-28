package com.xl.springboot5wxgzh.domain.msg;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class TextMessage extends BaseMessage {
    private String content;
}