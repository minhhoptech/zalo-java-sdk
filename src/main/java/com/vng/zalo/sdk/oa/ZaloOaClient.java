/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.oa;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author nghiadc
 */
public class ZaloOaClient extends ZaloBaseClient {

    private final long MAXIMUM_FILE_SIZE = 5242880l;
    private ZaloOaInfo oaInfo;
    private ZaloAppInfo appInfo;

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
}
