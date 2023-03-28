package com.xl.springboot5wxgzh.domain.msg;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class LocationMessage  extends BaseMessage {
    private String location_X;
    private String location_Y;
    private Long scale;
    private String label;
}
