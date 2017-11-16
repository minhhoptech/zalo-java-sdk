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
    String callBackUrl;
    boolean appIdIsSet = false;
    boolean secretKeyIsSet = false;
    boolean callBackUrlIsSet = false;

    public long getAppid() {
        return appid;
    }

    public void setAppid(long appid) {
        this.appIdIsSet = true;
        this.appid = appid;
    }

    public String getSecrect() {
        this.secretKeyIsSet = true;
        return secrect;
    }

    public void setSecrect(String secrect) {
        this.secrect = secrect;
    }

    public String getCallBackUrl() {
        this.callBackUrlIsSet = true;
        return callBackUrl;
    }

    public void setCallBackUrl(String cbUrl) {
        this.callBackUrl = cbUrl;
    }

    public boolean isSetAppId() {
        return appIdIsSet;
    }

    public boolean isSetSecretKey() {
        return secretKeyIsSet;
    }

    public boolean isSetCallBackUrl() {
        return callBackUrlIsSet;
    }

    public ZaloAppInfo(long appid, String secrect) {
        this.appIdIsSet = true;
        this.secretKeyIsSet = true;
        this.appid = appid;
        this.secrect = secrect;
    }

    public ZaloAppInfo(long appid, String secrect, String cbUrl) {
        this.appIdIsSet = true;
        this.secretKeyIsSet = true;
        this.callBackUrlIsSet = true;
        this.appid = appid;
        this.secrect = secrect;
        this.callBackUrl = cbUrl;
    }
}
