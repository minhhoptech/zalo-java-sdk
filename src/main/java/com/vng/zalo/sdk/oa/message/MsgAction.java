/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.oa.message;

import com.google.gson.JsonObject;
import com.vng.zalo.sdk.utils.JsonUtils;

/**
 *
 * @author nghiadc
 */
public abstract class MsgAction {

    protected String title;
    protected String description;
    protected String thumb;
    protected String action;

    public MsgAction() {
        this.action = getAction();
    }
    
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getThumb() {
        return thumb;
    }

    public abstract String getAction();

    public abstract String getHref();

    public abstract Object getData();

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
    JsonObject popup;

    public JsonObject getPopup() {
        return popup;
    }

    public void setPopup(JsonObject popup) {
        this.popup = popup;
    }

    @Override
    public String toString() {
        return JsonUtils.toJsonString(this);
    }

}
