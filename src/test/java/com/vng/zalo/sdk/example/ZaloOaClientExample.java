package com.vng.zalo.sdk.example;

import com.google.gson.JsonObject;
import com.vng.zalo.sdk.oa.ZaloOaClient;
import com.vng.zalo.sdk.oa.ZaloOaInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nghiadc
 */
public class ZaloOaClientExample {

    public static void main(String[] args) {

        long oaid = 579745863508352884l; // zalo for developer
        String secrect = "pIJESQgIZtK4N1noHd8t";
        ZaloOaInfo info = new ZaloOaInfo(oaid, secrect); // zalo for developer
        ZaloOaClient oaClient = new ZaloOaClient(info);

//        String templateId = "2c5599bda5f84ca615e9";
        try {
//            long userid = 3321115882543943283L;
//            JsonObject profile = oaClient.getProfile(userid);
//            System.out.println(profile);

//            long userid = 3321115882543943283L;
//            String message = "put_your_message_here";
//            JsonObject ret = oaClient.sendTextMessage(userid, message);
//            System.out.println(ret);
//            String msgid = "put_your_msgid_here";
//            JsonObject ret = oaClient.getMessageStatus("a2c40ba0e3e3b4bdedf2");
//            System.out.println(ret);
//            String fileUrl = "/home/cpu10142-local/Downloads/1.jpg";
//            JsonObject ret = oaClient.uploadPhoto(fileUrl);
//            System.out.println(ret);
//            String fileUrl = "/home/cpu10142-local/Downloads/source1.gif";
//            JsonObject ret = oaClient.uploadGifPhoto(fileUrl);
//            System.out.println(ret);
//            long userid = 3321115882543943283L;
//            MsgImage image = new MsgImage();
//            image.setImageid("imageid");
//            image.setMessage("Zalo Java SDK");
//            JsonObject ret = oaClient.sendImageMessage(userid, image);
//            System.out.println(ret);
//            long userid = 3321115882543943283L;
//            MsgGif gif = new MsgGif();
//            gif.setImageid("imageid");
//            gif.setHeight(100);
//            gif.setWidth(100);
//            JsonObject ret = oaClient.sendGifMessage(userid, gif);
//            System.out.println(ret);
//            long userid = 3321115882543943283L;
//            MsgLink link = new MsgLink();
//            link.setLink("https://developers.zalo.me/");
//            link.setLinkdes("Document For Developers");
//            link.setLinkthumb("https://developers.zalo.me/web/static/images/bg.jpg");
//            link.setLinktitle("Zalo For Developers");
//            JsonObject ret = oaClient.sendLinkMessage(userid, Arrays.asList(link));
//            System.out.println(ret);
//            long userid = 3321115882543943283L;
//            MsgAction action = new OpenInAppAction();
//            action.setTitle("Send interactive messages");
//            action.setDescription("This is a test for API send interactive messages");
//            action.setThumb("https://developers.zalo.me/web/static/images/bg.jpg");
//            
//            JsonObject popup = new JsonObject();
//            popup.addProperty("title", "Open Website Zalo For Developers");
//            popup.addProperty("desc", "Click ok to visit Zalo For Developers and read more Document");
//            popup.addProperty("ok", "ok");
//            popup.addProperty("cancel", "cancel");
//            action.setPopup(popup);
//            
//            JsonObject ret  =  oaClient.sendActionMessage(userid, Arrays.asList(action));
//            System.out.println(ret);
//            String phone = "";
//            String templateId = "";
//            JsonObject templateData = new JsonObject();
//            templateData.addProperty("content", "This is a test for API send  a customer support message to the phone number");
//            JsonObject ret  =  oaClient.sendMessageCustomerCareByPhone(phone, templateId, templateData);
//            System.out.println(ret);
//            long userid = 0l; // user id
//            String stickerid = ""; // sticker id
//            JsonObject ret  =  oaClient.sendStickerMessage(userid, stickerid);
//            System.out.println(ret);
//            String msgid = ""; // message id
//            String message = "";
//            JsonObject ret  =  oaClient.replyTextMessage(msgid, message);
//            System.out.println(ret);
//            String msgid = ""; // message id
//            String imageid = ""; // image id
//            String message = "";
//            JsonObject ret  =  oaClient.replyImageMessage(msgid, imageid, message);
//            System.out.println(ret);
//            String msgid = ""; // message id
//            MsgLink link = new MsgLink();
//            link.setLink("https://developers.zalo.me/");
//            link.setLinkdes("Document For Developers");
//            link.setLinkthumb("https://developers.zalo.me/web/static/images/bg.jpg");
//            link.setLinktitle("Zalo For Developers");
//            JsonObject ret  =  oaClient.replyLinksMessage(msgid, Arrays.asList(link));
//            System.out.println(ret);
//            String qrdata = "";
//            int size = 0;
//            JsonObject ret  =  oaClient.createQRCode(qrdata, size);
//            System.out.println(ret);
            
            
            // ====== UPLOAD VIDEO =====
            // Step 1: Get link upload
//            Map<String, Object> params = new HashMap<>();
//            params.put("oaid", oaid);
//            params.put("timestamp", System.currentTimeMillis());
//            String endpoint = "http://openapi.zaloapp.com/oa/v1/media/upload/video";
//            File file = new File("zalo.mp4");
//
//            JsonObject data = new JsonObject();
//            data.addProperty("videoName", file.getName());
//            data.addProperty("videoSize", file.length());
//            params.put("data", data);
//            JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "POST", params);
//            System.out.println(excuteRequest);
//
//            // Step 2: Upload then get video token
//            JsonObject jdata = excuteRequest.getAsJsonObject("data");
//            endpoint = jdata.get("uploadLink").getAsString();
//            params.put("appId", jdata.get("appId").getAsString());
//            params.put("file", file);
//            String fileName = jdata.get("videoName").getAsString();
//            Long fileSize = jdata.get("videoSize").getAsLong();
//            Long time = jdata.get("time").getAsLong();
//            String sig = jdata.get("sig").getAsString();
//            params.put("fileName", fileName);
//            params.put("fileSize", fileSize);
//            params.put("timestamp", time);
//            params.put("sig", sig);
//            excuteRequest = oaClient.excuteRequest(endpoint, "POST", params);
//            System.out.println(excuteRequest);
//
//            // Step 3: get VideoID
//            endpoint = "https://openapi.zaloapp.com/oa/v1/media/getvideoid";
//            params = new HashMap<>();
//            params.put("oaid", oaid);
//            params.put("timestamp", System.currentTimeMillis());
//            jdata = excuteRequest.getAsJsonObject("data");
//            data = new JsonObject();
//            data.addProperty("token", jdata.get("token").getAsString());
//            data.addProperty("videoName", file.getName());
//            data.addProperty("videoSize", file.length());
//            data.addProperty("time", time);
//            data.addProperty("sig", sig);
//            params.put("data", data);
//            excuteRequest = oaClient.excuteRequest(endpoint, "GET", params);
//            jdata = excuteRequest.getAsJsonObject("data");
//            String videoId = jdata.get("videoId").getAsString();
//            System.out.println("videoId: " + videoId);
//
//            // Step 4: get Video Status
//            params = new HashMap<>();
//            params.put("oaid", oaid);
//            params.put("timestamp", System.currentTimeMillis());
//            endpoint = "https://openapi.zaloapp.com/oa/v1/media/getvideostatus";
//            data = new JsonObject();
//            data.addProperty("videoId", videoId);
//            params.put("data", data);
//            while (true) {
//                excuteRequest = oaClient.excuteRequest(endpoint, "GET", params);
//                System.out.println(excuteRequest);
//                jdata = excuteRequest.getAsJsonObject("data");
//                int status = jdata.get("status").getAsInt();
//                if (status == 1) {
//                    break;
//                }
//                Thread.sleep(2000);
//            }
            //Send video
            Map<String, Object> params = new HashMap<>();
            params.put("oaid", oaid);
            params.put("timestamp", System.currentTimeMillis());
//            String endpoint = "https://openapi.zaloapp.com/oa/v1/media/getvideostatus";
            String endpoint = "http://localhost:8115/oa/v1/sendmessage/video";
            JsonObject data = new JsonObject();
            String videoId = "ac17ceb6f3f31aad43e2";
            data.addProperty("videoid", videoId);
            data.addProperty("message", "Hello");
            data.addProperty("uid", 26981124198689082l);
            params.put("data", data);
            JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "POST", params);
            System.out.println(excuteRequest);
        } catch (Exception e) {
            // error 
            System.err.println("API Error message : " + e.toString());
        }
    }
}
