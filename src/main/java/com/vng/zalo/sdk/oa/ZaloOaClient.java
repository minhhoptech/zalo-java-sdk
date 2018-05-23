/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.oa;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.vng.zalo.sdk.APIConfig;
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.EndPoint;
import com.vng.zalo.sdk.ZaloBaseClient;
import com.vng.zalo.sdk.oa.message.MsgAction;
import com.vng.zalo.sdk.oa.message.MsgGif;
import com.vng.zalo.sdk.oa.message.MsgImage;
import com.vng.zalo.sdk.oa.message.MsgLink;
import com.vng.zalo.sdk.utils.JsonUtils;
import com.vng.zalo.sdk.utils.MacUtils;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author nghiadc
 */
public class ZaloOaClient extends ZaloBaseClient {

    private final long MAXIMUM_FILE_SIZE = 5242880l;
    private ZaloOaInfo oaInfo;
    private ZaloAppInfo appInfo;
    public boolean isDebug = false;

    public ZaloOaClient(ZaloOaInfo info) {
        this.oaInfo = info;
    }

    public ZaloOaClient(ZaloAppInfo appInfo) {
        this.appInfo = appInfo;
    }

    public ZaloOaClient(ZaloOaInfo oaInfo, ZaloAppInfo appInfo) {
        this.oaInfo = oaInfo;
        this.appInfo = appInfo;
    }

