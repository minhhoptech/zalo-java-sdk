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
public class ZaloOaInfo {

    long oaId = 0;
    String secrect = "";
    String name = "";
    String avatar = "";
    String cover = "";
    String description = "";

    public long getOaId() {
        return oaId;
    }

    public void setOaId(long oaId) {
        this.oaId = oaId;
    }

    public String getSecrect() {
        return secrect;
    }

    public void setSecrect(String secrect) {
        this.secrect = secrect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public ZaloOaInfo(long oaId, String secrect) {
        this.oaId = oaId;
        this.secrect = secrect;
    }

}
