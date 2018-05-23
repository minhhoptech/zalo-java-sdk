/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.example.store.order;

import com.google.gson.JsonObject;
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.oa.ZaloOaClient;
import com.vng.zalo.sdk.oa.ZaloOaInfo;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nguyenhc2
 */
public class TestAPIOrder {

    static long oaid = 384631545978632398l; // zalo OA Sanbox         
    static String oaSecrect = "OQYMI5jzOWkzuXAJ793J";     
    
    static ZaloOaInfo info = new ZaloOaInfo(oaid, oaSecrect);
    static ZaloOaClient oaClient = new ZaloOaClient(info);
//    static String API_DOMAIN = "https://openapi.zaloapp.com";
//    static String API_DOMAIN = "http://sandbox.openapi.zaloapp.com";
    static String API_DOMAIN = "http://localhost:8215";

    public static void main(String[] args) {
        try {
            oaClient.isDebug = true;
//            System.out.println(createOrder());
//            System.out.println(getOrder());
            JsonObject updateOrder = updateOrder();
            System.out.println(updateOrder);
//            System.out.println(getListOrder());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.exit(0);
    }

    public static JsonObject getListOrder() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("oaid", oaid);
        params.put("timestamp", System.currentTimeMillis());
        String endpoint = API_DOMAIN + "/oa/v1/store/order/getorderofoa";
        JsonObject data = new JsonObject();
        data.addProperty("status", 0);
        data.addProperty("filter", 0);
        data.addProperty("offset", 0);
        data.addProperty("count", 10);
        params.put("data", data.toString());
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "GET", params);
        return excuteRequest;
    }

    public static JsonObject getOrder() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("oaid", oaid);
        params.put("timestamp", System.currentTimeMillis());
        String endpoint = API_DOMAIN + "/oa/v1.1/store/order/getorder";
        JsonObject data = new JsonObject();
        data.addProperty("id", "e78d60f0c4b52deb74a4");
        params.put("data", data.toString());
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "GET", params);
        return excuteRequest;
    }

    public static JsonObject updateOrder() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("oaid", oaid);
        params.put("timestamp", System.currentTimeMillis());
        String endpoint = API_DOMAIN + "/oa/v1/store/order/update";
        JsonObject data = new JsonObject();
        data.addProperty("orderid", "cd45d13a747f9d21c46e");
        data.addProperty("status", "6");
        data.addProperty("editReason", "update order");
        data.addProperty("cancelReason", "<!DOCTYPE html><html><head><title>Hinh anh trong HTML</title></head><body><p>Vi du the img trong HTML.</p><img src='https://znews-photo-td.zadn.vn/w1024/Uploaded/natmzz/2018_05_23/1_2.jpg' alt='Hình ảnh trong HTML' /></body></html>");
        params.put("data", data.toString());
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "POST", params);
        return excuteRequest;
    }

    public static JsonObject updateOrderV1_1() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("oaid", oaid);
        params.put("timestamp", System.currentTimeMillis());
        String endpoint = API_DOMAIN + "/oa/v1.1/store/order/update";
        JsonObject data = new JsonObject();
        data.addProperty("id", "c46e3c12985771092846");
        data.addProperty("status", "3");
        data.addProperty("editReason", "ahihi");
        params.put("data", data.toString());
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "POST", params);
        return excuteRequest;
    }

    public static JsonObject createOrder() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("oaid", oaid);
        params.put("timestamp", System.currentTimeMillis());
        String endpoint = API_DOMAIN + "/oa/v1/store/invoice/create";
        String strData = "{\n"
                + "  \"id\": \"c46e3c12985771092846\",\n"
                + "  \"code\": \"#9896ec\",\n"
                + "  \"status\": 4,\n"
                + "  \"totalAmount\": 57000,\n"
                + "  \"shipping\": null,\n"
                + "  \"customer\": {\n"
                + "    \"name\": \"Hồ Cao Nguyên\",\n"
                + "    \"phone\": 841693922049,\n"
                + "    \"userId\": \"8335563107149879942\",\n"
                + "    \"address\": \"182 Lê Đại Hành\",\n"
                + "    \"districtName\": \"Quận 11\",\n"
                + "    \"cityName\": \"Hồ Chí Minh\"\n"
                + "  },\n"
                + "  \"payment\": {\n"
                + "    \"status\": 2,\n"
                + "    \"method\": 4\n"
                + "  },\n"
                + "  \"orders\": [\n"
                + "    {\n"
                + "      \"productId\": \"bef4552c69698037d978\",\n"
                + "      \"quantity\": 2,\n"
                + "      \"variation\": {id: \"5fc456676a22837cda33\"}\n"
                + "    }\n"
                + "  ],\n"
                + "  \"cancelReason\": \"\",\n"
                + "  \"extraNote\": \"Cái này Nguyên tạo\",\n"
                + "  \"createdTime\": 1523858014196,\n"
                + "  \"updatedTime\": 1523880160629\n"
                + "}";
        params.put("data", strData.replaceAll("\n", ""));
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "POST", params);
        return excuteRequest;
    }
}
