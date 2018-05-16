/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.example;

import com.google.gson.JsonArray;
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
public class TestStoreAPI {

    static long oaid = 384631545978632398l; // zalo OA Sanbox         
//    static String oaSecrect = "4MOH5VpROVtHmzID2q8H";
    static String oaSecrect = "OQYMI5jzOWkzuXAJ793J";
    static ZaloOaInfo info = new ZaloOaInfo(oaid, oaSecrect);
    static ZaloOaClient oaClient = new ZaloOaClient(info);
    static String API_DOMAIN = "http://10.30.58.200:8215";
//    static String API_DOMAIN = "http://localhost:8215";

    public static void main(String[] args) {
        try {
            oaClient.isDebug = true;
//            JsonObject listProduct = getListProduct();
//            System.out.println(listProduct);

//            JsonObject product = getProduct();
//            System.out.println(product);
            
//            JsonObject listAttrType = getListAttrType();
//            System.out.println(listAttrType);
            
//            System.out.println(createAttr());
//            System.out.println(addAttr2Product());
            
            System.out.println(createOrder());
            
            System.out.println(getOrder());
            
            System.out.println(getListOrder());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.exit(0);
    }

    public static JsonObject getVariation() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("oaid", oaid);
        JsonObject data = new JsonObject();
        data.addProperty("offset", 0);
        data.addProperty("count", 10);
        params.put("data", data.toString());
        params.put("timestamp", System.currentTimeMillis());
        JsonObject response = oaClient.excuteRequest(API_DOMAIN + "/oa/v1/store/product/getproductofoa", "GET", params);
        return response;
    }

    public static JsonObject getProduct() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("oaid", oaid);
        JsonObject data = new JsonObject();
        data.addProperty("productid", "bef4552c69698037d978");
        params.put("data", data.toString());
        params.put("timestamp", System.currentTimeMillis());
        JsonObject response = oaClient.excuteRequest(API_DOMAIN + "/oa/v1/store/product/getproduct", "GET", params);
        return response;
    }

    public static JsonObject getListAttrType() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("oaid", oaid);
        JsonObject data = new JsonObject();
        data.addProperty("offset", 0);
        data.addProperty("count", 10);
        params.put("data", data.toString());
        params.put("timestamp", System.currentTimeMillis());
        JsonObject response = oaClient.excuteRequest(API_DOMAIN + "/oa/v1/store/product/getattrtypeofoa", "GET", params);
        return response;
    }

    public static JsonObject createAttr() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("oaid", oaid);
        JsonObject data = new JsonObject();
        data.addProperty("type", "fd2ee7efdbaa32f46bbb");
        data.addProperty("price", 30000);
        data.addProperty("status", 2);
        data.addProperty("name", "XXL");
        params.put("data", data.toString());
        params.put("timestamp", System.currentTimeMillis());
        JsonObject response = oaClient.excuteRequest(API_DOMAIN + "/oa/v1/store/product/createattr", "POST", params);
        return response;
    }

    public static JsonObject addAttr2Product() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("oaid", oaid);
        JsonObject data = new JsonObject();
        data.addProperty("productid", "bef4552c69698037d978");
        JsonArray variations = new JsonArray();
        JsonObject variation = new JsonObject();
        variation.addProperty("type", "85d7460f7a4a9314ca5b");
        variation.addProperty("name", "Post Paid Topup XXL");
        JsonArray attrIds = new JsonArray();
        attrIds.add("c2ae1e762233cb6d9222");
        variation.addProperty("price", 30000);
        variation.add("attributes", attrIds);
        variations.add(variation);
        data.add("variations", variations);
        params.put("data", data.toString());
        params.put("timestamp", System.currentTimeMillis());
        JsonObject response = oaClient.excuteRequest(API_DOMAIN + "/oa/v1/store/product/addvariation", "POST", params);
        return response;
    }

    public static JsonObject getListProduct() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("oaid", oaid);
        JsonObject data = new JsonObject();
        data.addProperty("offset", 0);
        data.addProperty("count", 1);
        params.put("data", data.toString());
        params.put("timestamp", System.currentTimeMillis());
        JsonObject response = oaClient.excuteRequest(API_DOMAIN + "/oa/v1/store/product/getproductofoa", "GET", params);
        return response;
    }

    public static JsonObject getListOrder() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("oaid", oaid);
        params.put("timestamp", System.currentTimeMillis());
        String endpoint = API_DOMAIN + "/oa/v1/store/invoice/getbyoa";
        JsonObject data = new JsonObject();
        data.addProperty("status", 0);
        data.addProperty("offset", 0);
        data.addProperty("count", 3);
        params.put("data", data.toString());
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "GET", params);
        return excuteRequest;
    }

    public static JsonObject getOrder() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("oaid", oaid);
        params.put("timestamp", System.currentTimeMillis());
        String endpoint = API_DOMAIN + "/oa/v1/store/invoice/info";
        JsonObject data = new JsonObject();
        data.addProperty("invoiceId", "e78d60f0c4b52deb74a4");
        params.put("data", data.toString());
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "GET", params);
        return excuteRequest;
    }

    public static JsonObject updateInvoice() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("oaid", oaid);
        params.put("timestamp", System.currentTimeMillis());
        String endpoint = API_DOMAIN + "/oa/v1/store/onbehalf/invoice/update";
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
