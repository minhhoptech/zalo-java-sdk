/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.oa;

/**
 *
 * @author nghiadc
 */
public class ZaloAppInfo {
    long appid;
    String secrect;

    public long getAppid() {
        return appid;
    }

    public void setAppid(long appid) {
        this.appid = appid;
    }

    public String getSecrect() {
        return secrect;
    }

    public void setSecrect(String secrect) {
        this.secrect = secrect;
    }

    public ZaloAppInfo(long appid, String secrect) {
        this.appid = appid;
        this.secrect = secrect;
    }
    
    
}
