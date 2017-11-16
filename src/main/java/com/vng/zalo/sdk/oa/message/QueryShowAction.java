/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.oa.message;

/**
 *
 * @author nghiadc
 */
public class QueryShowAction extends MsgAction {

    protected String data;

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String getAction() {
        return "oa.query.show";
    }

    @Override
    public String getHref() {
        return null;
    }

    @Override
    public Object getData() {
        return data;
    }
}
