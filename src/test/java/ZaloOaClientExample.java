
import com.google.gson.JsonObject;
import com.vng.zalo.sdk.APIConfig;
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.SendMessageReponse;
import com.vng.zalo.sdk.UploadResponse;
import com.vng.zalo.sdk.ZaloUser;
import com.vng.zalo.sdk.oa.ZaloOaClient;
import com.vng.zalo.sdk.oa.ZaloOaInfo;
import com.vng.zalo.sdk.oa.message.MsgAction;
import com.vng.zalo.sdk.oa.message.MsgGif;
import com.vng.zalo.sdk.oa.message.MsgImage;
import com.vng.zalo.sdk.oa.message.MsgLink;
import com.vng.zalo.sdk.oa.message.MsgStatus;
import com.vng.zalo.sdk.oa.message.OpenCallAction;
import com.vng.zalo.sdk.oa.message.OpenInAppAction;
import java.io.File;
import java.util.Arrays;
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
public class ZaloOaClientExample {
    public static void main(String[] args) {
        
//        ZaloOaInfo info = new ZaloOaInfo(1826682759708388138l, "Rj41X4Q7qZDGPWnVblHo"); // zalo for lala 
        long oaid = 579745863508352884l; // zalo for developer
        String secrect = "pIJESQgIZtK4N1noHd8t";
        ZaloOaInfo info = new ZaloOaInfo(oaid, secrect); // zalo for developer
        ZaloOaClient oaClient = new ZaloOaClient(info);
        
//        String templateId = "2c5599bda5f84ca615e9";
        JsonObject data = new JsonObject();
        data.addProperty("content", "Chào bạn, Chúc bạn một ngày vui vẻ!");
        
        
        
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
            
            String fileUrl = "/home/cpu10142-local/Downloads/source1.gif";
            JsonObject ret = oaClient.uploadGifPhoto(fileUrl);
            System.out.println(ret);
            
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

        } catch (APIException e) {
            // error 
            System.out.println("API Error code : " + e.getCode());
            System.out.println("API Error message : " + e.getMessage());
        }
        
        
        
    }
}
