package com.xl.springbootxl.pojo;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * T_RL_INF
 * @author  xl
 */
@Data
public class TRlInf implements Serializable {
    private String rlId;

    private String rlNm;

    private String rlDsc;

    private LocalDateTime lastUdtDtTm;

    private String provCd;

    private String cityCd;

    private String zonCd;

    private String strCd;

    private String rlLv;

    private String lastOptUsr;

    private String rlStatus;

    private static final long serialVersionUID = 1L;
}