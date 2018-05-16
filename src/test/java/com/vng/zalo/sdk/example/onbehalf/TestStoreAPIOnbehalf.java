/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.example.onbehalf;

import com.vng.zalo.sdk.example.*;
import com.google.gson.JsonObject;
import com.vng.zalo.sdk.oa.ZaloAppInfo;
import com.vng.zalo.sdk.oa.ZaloOaClient;
import com.vng.zalo.sdk.oa.ZaloOaInfo;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nguyenhc2
 */
public class TestStoreAPIOnbehalf {

    public static void main(String[] args) {
        long appId = 2432366087078154925l;
        long oaid = 384631545978632398l; // zalo for developer           
        String oaSecrect = "OQYMI5jzOWkzuXAJ793J";
        String appSecrect = "nmrZHpC6AKJXQ7GVumKX";
        String accessToken = "J_iCgScXi0H3z1Ntwzc46LYI8kkLoeKh8903zQ3UgGOMjmUVh-gOVphuCe6tYv5sTj0ti_sOYcrixnMSqeI-2ttzAVxIv94WQ9O1m9Y_dZGMzodkGQTGTkV-pDXY_0NZ_UITBMVtIRgms_eS4-SKd9NmanSxu2RfvSJa2Z_uBk7GvEC7OiQU9UkneMi";
        ZaloOaInfo info = new ZaloOaInfo(oaid, oaSecrect); // zalo for developer
        ZaloAppInfo appInfo = new ZaloAppInfo(appId, appSecrect);
        ZaloOaClient oaClient = new ZaloOaClient(info, appInfo);
        try {
            // get list invoice
//            Map<String, Object> params = new HashMap<>();
//            params.put("appid", appId);
//            params.put("timestamp", System.currentTimeMillis());
//            String endpoint = "http://10.30.58.200:8215/oa/v1/store/onbehalf/invoice/getinvoiceofoa";
////            String endpoint = "http://localhost:8215/oa/v1/store/onbehalf/invoice/getinvoiceofoa";
////            String endpoint = "http://stg.openapi.zaloapp.com/oa/v1/store/onbehalf/invoice/getinvoiceofoa";
//            JsonObject data = new JsonObject();
//            data.addProperty("providerType", "");
//            data.addProperty("status", 0);
//            data.addProperty("accessTok", accessToken);
//            params.put("data", data.toString());
//            JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "GET", params);
//            System.out.println(excuteRequest);

            // get invoice
            Map<String, Object> params = new HashMap<>();
            params.put("appid", appId);
            params.put("timestamp", System.currentTimeMillis());
            String endpoint = "http://localhost:8215/oa/v1/store/onbehalf/invoice/getinvoice";
            JsonObject data = new JsonObject();
            data.addProperty("invoiceId", "c46e3c12985771092846");
            data.addProperty("accessTok", accessToken);
            params.put("data", data.toString());
            JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "GET", params);
            System.out.println(excuteRequest);

            //update invoice
//            Map<String, Object> params = new HashMap<>();
//            params.put("appid", appId);
//            params.put("timestamp", System.currentTimeMillis());
//            String endpoint = "http://localhost:8215/oa/v1/store/onbehalf/invoice/updateinvoice";
//            JsonObject data = new JsonObject();
//            data.addProperty("id", "c46e3c12985771092846");
//            data.addProperty("status", "3");
//            data.addProperty("extraNote", "ahihi");
//            data.addProperty("accessTok", accessToken);
//            params.put("data", data.toString());
//            JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "POST", params);
//            System.out.println(excuteRequest);
            //update create
//            Map<String, Object> params = new HashMap<>();
//            params.put("appid", appId);
//            params.put("timestamp", System.currentTimeMillis());
//            String endpoint = "http://localhost:8215/oa/v1/store/onbehalf/invoice/updateinvoice";
//            JsonObject data = new JsonObject();
//            data.addProperty("id", "c46e3c12985771092846");
//            data.addProperty("status", "3");
//            data.addProperty("editReason", "ahihi");
//            data.addProperty("accessTok", accessToken);
//            params.put("data", data.toString());
//            JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "POST", params);
//            System.out.println(excuteRequest);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.exit(0);
    }
}
