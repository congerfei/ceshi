package com.xl.springboot5wxgzh.domain.msg;

import lombok.Data;

@Data
public class BaseMessage {
    private String toUserName;
    private String fromUserName;
    private Long createTime;
    private String msgType;
    private String msgId;
}