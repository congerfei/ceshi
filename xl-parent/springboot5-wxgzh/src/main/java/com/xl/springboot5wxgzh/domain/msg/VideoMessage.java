package com.xl.springboot5wxgzh.domain.msg;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class VideoMessage extends BaseMessage {
    private String mediaId;
    private String thumbMediaId;
}
