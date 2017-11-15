/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.app;

/**
 *
 * @author nguyenhc2
 */
public class Zalo3rdAppInfo {

    private long appId;
    private String secretKey;
    private String callbackUrl;

    public Zalo3rdAppInfo(long appId, String secretKey, String callbackUrl) {
        this.appId = appId;
        this.secretKey = secretKey;
        this.callbackUrl = callbackUrl;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

}
