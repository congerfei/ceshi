package com.xl.springbootxl.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * T_USR_RL_REL_INF
 * @author 
 */
@Data
public class TUsrRlRelInf implements Serializable {
    private String usrId;

    private String rlId;

    private Date lastUdtDtTm;

    private String lastOptUsr;

    private String usrRlStcd;

    private static final long serialVersionUID = 1L;
}