package com.vng.zalo.sdk.example;


import com.google.gson.JsonObject;
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.ZaloEventData;
import com.vng.zalo.sdk.oa.ZaloOaClient;
import com.vng.zalo.sdk.oa.ZaloOaInfo;
import com.vng.zalo.sdk.ZaloUser;
import com.vng.zalo.sdk.utils.EventUtils;
import com.vng.zalo.sdk.utils.MacUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nghiadc
 */
public class CommonTest {
    public static void main(String[] args) throws APIException {
        String query = "fromuid=200876389989833995&phone=&appid=&event=follow&pageid=3799545928904589562&oaid=3799545928904589562&mac=22f360ff31355416900db8c4fafb6ff4f7c36e389fd7d35d9376a2808857e989&timestamp=1507174797162";
        ZaloOaInfo oaInfo = new ZaloOaInfo(3799545928904589562l, "u2I1W6RDsM45fB91oNYY");
        ZaloEventData eventData = EventUtils.getEventData(query);
        String mac = MacUtils.buildMac(eventData.getOaid(),eventData.getFromuid(),eventData.getTimestamp(),oaInfo.getSecrect());
        System.out.println(mac);
        ZaloOaClient cli = new ZaloOaClient(oaInfo);
        JsonObject profile = cli.getProfile(eventData.getFromuid());
        System.out.println(profile);
        
        System.out.println(profile);
    }
}
