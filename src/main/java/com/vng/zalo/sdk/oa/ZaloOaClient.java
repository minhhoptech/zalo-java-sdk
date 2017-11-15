/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.oa;

import com.vng.zalo.sdk.UploadResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vng.zalo.sdk.APIConfig;
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.SendMessageReponse;
import com.vng.zalo.sdk.ZaloBaseClient;
import com.vng.zalo.sdk.ZaloUser;
import com.vng.zalo.sdk.oa.message.MsgAction;
import com.vng.zalo.sdk.oa.message.MsgGif;
import com.vng.zalo.sdk.oa.message.MsgImage;
import com.vng.zalo.sdk.oa.message.MsgLink;
import com.vng.zalo.sdk.oa.message.MsgStatus;
import com.vng.zalo.sdk.utils.JsonUtils;
import com.vng.zalo.sdk.utils.MacUtils;
import com.vng.zalo.sdk.utils.ResponseUtils;
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

    ZaloOaInfo oaInfo;

    public ZaloOaClient(ZaloOaInfo info) {
        oaInfo = info;
    }
    
    public static final String GET_PROFILE_ENDPOINT = String.format("%s/%s/getprofile",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    public JsonObject getProfile(long userid) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        params.put("uid", String.valueOf(userid));
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), userid, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpGetRequest(GET_PROFILE_ENDPOINT, params, APIConfig.DEFAULT_HEADER);
        return parser.parse(response).getAsJsonObject();
    }
    
    public static final String GET_MESSAGE_STATUS_ENDPOINT = String.format("%s/%s/getmessagestatus",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    public JsonObject getMessageStatus(String msgid) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("oaid", String.valueOf(oaInfo.getOaId()));
        params.put("msgid", msgid);
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(oaInfo.getOaId(), msgid, timestamp, oaInfo.getSecrect());
        params.put("mac", mac);
        JsonParser parser = new JsonParser();
        String response = sendHttpGetRequest(GET_MESSAGE_STATUS_ENDPOINT, params, APIConfig.DEFAULT_HEADER);
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
    
    static String SEND_MESSAGE_CUSTOMER_CARE_BY_PHONE_ENDPOINT = String.format("%s/%s/sendmessage/phone/cs",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    public JsonObject sendMessageCustomerCareByPhone(long phone, String templateid, JsonObject templatedata) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("phone", phone);
        data.addProperty("templateid", templateid);
        data.add("templatedata", templatedata);
        return sendMessageRequest(SEND_MESSAGE_CUSTOMER_CARE_BY_PHONE_ENDPOINT, data.toString());
    }
    
    static String SEND_MESSAGE_CUSTOMER_CARE_BY_USERID_ENDPOINT = String.format("%s/%s/sendmessage/cs",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    public JsonObject sendMessageCustomerCareByUserId(long userid, String templateid, JsonObject templatedata) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", userid);
        data.addProperty("templateid", templateid);
        data.add("templatedata", templatedata);
        return sendMessageRequest(SEND_MESSAGE_CUSTOMER_CARE_BY_USERID_ENDPOINT, data.toString());
    }

    private final String ACTION_MESSAGE_ENDPOINT = String.format("%s/%s/sendmessage/actionlist",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    public JsonObject sendActionMessage(long uid, List<MsgAction> actions) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        JsonArray arr = new JsonArray();
        for (MsgAction action : actions) {
            arr.add(JsonUtils.toJsonElement(action));
        }
        data.add("actionlist", arr);
        return sendMessageRequest(ACTION_MESSAGE_ENDPOINT, data.toString());
    }
    
    private final String SEND_LINK_MESSAGE_ENDPOINT = String.format("%s/%s/sendmessage/links",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    public JsonObject sendLinkMessage(long uid, List<MsgLink> links) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        JsonArray arr = new JsonArray();
        for (MsgLink link : links) {
            arr.add(JsonUtils.toJsonElement(link));
        }
        data.add("links", arr);
        return sendMessageRequest(SEND_LINK_MESSAGE_ENDPOINT, data.toString()); 
    }
    
    private final String SEND_IMAGE_MESSAGE_ENDPOINT = String.format("%s/%s/sendmessage/image",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    public JsonObject sendImageMessage(long uid, MsgImage imgMessage) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        data.addProperty("imageid", imgMessage.getImageid());
        data.addProperty("message", imgMessage.getMessage());
        return sendMessageRequest(SEND_IMAGE_MESSAGE_ENDPOINT, data.toString());
    }
    
    private final String SEND_GIF_MESSAGE_ENDPOINT = String.format("%s/%s/sendmessage/gif",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    public JsonObject sendGifMessage(long uid, MsgGif gifMessage) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        data.addProperty("imageid", gifMessage.getImageid());
        data.addProperty("width", gifMessage.getWidth());
        data.addProperty("height", gifMessage.getHeight());
        return sendMessageRequest(SEND_GIF_MESSAGE_ENDPOINT, data.toString());
    }
    
    private final String SEND_TEXT_MESSAGE_ENDPOINT = String.format("%s/%s/sendmessage/text",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    public JsonObject sendTextMessage(long uid, String message) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        data.addProperty("message", message);
        return sendMessageRequest(SEND_TEXT_MESSAGE_ENDPOINT, data.toString());
    }
    
    private final String SEND_STICKER_MESSAGE_ENDPOINT = String.format("%s/%s/sendmessage/text",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    public JsonObject sendStickerMessage(long uid, String stickerid) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", uid);
        data.addProperty("stickerid", stickerid);
        return sendMessageRequest(SEND_STICKER_MESSAGE_ENDPOINT, data.toString());
    }
     
    static String UPLOAD_PHOTO_ENDPOINT = String.format("%s/%s/upload/image",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    public JsonObject uploadPhoto(String fileName) throws APIException {
        return uploadPhoto(fileName, UPLOAD_PHOTO_ENDPOINT);
    }
    
    public JsonObject uploadPhotoFromUrl(String url) throws APIException {
        return uploadPhotoFromURL(url, UPLOAD_PHOTO_ENDPOINT);
    }
    
    static String UPLOAD_GIF_PHOTO_ENDPOINT = String.format("%s/%s/upload/gif",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    public JsonObject uploadGifPhoto(String fileName ) throws APIException {
        return uploadPhoto(fileName, UPLOAD_GIF_PHOTO_ENDPOINT);
    }
    
    public JsonObject uploadGifPhotoFromUrl(String url) throws APIException {
        return uploadPhotoFromURL(url, UPLOAD_GIF_PHOTO_ENDPOINT);
    }
    
    private JsonObject uploadPhotoFromURL(String url, String enpoint) throws APIException {
        try {
            if(APIConfig.TEMPORARY_DIR == null){
                throw new APIException("please init temporary directory by using APIConfig.setTempDir(your_dir)");
            }
            String fileName  = String.format("%s/%s", APIConfig.TEMPORARY_DIR,System.currentTimeMillis());
            File file = new File(fileName);
            FileUtils.copyURLToFile(new URL(url), file);
            JsonObject uploadPhoto = uploadPhoto(file, enpoint);
            file.deleteOnExit();
            return uploadPhoto;
        } catch (Exception ex) {
           throw new APIException(ex);
        }
    }
    
    private final long MAXIMUM_FILE_SIZE = 5242880l;
    private JsonObject uploadPhoto(String fileName, String enpoint) throws APIException {
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
    
    private final String REPLY_TEXT_MESSAGE_ENDPOINT = String.format("%s/%s/sendmessage/reply/text",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    public JsonObject replyTextMessage(String msgid, String message) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("uid", msgid);
        data.addProperty("message", message);
        return sendMessageRequest(REPLY_TEXT_MESSAGE_ENDPOINT, data.toString());
    }
    
    private final String REPLY_IMAGE_MESSAGE_ENDPOINT = String.format("%s/%s/sendmessage/reply/image",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    public JsonObject replyImageMessage(String msgid, String imageid, String message) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("msgid", msgid);
        data.addProperty("imageid", imageid);
        data.addProperty("message", message);
        return sendMessageRequest(REPLY_IMAGE_MESSAGE_ENDPOINT, data.toString());
    }
    
    private final String REPLY_LINKS_MESSAGE_ENDPOINT = String.format("%s/%s/sendmessage/reply/links",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    public JsonObject replyLinksMessage(String msgid, List<MsgLink> links) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("msgid", msgid);
        JsonArray arr = new JsonArray();
        for (MsgLink link : links) {
            arr.add(JsonUtils.toJsonElement(link));
        }
        data.add("links", arr);
        return sendMessageRequest(REPLY_LINKS_MESSAGE_ENDPOINT, data.toString());
    }
    
    private final String CREATE_QRCODE_ENDPOINT = String.format("%s/%s/qrcode",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    public JsonObject createQRCode(String qrdata, int size) throws APIException {
        JsonObject data = new JsonObject();
        data.addProperty("qrdata", qrdata);
        data.addProperty("size", size);
        return sendMessageRequest(CREATE_QRCODE_ENDPOINT, data.toString());
    }
}
