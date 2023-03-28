package com.xl.springboot5wxgzh.domain.msg;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class LinkMessage extends BaseMessage{
    private String title;
    private String description;
    private String url;
}