    public JsonObject sendFollowMessage(long phone, String templateid, JsonObject templatedata, String callbackData) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("phone", phone);
        data.addProperty("templateid", templateid);
        data.add("templatedata", templatedata);
        data.addProperty("callbackdata", callbackData);
        return sendMessageRequest(EndPoint.OA_SEND_FOLLOW_MESSAGE, data.toString());
    }

    public JsonObject getSliceTag() throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpGetRequest(EndPoint.OA_GET_SLICE_TAG, params, APIConfig.DEFAULT_HEADER);
        return parser.parse(response).getAsJsonObject();
    }

    public JsonObject removeTag(String tagName) throws APIException {
        Map<String, String> params = new HashMap<>();
        JsonObject data = new JsonObject();
        data.addProperty("tagName", tagName);
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        params.put("data", data.toString());
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), data.toString(), timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_REMOVE_TAG, params, APIConfig.DEFAULT_HEADER);
        return parser.parse(response).getAsJsonObject();
    }

    public JsonObject removeUserFromTag(long uId, String tagName) throws APIException {
        Map<String, String> params = new HashMap<>();
        JsonObject data = new JsonObject();
        data.addProperty("uid", uId);
        data.addProperty("tagName", tagName);
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        params.put("data", data.toString());
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), data.toString(), timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_REMOVE_USER_FROM_TAG, params, APIConfig.DEFAULT_HEADER);
        return parser.parse(response).getAsJsonObject();
    }

    public JsonObject tagUser(long uId, String tagName) throws APIException {
        Map<String, String> params = new HashMap<>();
        JsonObject data = new JsonObject();
        data.addProperty("uid", uId);
        data.addProperty("tagName", tagName);
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        params.put("data", data.toString());
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), data.toString(), timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_TAG_USER, params, APIConfig.DEFAULT_HEADER);
        return parser.parse(response).getAsJsonObject();
    }

    public JsonObject getProfile(long userid) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        params.put("uid", String.valueOf(userid));
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), userid, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpGetRequest(EndPoint.OA_GET_PROFILE, params, APIConfig.DEFAULT_HEADER);
        return parser.parse(response).getAsJsonObject();
    }

    public JsonObject getMessageStatus(String msgid) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        params.put("msgid", msgid);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), msgid, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpGetRequest(EndPoint.OA_GET_MESSAGE_STATUS, params, APIConfig.DEFAULT_HEADER);
        return parser.parse(response).getAsJsonObject();
    }

    private JsonObject sendMessageRequest(String endpoint, String data) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        params.put("data", data);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), data, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(endpoint, params, APIConfig.DEFAULT_HEADER);
        return parser.parse(response).getAsJsonObject();
    }

    public JsonObject sendMessageCustomerCareByPhone(long phone, String templateid, JsonObject templatedata) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("phone", phone);
        data.addProperty("templateid", templateid);
        data.add("templatedata", templatedata);
        return sendMessageRequest(EndPoint.OA_SEND_MESSAGE_CUSTOMER_CARE_BY_PHONE, data.toString());
    }

    public JsonObject sendMessageCustomerCareByUserId(long userid, String templateid, JsonObject templatedata) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", userid);
        data.addProperty("templateid", templateid);
        data.add("templatedata", templatedata);
        return sendMessageRequest(EndPoint.OA_SEND_MESSAGE_CUSTOMER_CARE_BY_USERID, data.toString());
    }

    public JsonObject sendActionMessage(long uid, List<MsgAction> actions) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        JsonArray arr = new JsonArray();
        for (MsgAction action : actions) {
            arr.add(JsonUtils.toJsonElement(action));
        }
        data.add("actionlist", arr);
        return sendMessageRequest(EndPoint.OA_SEND_ACTION_MESSAGE, data.toString());
    }

    public JsonObject sendLinkMessage(long uid, List<MsgLink> links) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        JsonArray arr = new JsonArray();
        for (MsgLink link : links) {
            arr.add(JsonUtils.toJsonElement(link));
        }
        data.add("links", arr);
        return sendMessageRequest(EndPoint.OA_SEND_LINK_MESSAGE, data.toString());
    }

    public JsonObject sendImageMessage(long uid, MsgImage imgMessage) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        data.addProperty("imageid", imgMessage.getImageid());
        data.addProperty("message", imgMessage.getMessage());
        return sendMessageRequest(EndPoint.OA_SEND_IMAGE_MESSAGE, data.toString());
    }

    public JsonObject sendGifMessage(long uid, MsgGif gifMessage) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        data.addProperty("imageid", gifMessage.getImageid());
        data.addProperty("width", gifMessage.getWidth());
        data.addProperty("height", gifMessage.getHeight());
        return sendMessageRequest(EndPoint.OA_SEND_GIF_MESSAGE, data.toString());
    }

    public JsonObject sendTextMessage(long uid, String message) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        data.addProperty("message", message);
        return sendMessageRequest(EndPoint.OA_SEND_TEXT_MESSAGE, data.toString());
    }

    public JsonObject sendStickerMessage(long uid, String stickerid) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        data.addProperty("stickerid", stickerid);
        return sendMessageRequest(EndPoint.OA_SEND_STICKER_MESSAGE, data.toString());
    }

    public JsonObject uploadPhoto(String fileName) throws APIException {
        return uploadPhotoOA(fileName, EndPoint.OA_UPLOAD_PHOTO);
    }

    public JsonObject uploadPhotoFromUrl(String url) throws APIException {
        return uploadPhotoFromURL(url, EndPoint.OA_UPLOAD_PHOTO);
    }

    public JsonObject uploadGifPhoto(String fileName) throws APIException {
        return uploadPhotoOA(fileName, EndPoint.OA_UPLOAD_GIF_PHOTO);
    }

    public JsonObject uploadGifPhotoFromUrl(String url) throws APIException {
        return uploadPhotoFromURL(url, EndPoint.OA_UPLOAD_GIF_PHOTO);
    }

    private JsonObject uploadPhotoFromURL(String url, String enpoint) throws APIException {
        try {
            if (APIConfig.TEMPORARY_DIR == null) {
                throw new APIException("please init temporary directory by using APIConfig.setTempDir(your_dir)");
            }
            String fileName = String.format("%s/%s", APIConfig.TEMPORARY_DIR, System.currentTimeMillis());
            File file = new File(fileName);
            FileUtils.copyURLToFile(new URL(url), file);
            JsonObject uploadPhoto = uploadPhoto(file, enpoint);
            file.deleteOnExit();
            return uploadPhoto;
        } catch (Exception ex) {
            throw new APIException(ex);
        }
    }

    private JsonObject uploadPhotoOA(String fileName, String enpoint) throws APIException {
        File file = new File(fileName);
        if (file.length() > MAXIMUM_FILE_SIZE) {
            throw new APIException("file size exceeded the maximum size permitted");
        }
        return uploadPhoto(file, enpoint);
    }

    private JsonObject uploadPhoto(File file, String enpoint) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpUploadRequest(enpoint, file, params, APIConfig.DEFAULT_HEADER);
        return parser.parse(response).getAsJsonObject();
    }

    public JsonObject replyTextMessage(String msgid, String message) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("msgid", msgid);
        data.addProperty("message", message);
        return sendMessageRequest(EndPoint.OA_REPLY_TEXT_MESSAGE, data.toString());
    }

    public JsonObject replyImageMessage(String msgid, String imageid, String message) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("msgid", msgid);
        data.addProperty("imageid", imageid);
        data.addProperty("message", message);
        return sendMessageRequest(EndPoint.OA_REPLY_IMAGE_MESSAGE, data.toString());
    }

    public JsonObject replyLinksMessage(String msgid, List<MsgLink> links) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("msgid", msgid);
        JsonArray arr = new JsonArray();
        for (MsgLink link : links) {
            arr.add(JsonUtils.toJsonElement(link));
        }
        data.add("links", arr);
        return sendMessageRequest(EndPoint.OA_REPLY_LINKS_MESSAGE, data.toString());
    }

    public JsonObject createQRCode(String qrdata, int size) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("qrdata", qrdata);
        data.addProperty("size", size);
        return sendMessageRequest(EndPoint.OA_CREATE_QRCODE, data.toString());
    }

    private static String getFileExtension(String filePath) {
        if (filePath.lastIndexOf(".") != -1 && filePath.lastIndexOf(".") != 0) {
            return filePath.substring(filePath.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    public String getLoginOAUrl() throws APIException {
        if (appInfo == null || !appInfo.isSetAppId() || !appInfo.isSetCallBackUrl()) {
            throw new APIException("Please set appid and app secret key before call this api !");
        }
        String url = String.format(EndPoint.LOGIN_OA_ONBEHALF, appInfo.getAppid(), appInfo.getCallBackUrl());
        return url;
    }

    public JsonObject getProfile(long userid, String accessToken) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", userid);
        data.addProperty("accessTok", accessToken);
        return sendHttpGetRequestOnbehalf(EndPoint.OA_ONBEHALF_GET_PROFILE, data.toString());
    }

    public JsonObject getOAInfo(String accessToken) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("accessTok", accessToken);
        return sendHttpGetRequestOnbehalf(EndPoint.OA_ONBEHALF_GET_OFFICAL_ACCOUNT_INFO, data.toString());
    }

    public JsonObject getOAConversation(long uid, String accessToken, int offset, int count) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        data.addProperty("accessTok", accessToken);
        data.addProperty("offset", offset);
        data.addProperty("count", count);
        return sendHttpGetRequestOnbehalf(EndPoint.OA_ONBEHALF_GET_CONVERSATION, data.toString());
    }

    public JsonObject getOAListRecentChat(String accessToken, int offset, int count) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("accessTok", accessToken);
        data.addProperty("offset", offset);
        data.addProperty("count", count);
        return sendHttpGetRequestOnbehalf(EndPoint.OA_ONBEHALF_GET_LIST_RECENT_CHAT, data.toString());
    }

    public JsonObject uploadPhoto(String fileName, String accessToken) throws APIException {
        return uploadPhotoOAOnbehalf(fileName, accessToken, EndPoint.OA_ONBEHALF_UPLOAD_PHOTO);
    }

    public JsonObject uploadPhotoFromUrl(String url, String accessToken) throws APIException {
        return uploadPhotoFromURL(url, accessToken, EndPoint.OA_ONBEHALF_UPLOAD_PHOTO);
    }

    public JsonObject uploadGifPhoto(String fileName, String accessToken) throws APIException {
        return uploadPhotoOAOnbehalf(fileName, accessToken, EndPoint.OA_ONBEHALF_UPLOAD_GIF_PHOTO);
    }

    public JsonObject uploadGifPhotoFromUrl(String url, String accessToken) throws APIException {
        return uploadPhotoFromURL(url, accessToken, EndPoint.OA_ONBEHALF_UPLOAD_GIF_PHOTO);
    }

    private JsonObject uploadPhotoFromURL(String url, String accessToken, String enpoint) throws APIException {
        try {
            if (APIConfig.TEMPORARY_DIR == null) {
                throw new APIException("please init temporary directory by using APIConfig.setTempDir(your_dir)");
            }
            String fileName = String.format("%s/%s", APIConfig.TEMPORARY_DIR, System.currentTimeMillis());
            File file = new File(fileName);
            FileUtils.copyURLToFile(new URL(url), file);
            if (EndPoint.OA_ONBEHALF_UPLOAD_GIF_PHOTO.equals(enpoint) && file.length() > MAXIMUM_FILE_SIZE) {
                throw new APIException("file size exceeded the maximum size permitted");
            }
            JsonObject uploadPhoto = uploadPhoto(file, accessToken, enpoint);
            file.deleteOnExit();
            return uploadPhoto;
        } catch (Exception ex) {
            throw new APIException(ex);
        }
    }

    private JsonObject uploadPhotoOAOnbehalf(String fileName, String accessToken, String enpoint) throws APIException {
        File file = new File(fileName);
        if (EndPoint.OA_ONBEHALF_UPLOAD_GIF_PHOTO.equals(enpoint) && file.length() > MAXIMUM_FILE_SIZE) {
            throw new APIException("file size exceeded the maximum size permitted");
        }
        return uploadPhoto(file, accessToken, enpoint);
    }

    private JsonObject uploadPhoto(File file, String accessToken, String enpoint) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("appid", String.valueOf(appInfo.getAppid()));
        JsonObject data = new JsonObject();
        data.addProperty("accessTok", accessToken);
        String dataParam = data.toString();
        params.put("data", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(appInfo.getAppid(), dataParam, timestamp, appInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpUploadRequest(enpoint, file, params, APIConfig.DEFAULT_HEADER);
        return parser.parse(response).getAsJsonObject();
    }

    public JsonObject sendTextMessage(long uid, String message, String accessToken) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        data.addProperty("message", message);
        data.addProperty("accessTok", accessToken);
        return sendMessageRequestOnbehalf(EndPoint.OA_ONBEHALF_SEND_TEXT_MESSAGE, data.toString());
    }

    public JsonObject sendImageMessage(long uid, MsgImage imgMessage, String accessToken) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        data.addProperty("imageid", imgMessage.getImageid());
        data.addProperty("message", imgMessage.getMessage());
        data.addProperty("accessTok", accessToken);
        return sendMessageRequestOnbehalf(EndPoint.OA_ONBEHALF_SEND_IMAGE_MESSAGE, data.toString());
    }

    public JsonObject sendGifMessage(long uid, MsgGif gifMessage, String accessToken) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        data.addProperty("imageid", gifMessage.getImageid());
        data.addProperty("width", gifMessage.getWidth());
        data.addProperty("height", gifMessage.getHeight());
        data.addProperty("accessTok", accessToken);
        return sendMessageRequestOnbehalf(EndPoint.OA_ONBEHALF_SEND_GIF_MESSAGE, data.toString());
    }

    public JsonObject sendStickerMessage(long uid, String stickerid, String accessToken) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        data.addProperty("accessTok", accessToken);
        data.addProperty("stickerid", stickerid);
        return sendMessageRequestOnbehalf(EndPoint.OA_ONBEHALF_SEND_STICKER_MESSAGE, data.toString());
    }

    public JsonObject sendActionMessage(long uid, List<MsgAction> actions, String accessToken) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        data.addProperty("accessTok", accessToken);
        JsonArray arr = new JsonArray();
        for (MsgAction action : actions) {
            arr.add(JsonUtils.toJsonElement(action));
        }
        data.add("actionlist", arr);
        return sendMessageRequestOnbehalf(EndPoint.OA_ONBEHALF_SEND_ACTION_MESSAGE, data.toString());
    }

    public JsonObject sendLinkMessage(long uid, List<MsgLink> links, String accessToken) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        data.addProperty("accessTok", accessToken);
        JsonArray arr = new JsonArray();
        for (MsgLink link : links) {
            arr.add(JsonUtils.toJsonElement(link));
        }
        data.add("links", arr);
        return sendMessageRequestOnbehalf(EndPoint.OA_ONBEHALF_SEND_LINK_MESSAGE, data.toString());
    }

    public JsonObject replyTextMessage(String msgid, String message, String accessToken) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("msgid", msgid);
        data.addProperty("message", message);
        data.addProperty("accessTok", accessToken);
        return sendMessageRequestOnbehalf(EndPoint.OA_ONBEHALF_REPLY_TEXT_MESSAGE, data.toString());
    }

    public JsonObject replyImageMessage(String msgid, MsgImage imgMessage, String accessToken) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("msgid", msgid);
        data.addProperty("imageid", imgMessage.getImageid());
        data.addProperty("message", imgMessage.getMessage());
        data.addProperty("accessTok", accessToken);
        return sendMessageRequestOnbehalf(EndPoint.OA_ONBEHALF_REPLY_IMAGE_MESSAGE, data.toString());
    }

    public JsonObject replyLinksMessage(String msgid, List<MsgLink> links, String accessToken) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("msgid", msgid);
        data.addProperty("accessTok", accessToken);
        JsonArray arr = new JsonArray();
        for (MsgLink link : links) {
            arr.add(JsonUtils.toJsonElement(link));
        }
        data.add("links", arr);
        return sendMessageRequestOnbehalf(EndPoint.OA_ONBEHALF_REPLY_LINKS_MESSAGE, data.toString());
    }

    private JsonObject sendMessageRequestOnbehalf(String endpoint, String data) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("appid", String.valueOf(appInfo.getAppid()));
        params.put("data", data);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(appInfo.getAppid(), data, timestamp, appInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(endpoint, params, APIConfig.DEFAULT_HEADER);
        return parser.parse(response).getAsJsonObject();
    }

    private JsonObject sendHttpGetRequestOnbehalf(String endpoint, String data) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("appid", String.valueOf(appInfo.getAppid()));
        params.put("data", data);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(appInfo.getAppid(), data, timestamp, appInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpGetRequest(endpoint, params, APIConfig.DEFAULT_HEADER);
        return parser.parse(response).getAsJsonObject();
    }

    public String uploadVideoArticleFromURL(String url) throws APIException {
        try {
            if (APIConfig.TEMPORARY_DIR == null) {
                throw new APIException("please init temporary directory by using APIConfig.setTempDir(your_dir)");
            }
            String fileName = String.format("%s/%s.mp4", APIConfig.TEMPORARY_DIR, System.currentTimeMillis());
            File file = new File(fileName);
            FileUtils.copyURLToFile(new URL(url), file);
            String result = uploadVideoArticle(file);
            file.deleteOnExit();
            return result;
        } catch (Exception ex) {
            throw new APIException(ex);
        }
    }

    public String uploadVideoArticle(File video) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        JsonObject data = new JsonObject();
        data.addProperty("videoName", video.getName());
        data.addProperty("videoSize", video.length());
        String dataParam = data.toString();
        params.put("data", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_ARTICLE_GET_LINK_UPLOAD, params, APIConfig.DEFAULT_HEADER);
        JsonObject resultGetLinkUpload = parser.parse(response).getAsJsonObject();
        int error = resultGetLinkUpload.get("errorCode").getAsInt();
        if (error != 1) {
            String errMsg = resultGetLinkUpload.get("errorMsg").getAsString();
            throw new APIException(error, errMsg);
        }
        String uploadLink = resultGetLinkUpload.get("data").getAsJsonObject().get("uploadLink").getAsString();
        long time = resultGetLinkUpload.get("data").getAsJsonObject().get("time").getAsLong();
        String sig = resultGetLinkUpload.get("data").getAsJsonObject().get("sig").getAsString();
        String appId = resultGetLinkUpload.get("data").getAsJsonObject().get("appId").getAsString();
        // Step 2
        params = new HashMap<>();
        params.put("appId", appId);
        params.put("timestamp", time + "");
        params.put("sig", sig);
        response = sendHttpUploadRequest(uploadLink, video, params, APIConfig.DEFAULT_HEADER);
        JsonObject resultUpload = parser.parse(response).getAsJsonObject();
        error = resultUpload.get("error").getAsInt();
        if (error != 0) {
            String errMsg = resultUpload.get("message").getAsString();
            throw new APIException(error, errMsg);
        }
        String token = resultUpload.get("data").getAsJsonObject().get("token").getAsString();
        // Step 3
        params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        data = new JsonObject();
        data.addProperty("token", token);
        data.addProperty("videoName", video.getName());
        data.addProperty("videoSize", video.length());
        data.addProperty("time", time);
        data.addProperty("sig", sig);
        dataParam = data.toString();
        params.put("data", dataParam);
        timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        parser = new JsonParser();
        response = sendHttpGetRequest(EndPoint.OA_ARTICLE_GET_VIDEO_ID, params, APIConfig.DEFAULT_HEADER);
        JsonObject resultGetVideoStatus = parser.parse(response).getAsJsonObject();
        error = resultGetVideoStatus.get("errorCode").getAsInt();
        if (error != 1) {
            String errMsg = resultGetVideoStatus.get("errorMsg").getAsString();
            throw new APIException(error, errMsg);
        }
        String videoId = resultGetVideoStatus.get("data").getAsJsonObject().get("videoId").getAsString();
        return videoId;
    }

    public JsonObject getArticleVideoUploadStatus(String videoId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        JsonObject data = new JsonObject();
        data.addProperty("videoId", videoId);
        String dataParam = data.toString();
        params.put("data", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpGetRequest(EndPoint.OA_ARTICLE_GET_VIDEO_STATUS, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        int error = result.get("errorCode").getAsInt();
        if (error != 1) {
            String errMsg = result.get("errorMsg").getAsString();
            throw new APIException(error, errMsg);
        }
        return result;
    }

    public JsonObject createArticle(JsonObject data) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        String dataParam = data.toString();
        params.put("media", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_ARTICLE_CREATE_ARTICLE, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject getSliceArticle(int offset, int count) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        JsonObject data = new JsonObject();
        data.addProperty("offset", offset);
        data.addProperty("count", count);
        String dataParam = data.toString();
        params.put("data", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpGetRequest(EndPoint.OA_ARTICLE_GET_SLICE, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject updateMediaArticle(JsonObject data) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        String dataParam = data.toString();
        params.put("data", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_ARTICLE_UPDATE_ARTICLE, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject removeArticle(String mediaId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        params.put("mediaid", mediaId);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), mediaId, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_ARTICLE_REMOVE_ARTICLE, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject getSliceVideoArticle(int offset, int count) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        JsonObject data = new JsonObject();
        data.addProperty("offset", offset);
        data.addProperty("count", count);
        String dataParam = data.toString();
        params.put("data", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpGetRequest(EndPoint.OA_ARTICLE_GET_SLICE_VIDEO, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject updateVideoArticle(JsonObject data) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        String dataParam = data.toString();
        params.put("data", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_ARTICLE_UPDATE_VIDEO, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject createVideoArticle(JsonObject data) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        String dataParam = data.toString();
        params.put("media", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_ARTICLE_CREATE_VIDEO, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject getMediaId(String token) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        params.put("token", token);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), token, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_ARTICLE_GET_MEDIA_ID, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject broadcastArticle(JsonObject data) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        String dataParam = data.toString();
        params.put("data", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_ARTICLE_BROADCAST_MEDIA, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    // Zalo Shop api v
    public JsonObject addVariation(JsonObject data) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        String dataParam = data.toString();
        params.put("data", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_STORE_ADD_VARIATION, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject updateVariation(JsonObject data) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        String dataParam = data.toString();
        params.put("data", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_STORE_UPDATE_VARIATION, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject multiGetAttribute(JsonObject data) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        String dataParam = data.toString();
        params.put("data", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpGetRequest(EndPoint.OA_STORE_MULTI_GET_ATTR_INFO, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject getSliceAttribute(int offset, int count) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        JsonObject data = new JsonObject();
        data.addProperty("offset", offset);
        data.addProperty("count", count);
        String dataParam = data.toString();
        params.put("data", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpGetRequest(EndPoint.OA_STORE_GET_SLICE_ATTR, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject updateAttribute(String attributeId, String name) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        JsonObject data = new JsonObject();
        data.addProperty("attributeid", attributeId);
        data.addProperty("name", name);
        String dataParam = data.toString();
        params.put("data", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_STORE_UPDATE_ATTR, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject createAttribute(String name, String type) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        JsonObject data = new JsonObject();
        data.addProperty("type", type);
        data.addProperty("name", name);
        String dataParam = data.toString();
        params.put("data", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_STORE_CREATE_ATTR, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject getSliceAttributeType(int offset, int count) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        JsonObject data = new JsonObject();
        data.addProperty("offset", offset);
        data.addProperty("count", count);
        String dataParam = data.toString();
        params.put("data", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpGetRequest(EndPoint.OA_STORE_GET_SLICE_ATTR_TYPE, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject createProduct(JsonObject data) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        String dataParam = data.toString();
        params.put("data", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_STORE_CREATE_PRODUCT, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject updateProduct(JsonObject data) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        String dataParam = data.toString();
        params.put("data", dataParam);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), dataParam, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_STORE_UPDATE_PRODUCT, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject removeProduct(String productId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        params.put("productid", productId);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), productId, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_STORE_REMOVE_PRODUCT, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject getProductInfo(String productId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        JsonObject data = new JsonObject();
        data.addProperty("productid", productId);
        params.put("data", data.toString());
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), data.toString(), timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpGetRequest(EndPoint.OA_STORE_GET_PRODUCT_INFO, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject getSliceProduct(int offset, int count) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        JsonObject data = new JsonObject();
        data.addProperty("offset", offset);
        data.addProperty("count", count);
        params.put("data", data.toString());
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), data.toString(), timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpGetRequest(EndPoint.OA_STORE_GET_SLICE_PRODUCT, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject uploadProductPhoto(String fileName) throws APIException {
        return uploadPhotoOA(fileName, EndPoint.OA_STORE_UPLOAD_PRODUCT_PHOTO);
    }

    public JsonObject uploadProductPhotoFromUrl(String url) throws APIException {
        return uploadPhotoFromURL(url, EndPoint.OA_STORE_UPLOAD_PRODUCT_PHOTO);
    }

    public JsonObject createCategory(JsonObject data) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        params.put("data", data.toString());
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), data.toString(), timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_STORE_CREATE_CATEGORY, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject updateCategory(JsonObject data) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        params.put("data", data.toString());
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), data.toString(), timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_STORE_UPDATE_CATEGORY, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject getSliceCategory(int offset, int count) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        JsonObject data = new JsonObject();
        data.addProperty("offset", offset);
        data.addProperty("count", count);
        params.put("data", data.toString());
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), data.toString(), timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpGetRequest(EndPoint.OA_STORE_GET_SLICE_CATEGORY, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject uploadCategoryPhoto(String fileName) throws APIException {
        return uploadPhotoOA(fileName, EndPoint.OA_STORE_UPLOAD_CATEGORY_PHOTO);
    }

    public JsonObject uploadCategoryPhotoFromUrl(String url) throws APIException {
        return uploadPhotoFromURL(url, EndPoint.OA_STORE_UPLOAD_CATEGORY_PHOTO);
    }

    public JsonObject updateOrder(JsonObject data) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        params.put("data", data.toString());
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), data.toString(), timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_STORE_UPDATE_ORDER, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject getSliceOrder(int offset, int count, int filter) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        JsonObject data = new JsonObject();
        data.addProperty("offset", offset);
        data.addProperty("count", count);
        data.addProperty("filter", filter);
        params.put("data", data.toString());
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), data.toString(), timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpGetRequest(EndPoint.OA_STORE_GET_SLICE_ORDER, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject getOrderInfo(String orderId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        params.put("orderid", orderId);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), orderId, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpGetRequest(EndPoint.OA_STORE_GET_ORDER_INFO, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    public JsonObject updateShopInfo(int requireAddress) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        JsonObject orderPolicy = new JsonObject();
        orderPolicy.addProperty("requireAddress", requireAddress);
        JsonObject data = new JsonObject();
        data.add("orderPolicy", orderPolicy);
        params.put("data", data.toString());
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), data.toString(), timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpPostRequest(EndPoint.OA_STORE_UPDATE_SHOP_INFO, params, APIConfig.DEFAULT_HEADER);
        JsonObject result = parser.parse(response).getAsJsonObject();
        return result;
    }

    private static final List<String> IGNORE_FIELDS = Arrays.asList("oaid", "timestamp");

    public JsonObject excuteRequest(String endPoint, String method, Map<String, Object> params) throws APIException {
        File file = null;
        Map<String, String> sortedMap = new TreeMap<>();
        if (params == null) {
            params = new HashMap<>();
        }
        for (Map.Entry<String, Object> entrySet : params.entrySet()) {
            String key = entrySet.getKey();
            Object value = entrySet.getValue();
            if (value instanceof File) {
                file = (File) value;
            } else {
                sortedMap.put(key, value.toString());
            }
        }
        List<String> sequence = new ArrayList<>();
        sequence.add((Long) params.getOrDefault("oaid", 0l) + "");
        for (Map.Entry<String, String> entrySet : sortedMap.entrySet()) {
            String key = entrySet.getKey();
            String value = entrySet.getValue();
            if (!IGNORE_FIELDS.contains(key)) {
                sequence.add(value);
            }
        }
        sequence.add((Long) params.getOrDefault("timestamp", 0l) + "");
        sequence.add(oaInfo.getSecrect());
        String mac = MacUtils.buildMac(sequence.toArray());
        sortedMap.put("mac", mac);
        String response = null;
        if (file != null) {
            response = sendHttpUploadRequest(endPoint, file, sortedMap, APIConfig.DEFAULT_HEADER);
        } else {
            if (isDebug) {
                StringBuilder query  = new StringBuilder();
                for (Map.Entry<String, String> entrySet : sortedMap.entrySet()) {
                    String key = entrySet.getKey();
                    String value = entrySet.getValue();
                    query.append(key).append("=").append(value).append("&");
                }
                System.out.println("DEBUG: METHOD:" + method + " | QUERY: " + endPoint + "?" + query.toString());
            }
            if ("GET".equals(method.toUpperCase())) {
                response = sendHttpGetRequest(endPoint, sortedMap, APIConfig.DEFAULT_HEADER);
            } else {
                response = sendHttpPostRequest(endPoint, sortedMap, APIConfig.DEFAULT_HEADER);
            }
        }
        JsonObject result = null;
        try {
            JsonParser parser = new JsonParser();
            result = parser.parse(response).getAsJsonObject();
        } catch (JsonSyntaxException e) {
            throw new APIException("Response is not json: " + response);
        }
        return result;
    }
}
