/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.example;

import com.google.gson.JsonObject;
import com.vng.zalo.sdk.APIConfig;
import com.vng.zalo.sdk.oa.ZaloAppInfo;
import com.vng.zalo.sdk.oa.ZaloOaClient;
import com.vng.zalo.sdk.oa.ZaloOaInfo;
import com.vng.zalo.sdk.oa.message.MsgAction;
import com.vng.zalo.sdk.oa.message.MsgGif;
import com.vng.zalo.sdk.oa.message.MsgImage;
import com.vng.zalo.sdk.oa.message.MsgLink;
import com.vng.zalo.sdk.oa.message.OpenInAppAction;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author linhndh
 */
public class TestOAOnbehalfApi {

    public static String getLogin(ZaloOaClient client) {
        try {
            String url = client.getLoginOAUrl();
            return url;
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }

    public static JsonObject getUserFollowOA(ZaloOaClient client, long uid, String accessTok) {
        try {
            JsonObject result = client.getProfile(uid, accessTok);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static JsonObject getOAInfo(ZaloOaClient client, String accessTok) {
        try {
            JsonObject result = client.getOAInfo(accessTok);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static JsonObject getOAConversation(ZaloOaClient client, long uid, String accessTok, int offset, int count) {
        try {
            JsonObject result = client.getOAConversation(uid, accessTok, offset, count);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static JsonObject getOARecentChat(ZaloOaClient client, String accessTok, int offset, int count) {
        try {
            JsonObject result = client.getOAListRecentChat(accessTok, offset, count);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static JsonObject uploadPhotoFromPath(ZaloOaClient client, String filePath, String accessTok) {
        try {
            JsonObject result = client.uploadPhoto(filePath, accessTok);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static JsonObject uploadPhotoFromUrl(ZaloOaClient client, String url, String accessTok) {
        try {
            APIConfig.setTempDir("/home/linhndh/temp");
            JsonObject result = client.uploadPhotoFromUrl(url, accessTok);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static JsonObject uploadGifPhotoFromPath(ZaloOaClient client, String filePath, String accessTok) {
        try {
            JsonObject result = client.uploadGifPhoto(filePath, accessTok);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static JsonObject uploadGifPhotoFromUrl(ZaloOaClient client, String url, String accessTok) {
        try {
            APIConfig.setTempDir("/home/linhndh/temp");
            JsonObject result = client.uploadGifPhotoFromUrl(url, accessTok);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static JsonObject sendTextMessage(ZaloOaClient client, long uid, String message, String accessTok) {
        try {
            JsonObject result = client.sendTextMessage(uid, message, accessTok);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static JsonObject sendImageMessage(ZaloOaClient client, long uid, String accessTok) {
        try {
            MsgImage imageMsg = new MsgImage();
            imageMsg.setImageid("");
            imageMsg.setMessage("hello");
            JsonObject result = client.sendImageMessage(uid, imageMsg, accessTok);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static JsonObject sendLinksMessage(ZaloOaClient client, long uid, String accessTok) {
        try {
            MsgLink link = new MsgLink();
            link.setLinktitle("title");
            link.setLinkthumb("https://upload.wikimedia.org/wikipedia/commons/7/79/2010-brown-bear.jpg");
            link.setLinkdes("description");
            link.setLink("https://developers.zalo.me/docs/api/official-account-open-api/oa-onbehalf-api/gui-tin-nhan-dang-lien-ket-post-608");
            List<MsgLink> links = Arrays.asList(link);
            JsonObject result = client.sendLinkMessage(uid, links, accessTok);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static JsonObject sendActionMessage(ZaloOaClient client, long uid, String accessTok) {
        try {
            MsgAction action = new OpenInAppAction();
            action.setTitle("Title");
            action.setThumb("https://upload.wikimedia.org/wikipedia/commons/7/79/2010-brown-bear.jpg");
//            action.setPopup(null);
            action.setDescription("Hello");
            List<MsgAction> actions = Arrays.asList(action);
            JsonObject result = client.sendActionMessage(uid, actions, accessTok);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static JsonObject sendStickerMessage(ZaloOaClient client, long uid, String stickerId, String accessTok) {
        try {
            JsonObject result = client.sendStickerMessage(uid, stickerId, accessTok);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static JsonObject sendGifMessage(ZaloOaClient client, long uid, String accessTok) {
        try {
            MsgGif gif = new MsgGif();
            gif.setImageid("");
            gif.setHeight(200);
            gif.setWidth(200);
            JsonObject result = client.sendGifMessage(uid, gif, accessTok);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static JsonObject replyTextMessage(ZaloOaClient client, String accessTok) {
        try {
            String msgId = "";

            JsonObject result = client.replyTextMessage(msgId, "Hello", accessTok);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static JsonObject replyImageMessage(ZaloOaClient client, String accessTok) {
        try {
            String msgId = "";

            MsgImage imageMsg = new MsgImage();
            imageMsg.setImageid("");
            imageMsg.setMessage("hello");
            JsonObject result = client.replyImageMessage(msgId, imageMsg, accessTok);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static JsonObject replyLinksMessage(ZaloOaClient client, String accessTok) {
        try {
            String msgId = "";

            MsgLink link = new MsgLink();
            link.setLinktitle("title");
            link.setLinkthumb("https://upload.wikimedia.org/wikipedia/commons/7/79/2010-brown-bear.jpg");
            link.setLinkdes("description");
            link.setLink("https://developers.zalo.me/docs/api/official-account-open-api/oa-onbehalf-api/gui-tin-nhan-dang-lien-ket-post-608");
            List<MsgLink> links = Arrays.asList(link);
            JsonObject result = client.replyLinksMessage(msgId, links, accessTok);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        ZaloAppInfo appInfo = new ZaloAppInfo(0l, "", "");
        /*==========================================*/
        ZaloOaClient client = new ZaloOaClient(appInfo);
        /*==========================================*/
        String url = getLogin(client);
        System.out.println(url);
        /*==========================================*/
        long uid = 0l;
        String accessToken = "";
//        System.out.println(getUserFollowOA(client, uid, accessToken));
        /*==========================================*/
//        System.out.println(getOAInfo(client, accessToken));
        /*==========================================*/
//        System.out.println(getOAConversation(client, uid, accessToken, 0, 10));
        /*==========================================*/
//        System.out.println(getOARecentChat(client, accessToken, 0, 10));
//        /*==========================================*/
//        System.out.println(uploadPhotoFromPath(client, "/home/linhndh/Pictures/brainy.jpg", accessToken));
//        /*==========================================*/
//        System.out.println(uploadPhotoFromUrl(client, "https://upload.wikimedia.org/wikipedia/commons/7/79/2010-brown-bear.jpg", accessToken));
//        /*==========================================*/
//        System.out.println(uploadGifPhotoFromPath(client, "/home/linhndh/Pictures/earth.gif", accessToken));
        /*==========================================*/
//        System.out.println(uploadGifPhotoFromUrl(client, "https://gifimage.net/wp-content/uploads/2017/06/bear-gif-15.gif", accessToken));
        /*==========================================*/
//        System.out.println(sendTextMessage(client, uid, "Hello Tung", accessToken));
        /*==========================================*/
//        System.out.println(sendImageMessage(client, uid, accessToken));
        /*==========================================*/
//        System.out.println(sendLinksMessage(client, uid, accessToken));
        /*==========================================*/
//        System.out.println(sendActionMessage(client, uid, accessToken));
        /*==========================================*/
//        System.out.println(sendStickerMessage(client, uid, "stickerId", accessToken));
        /*==========================================*/
//        System.out.println(sendGifMessage(client, uid, accessToken));
        /*==========================================*/
//        System.out.println(replyTextMessage(client, accessToken));
        /*==========================================*/
//        System.out.println(replyImageMessage(client, accessToken));
        /*==========================================*/
//        System.out.println(replyLinksMessage(client, accessToken));
        System.exit(0);
    }
}
