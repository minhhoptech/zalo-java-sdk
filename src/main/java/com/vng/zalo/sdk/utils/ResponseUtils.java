/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.utils;

/**
 *
 * @author nghiadc
 */
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vng.zalo.sdk.APIException;

public class ResponseUtils {
    public static <T extends Object> T getData(String json, Class<T> classOfT) throws APIException {
        JsonParser p = new JsonParser();
        JsonElement parsed = p.parse(json);
        JsonObject parsedObj = parsed.getAsJsonObject();
        int code = parsedObj.get("errorCode").getAsInt();
        String message = parsedObj.get("errorMsg").getAsString();
        if (code < 0) {
            throw new APIException(code, message);
        }
        JsonElement get = parsedObj.get("data");
        Gson g = new Gson();
        T data = g.fromJson(get, classOfT);
        return data;
    }
}
