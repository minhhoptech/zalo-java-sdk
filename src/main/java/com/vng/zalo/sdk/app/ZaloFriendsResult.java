package com.vng.zalo.sdk.app;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.vng.zalo.sdk.APIException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nghiadc
 */
public class ZaloFriendsResult {

    protected int total;
    protected List<ZaloUser> friends = new ArrayList<>();

    public ZaloFriendsResult(String response) throws APIException {
        try {
            JsonParser parser = new JsonParser();
            JsonObject data = parser.parse(response).getAsJsonObject();
            total = data.get("summary").getAsJsonObject().get("total_count").getAsInt();
            JsonArray jsonFriends = data.get("data").getAsJsonArray();
            for (int i = 0; i < jsonFriends.size(); i++) {
                friends.add(new ZaloUser(jsonFriends.get(i).getAsJsonObject()));
            }
        } catch (JsonSyntaxException | NumberFormatException e) {
            throw new APIException("Parse profile response failed: " + response);
        }
    }

    public String toString() {
        Gson gson = new Gson();
        String toJson = gson.toJson(this);
        return toJson;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ZaloUser> getFriends() {
        return friends;
    }

    public void setFriends(List<ZaloUser> friends) {
        this.friends = friends;
    }

}
