/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.oa.message;

import com.google.gson.JsonObject;

/**
 *
 * @author nghiadc
 */
public class OpenSMSAction extends MsgAction {
    protected String content;
    protected String phoneCode;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }
    
    @Override
    public String getAction() {
        return "oa.open.sms";
    }
    @Override
    public String getHref() {
        return null;
    }
    @Override
    public Object getData() {
        JsonObject obj = new JsonObject();
        obj.addProperty("content", content);
        obj.addProperty("phoneCode", phoneCode);
        return obj;
    }

    
}
