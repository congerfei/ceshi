package com.xl.springboot5wxgzh.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 报错报文
 * {
 *     "errcode": 40164,
 *     "errmsg": "invalid ip 59.175.86.46 ipv6 ::ffff:59.175.86.46, not in whitelist rid: 62f4b93a-32a5fe70-7e315b94"
 * }
 * 成功报文
 *
 */
@Data
public class AccessToken {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private Long expiresIn;

    /**
     * 可能也会报错，将报错对象也列举出来
     * @param expiresIn
     */
    @JsonProperty("errcode")
    private String errcode;

    @JsonProperty("errmsg")
    private String errmsg;



    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = System.currentTimeMillis() + expiresIn * 1000;
    }

    @JsonIgnore
    public boolean isExpired() {
        return System.currentTimeMillis() > expiresIn;
    }
}

