package com.xl.springboot5wxgzh.domain.msg;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class ImageMessage extends BaseMessage {
    private String picUrl;
    private String mediaId;
}