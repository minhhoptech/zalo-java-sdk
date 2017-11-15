/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.app;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vng.zalo.sdk.APIConfig;
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.ZaloBaseClient;
import com.vng.zalo.sdk.utils.StringUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nguyenhc2
 */
public class Zalo3rdAppClient extends ZaloBaseClient {

    private Zalo3rdAppInfo appInfo;

    public Zalo3rdAppClient(Zalo3rdAppInfo appInfo) {
        this.appInfo = appInfo;
    }

    private static String LOGIN_ENPOINT = "https://oauth.zaloapp.com/v3/auth?app_id=%s&redirect_uri=%s";

    public String getLoginUrl() {
        return String.format(LOGIN_ENPOINT, appInfo.getAppId(), appInfo.getCallbackUrl());
    }

    private static String ACCESSTOKEN_ENPOINT = "https://oauth.zaloapp.com/v3/access_token";

    public JsonObject getAccessToken(String oauthCode) throws APIException {
        String response = "";
        try {
            Map<String, String> params = new HashMap<>();
            params.put("app_id", appInfo.getAppId() + "");
            params.put("app_secret", appInfo.getSecretKey());
            params.put("code", oauthCode);
            response = sendHttpGetRequest(ACCESSTOKEN_ENPOINT, params, APIConfig.DEFAULT_HEADER);
            JsonParser parser = new JsonParser();
            return parser.parse(response).getAsJsonObject();
        } catch (Exception e) {
            throw new APIException(response);
        }
    }

    private static String GET_PROFILE_ENPOINT = "https://graph.zalo.me/" + APIConfig.DEFAULT_3RDAPP_API_VERSION + "/me";

    public JsonObject getProfile(String accessToken, String fields) throws APIException {
        String response = "";
        try {
            Map<String, String> params = new HashMap<>();
            params.put("access_token", accessToken);
            params.put("fields", fields);
            response = sendHttpGetRequest(GET_PROFILE_ENPOINT, params, APIConfig.DEFAULT_HEADER);
            JsonParser parser = new JsonParser();
            return parser.parse(response).getAsJsonObject();
        } catch (Exception e) {
            throw new APIException(response);
        }
    }
    private static String GET_FRIENDS_ENPOINT = "https://graph.zalo.me/" + APIConfig.DEFAULT_3RDAPP_API_VERSION + "/me/friends";

    public JsonObject getFriends(String accessToken, int offset, int limit, String fields) throws APIException {
        String response = "";
        try {
            Map<String, String> params = new HashMap<>();
            params.put("access_token", accessToken);
            params.put("offset", offset + "");
            params.put("limit", limit + "");
            params.put("fields", fields);
            response = sendHttpGetRequest(GET_FRIENDS_ENPOINT, params, APIConfig.DEFAULT_HEADER);
            JsonParser parser = new JsonParser();
            return parser.parse(response).getAsJsonObject();
        } catch (Exception e) {
            throw new APIException(response);
        }
    }
    private static String GET_INVITABLE_FRIENDS_ENPOINT = "https://graph.zalo.me/" + APIConfig.DEFAULT_3RDAPP_API_VERSION + "/me/invitable_friends";

    public JsonObject getInvitableFriends(String accessToken, int offset, int limit, String fields) throws APIException {
        String response = "";
        try {
            Map<String, String> params = new HashMap<>();
            params.put("access_token", accessToken);
            params.put("offset", offset + "");
            params.put("limit", limit + "");
            params.put("fields", fields);
            response = sendHttpGetRequest(GET_INVITABLE_FRIENDS_ENPOINT, params, APIConfig.DEFAULT_HEADER);
            JsonParser parser = new JsonParser();
            return parser.parse(response).getAsJsonObject();
        } catch (Exception e) {
            throw new APIException(response);
        }
    }

    private static String POST_FEED_ENPOINT = "https://graph.zalo.me/" + APIConfig.DEFAULT_3RDAPP_API_VERSION + "/me/feed";
    public JsonObject postFeed(String accessToken, String message, String link) throws APIException {
        String response = "";
        try {
            Map<String, String> params = new HashMap<>();
            params.put("access_token", accessToken);
            params.put("message", message);
            params.put("link", link);
            response = sendHttpPostRequest(POST_FEED_ENPOINT, params, APIConfig.DEFAULT_HEADER);
            JsonParser parser = new JsonParser();
            return parser.parse(response).getAsJsonObject();
        } catch (Exception e) {
            throw new APIException(response);
        }
    }

    private static String SEND_APP_REQUEST_ENPOINT = "https://graph.zalo.me/" + APIConfig.DEFAULT_3RDAPP_API_VERSION + "/apprequests";
    public JsonObject sendAppRequest(String accessToken, List<Long> toUserIds, String message) throws APIException {
        String response = "";
        try {
            Map<String, String> params = new HashMap<>();
            params.put("access_token", accessToken);
            params.put("to", StringUtils.join(toUserIds, ","));
            params.put("message", message);
            response = sendHttpPostRequest(SEND_APP_REQUEST_ENPOINT, params, APIConfig.DEFAULT_HEADER);
            JsonParser parser = new JsonParser();
            return parser.parse(response).getAsJsonObject();
        } catch (Exception e) {
            throw new APIException(response);
        }
    }

    private static String SEND_MESSAGE_ENDPOINT = "https://graph.zalo.me/" + APIConfig.DEFAULT_3RDAPP_API_VERSION + "/me/message";
    public JsonObject sendMessage(String accessToken, long userId, String message, String link) throws APIException {
        String response = "";
        try {
            Map<String, String> params = new HashMap<>();
            params.put("access_token", accessToken);
            params.put("to", String.valueOf(userId));
            params.put("message", message);
            params.put("link", link);
            response = sendHttpPostRequest(SEND_MESSAGE_ENDPOINT, params, APIConfig.DEFAULT_HEADER);
            JsonParser parser = new JsonParser();
            return parser.parse(response).getAsJsonObject();
        } catch (Exception e) {
            throw new APIException(response);
        }
    }

}
