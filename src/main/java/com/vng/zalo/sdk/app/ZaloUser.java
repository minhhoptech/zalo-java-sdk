package com.vng.zalo.sdk.app;

import com.vng.zalo.sdk.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    protected long userIdByOA;
    protected int userGender;
    protected String avatar;
    protected Avatar avatars;

    public ZaloUser(String response) throws APIException {
        try {
            JsonParser parser = new JsonParser();
            JsonObject data = parser.parse(response).getAsJsonObject();
            parseProfile(data);
        } catch (JsonSyntaxException | NumberFormatException e) {
            throw new APIException("Parse profile response failed: " + response);
        }
    }

    public ZaloUser(JsonObject jsonProfile) throws APIException {
        parseProfile(jsonProfile);
    }

    private void parseProfile(JsonObject jsonProfile) throws APIException {
        try {
            userIdByOA = Long.valueOf(jsonProfile.get("id") != null ? jsonProfile.get("id").getAsString() : userIdByOA + "");
            displayName = jsonProfile.get("name") != null ? jsonProfile.get("name").getAsString() : "";
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date birthday = sdf.parse(jsonProfile.get("birthday").getAsString());
                birthDate = (int) (birthday.getTime() / 1000);
            } catch (Exception e) {
            }
            userGender = jsonProfile.get("gender") != null ? (jsonProfile.get("gender").getAsString().equals("male") ? 1 : 2) : 0;
            userId = jsonProfile.get("userIdByOA") != null ? jsonProfile.get("userIdByOA").getAsInt() : 0;
            try {
                avatar = jsonProfile.get("picture").getAsJsonObject().get("data").getAsJsonObject().get("url").getAsString();
                if (avatar != null) {
                    avatars = new Avatar();
                    if (avatar.contains("240")) {
                        avatars.set240(avatar);
                    } else {
                        avatars.set120(avatar);
                    }
                }
            } catch (Exception e) {
            }
        } catch (JsonSyntaxException | NumberFormatException e) {
            throw new APIException("Parse profile response failed: " + jsonProfile.toString());
        }
    }

    protected class Avatar {

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

    public long getUserIdByOA() {
        return userIdByOA;
    }

    public void setUserIdByOA(long userIdByOA) {
        this.userIdByOA = userIdByOA;
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

    public String toString() {
        Gson gson = new Gson();
        String toJson = gson.toJson(this);
        return toJson;
    }
}
