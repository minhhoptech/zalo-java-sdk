/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.utils;

import com.vng.zalo.sdk.APIException;
import java.net.URLDecoder;
import java.util.Map;

/**
 *
 * @author nghiadc
 */
public class ParamsUtils {

    public static String getString(Map params, String paramName, String defaultValue) {
        String value = defaultValue;
        if (params.containsKey(paramName)) {
            try {
                value = URLDecoder.decode(((String) params.get(paramName)).trim(), "UTF-8");
                return (String) params.get(paramName);
            } catch (Exception ex) {

            }
        }
        return value;
    }

    public static String getString(Map params, String paramName) throws APIException {
        if (!params.containsKey(paramName)) {
            throw new APIException(String.format("%s is required", paramName));
        }
        try {
            return params.get(paramName).toString();
        } catch (Exception ex) {
            throw new APIException(String.format("%s is invalid", paramName));
        }
    }

    public static Long getLong(Map params, String paramName, Long defaultValue) {
        Long value = defaultValue;
        if (params.containsKey(paramName)) {
            String strValue = (params.get(paramName).toString()).trim();
            try {
                value = Long.parseLong(strValue);
            } catch (NumberFormatException e) {
            }
        }
        return value;
    }

    public static Long getLong(Map params, String paramName) throws APIException {
        if (!params.containsKey(paramName)) {
            throw new APIException(String.format("%s is required", paramName));
        }
        try {
            String strValue = (params.get(paramName).toString()).trim();
            return Long.parseLong(strValue);
        } catch (Exception ex) {
            throw new APIException(String.format("%s is invalid", paramName));
        }

    }

    public static int getInt(Map params, String paramName, int defaultValue) {
        int value = defaultValue;
        if (params.containsKey(paramName)) {
            String strValue = (params.get(paramName).toString()).trim();
            try {
                value = Integer.parseInt(strValue);
            } catch (NumberFormatException e) {
            }
        }
        return value;
    }
}
