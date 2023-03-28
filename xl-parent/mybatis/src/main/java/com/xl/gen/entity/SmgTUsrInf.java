package com.xl.gen.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(SmgTUsrInf)实体类
 *
 * @author xl
 * @since 2020-12-16 13:11:05
 */
public class SmgTUsrInf implements Serializable {
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


    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getUsrNm() {
        return usrNm;
    }

    public void setUsrNm(String usrNm) {
        this.usrNm = usrNm;
    }

    public String getGndCd() {
        return gndCd;
    }

    public void setGndCd(String gndCd) {
        this.gndCd = gndCd;
    }

    public String getCrdtTpcd() {
        return crdtTpcd;
    }

    public void setCrdtTpcd(String crdtTpcd) {
        this.crdtTpcd = crdtTpcd;
    }

    public String getCrdtNo() {
        return crdtNo;
    }

    public void setCrdtNo(String crdtNo) {
        this.crdtNo = crdtNo;
    }

    public String getBlngInsid() {
        return blngInsid;
    }

    public void setBlngInsid(String blngInsid) {
        this.blngInsid = blngInsid;
    }

    public String getUsrTpcd() {
        return usrTpcd;
    }

    public void setUsrTpcd(String usrTpcd) {
        this.usrTpcd = usrTpcd;
    }

    public String getUsrStcd() {
        return usrStcd;
    }

    public void setUsrStcd(String usrStcd) {
        this.usrStcd = usrStcd;
    }

    public String getBrthDt() {
        return brthDt;
    }

    public void setBrthDt(String brthDt) {
        this.brthDt = brthDt;
    }

    public String getTelctcmodMblphNo() {
        return telctcmodMblphNo;
    }

    public void setTelctcmodMblphNo(String telctcmodMblphNo) {
        this.telctcmodMblphNo = telctcmodMblphNo;
    }

    public String getTelctcmodWrkNo() {
        return telctcmodWrkNo;
    }

    public void setTelctcmodWrkNo(String telctcmodWrkNo) {
        this.telctcmodWrkNo = telctcmodWrkNo;
    }

    public String getUsrPost() {
        return usrPost;
    }

    public void setUsrPost(String usrPost) {
        this.usrPost = usrPost;
    }

    public String getRmrk() {
        return rmrk;
    }

    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    public Double getLandCnt() {
        return landCnt;
    }

    public void setLandCnt(Double landCnt) {
        this.landCnt = landCnt;
    }

    public Date getLastUdtDtTm() {
        return lastUdtDtTm;
    }

    public void setLastUdtDtTm(Date lastUdtDtTm) {
        this.lastUdtDtTm = lastUdtDtTm;
    }

    public Date getLastLgnDtTm() {
        return lastLgnDtTm;
    }

    public void setLastLgnDtTm(Date lastLgnDtTm) {
        this.lastLgnDtTm = lastLgnDtTm;
    }

    public String getLastOptUsr() {
        return lastOptUsr;
    }

    public void setLastOptUsr(String lastOptUsr) {
        this.lastOptUsr = lastOptUsr;
    }

    public String getProvCd() {
        return provCd;
    }

    public void setProvCd(String provCd) {
        this.provCd = provCd;
    }

    public String getCityCd() {
        return cityCd;
    }

    public void setCityCd(String cityCd) {
        this.cityCd = cityCd;
    }

    public String getZonCd() {
        return zonCd;
    }

    public void setZonCd(String zonCd) {
        this.zonCd = zonCd;
    }

    public String getStrCd() {
        return strCd;
    }

    public void setStrCd(String strCd) {
        this.strCd = strCd;
    }

    public String getInsNm() {
        return insNm;
    }

    public void setInsNm(String insNm) {
        this.insNm = insNm;
    }

    public String getLawNo() {
        return lawNo;
    }

    public void setLawNo(String lawNo) {
        this.lawNo = lawNo;
    }

    public String getCurRlId() {
        return curRlId;
    }

    public void setCurRlId(String curRlId) {
        this.curRlId = curRlId;
    }

    public String getCurBlngInsid() {
        return curBlngInsid;
    }

    public void setCurBlngInsid(String curBlngInsid) {
        this.curBlngInsid = curBlngInsid;
    }

    public Date getInptTm() {
        return inptTm;
    }

    public void setInptTm(Date inptTm) {
        this.inptTm = inptTm;
    }

    public Date getLastPswdDtTm() {
        return lastPswdDtTm;
    }

    public void setLastPswdDtTm(Date lastPswdDtTm) {
        this.lastPswdDtTm = lastPswdDtTm;
    }

    public String getUsrIdMd5() {
        return usrIdMd5;
    }

    public void setUsrIdMd5(String usrIdMd5) {
        this.usrIdMd5 = usrIdMd5;
    }

    public String getTelctcmodMblphNoMd5() {
        return telctcmodMblphNoMd5;
    }

    public void setTelctcmodMblphNoMd5(String telctcmodMblphNoMd5) {
        this.telctcmodMblphNoMd5 = telctcmodMblphNoMd5;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

}