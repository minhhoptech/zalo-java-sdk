/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.example;

import com.google.gson.JsonObject;
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.app.Zalo3rdAppClient;
import com.vng.zalo.sdk.app.Zalo3rdAppInfo;
import java.util.Arrays;

/**
 *
 * @author nguyenhc2
 */
public class Test3rdAppSDK {

    public static void main(String[] args) throws APIException {

        Zalo3rdAppInfo appInfo = new Zalo3rdAppInfo(2030223146967622095L, "4B2qNrCXRmo16nPbAGM8", "http://dev1.demo-zc.zapps.vn/login/callback");
        Zalo3rdAppClient sdk = new Zalo3rdAppClient(appInfo);
        System.out.println(sdk.getLoginUrl());

        //Get accesstoken from oauth code
        String code = "mow9KvCvxWxQ1RKDnpteAP0Ic2Q14kjSqXFNIlGsrmoS5Q9Wu2o9JS4Nwnwh29iOlm3G5SuxqrBKAjKMjGsWSCumwqZcFjyujIYkAA0fsalyDzq9xbdBQg46uqw4P-GOWroUJFnJZqFfMUbRu1onMRy5fsA6UPL4wcw6I_G_v1kGEDzJZZoeCDKblW6QPECPvKIKTfbf_KY0H-z5hGN05F4RnaMQAj1yiJZYA-LghNMXHy51EIoGVqODsK4-PmHRLLSoBLuaH0qjSoS1H2eIRqfnR48z6GmiI6WTGcPyUH4O01P0AZFVGEq7loG";
        JsonObject accessToken = sdk.getAccessToken(code);
        System.out.println(accessToken);

        String strToken = accessToken.get("access_token").getAsString();
        int expiresIn = accessToken.get("expires_in").getAsInt();

//        JsonObject profile = sdk.getProfile(strToken, "id,name,picture.type(large),gender,birthday");
//        System.out.println(profile);
//
        JsonObject friends = sdk.getFriends(strToken, 0, 10, "id,name,picture.type(large),gender,birthday");
        System.out.println(friends);
//
        JsonObject invitableFriends = sdk.getInvitableFriends(strToken, 0, 100, "id,name,picture.type(large),gender,birthday");
        System.out.println(invitableFriends);
////        
//        JsonObject postFeed = sdk.postFeed(strToken, "post feed", "https://developers.zalo.me/docs/api/social-api/tai-lieu/dang-bai-viet-post-39");
//        System.out.println(postFeed);
//        
//        JsonObject sendAppRequest = sdk.sendAppRequest(strToken, Arrays.asList(3242353675205151122L), "Testing");
//        System.out.println(sendAppRequest);
        
        JsonObject sendMessage = sdk.sendMessage(strToken, 8063947237857451397l, "Test send mesage", "https://developers.zalo.me/docs/api/social-api/tai-lieu/dang-bai-viet-post-39");
        System.out.println(sendMessage);
    }
}
