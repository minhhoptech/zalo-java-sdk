package com.vng.zalo.sdk;

import com.google.gson.annotations.SerializedName;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nghiadc
 */
public class ZaloUser {

    protected long userId;
    protected String displayName;
    protected int birthDate;
    protected long userIdByApp;
    protected int userGender;
    protected String avatar;
    protected Avatar avatars;

    public class Avatar {

        @SerializedName("120")
        protected String _120;
        @SerializedName("240")
        protected String _240;

        public String get120() {
            return _120;
        }

        public void set120(String _120) {
            this._120 = _120;
        }

        public String get240() {
            return _240;
        }

        public void set240(String _240) {
            this._240 = _240;
        }

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public long getUserIdByApp() {
        return userIdByApp;
    }

    public void setUserIdByApp(long userIdByApp) {
        this.userIdByApp = userIdByApp;
    }

    public int getUserGender() {
        return userGender;
    }

    public void setUserGender(int userGender) {
        this.userGender = userGender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Avatar getAvatars() {
        return avatars;
    }

    public void setAvatars(Avatar avatars) {
        this.avatars = avatars;
    }
}
