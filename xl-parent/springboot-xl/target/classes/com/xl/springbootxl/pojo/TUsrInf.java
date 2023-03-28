package com.xl.springbootxl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表(SmgTUsrInf)实体类
 *
 * @author xl   建议使用lombok ，使用mybatis是需要一个全参的
 * @since 2020-12-16 13:11:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor //一定要有无参，mybatis能用到
public class TUsrInf implements Serializable {
    private static final long serialVersionUID = 687063464007390767L;
    /**
    * 登录名
    */
    private String usrId;
    /**
    * 登录密码
    */
    private String pswd;
    /**
    * 用户名
    */
    private String usrNm;

    private String gndCd;

    private String crdtTpcd;
    /**
    * 身份证
    */
    private String crdtNo;

    private String blngInsid;

    private String usrTpcd;

    private String usrStcd;

    private String brthDt;

    private String telctcmodMblphNo;

    private String telctcmodWrkNo;
    /**
    * 邮政编码
    */
    private String usrPost;

    private String rmrk;

    private Double landCnt;

    private Date lastUdtDtTm;

    private Date lastLgnDtTm;

    private String lastOptUsr;
    /**
    * 省
    */
    private String provCd;
    /**
    * 市
    */
    private String cityCd;
    /**
    * 区
    */
    private String zonCd;
    /**
    * 镇
    */
    private String strCd;
    /**
    * 机构名称
    */
    private String insNm;

    private String lawNo;

    private String curRlId;

    private String curBlngInsid;
    /**
    * 创建时间
    */
    private Date inptTm;
    /**
    * 最后更新时间
    */
    private Date lastPswdDtTm;
    /**
    * 用户id MD5加密
    */
    private String usrIdMd5;
    /**
    * 手机号MD5加密
    */
    private String telctcmodMblphNoMd5;
    /**
    * 创建人
    */
    private String createUser;

}
