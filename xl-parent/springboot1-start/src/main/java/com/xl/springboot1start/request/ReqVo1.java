package com.xl.springboot1start.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 证明springboot的转换器  确实挺厉害的哟
 */
@Data
public class ReqVo1 {

    private BigDecimal count;//前端可以传 数字和字符串 都可以接收---

    private int total; //字符串和数字都能接收

    private Date now;

    private String userId;

}
