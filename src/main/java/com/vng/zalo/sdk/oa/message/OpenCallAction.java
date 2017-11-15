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
public class OpenCallAction extends MsgAction {
    protected String phoneCode;

   
    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }
    
    @Override
    public String getAction() {
        return "oa.open.phone";
    }
    @Override
    public String getHref() {
        return null;
    }
    @Override
    public Object getData() {
        JsonObject obj = new JsonObject();
        obj.addProperty("phoneCode", phoneCode);
        return obj;
    }

    
}
