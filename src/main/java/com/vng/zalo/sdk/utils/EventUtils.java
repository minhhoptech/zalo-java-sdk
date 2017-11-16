/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.utils;

import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.ZaloEventData;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author nghiadc
 */
public class EventUtils {

    public static ZaloEventData getEventData(String query) throws APIException {
        Map params = null;
        try {
            params = QueryStringUtils.splitQuery(query);
        } catch (Exception e) {
            throw new APIException(e);
        }
        return getEventData(params);
    }

    public static ZaloEventData getEventData(HttpServletRequest req) throws APIException {
        Map params = req.getParameterMap();
        return getEventData(params);
    }

    public static ZaloEventData getEventData(Map params) throws APIException {
        long fromuid = ParamsUtils.getLong(params, "fromuid");
        long oaid = ParamsUtils.getLong(params, "oaid");
        long timestamp = ParamsUtils.getLong(params, "timestamp");
        long phone = ParamsUtils.getLong(params, "phone", 0l);
        long appid = ParamsUtils.getLong(params, "appid", 0l);
        long pageid = ParamsUtils.getLong(params, "pageid", 0l);
        String event = ParamsUtils.getString(params, "event");
        String mac = ParamsUtils.getString(params, "mac");
        String msgid = ParamsUtils.getString(params, "msgid", "");
        String message = ParamsUtils.getString(params, "message", "");
        String href = ParamsUtils.getString(params, "href", "");
        String thumb = ParamsUtils.getString(params, "thumb", "");
        ZaloEventData data = new ZaloEventData(fromuid, phone, appid, event, pageid, oaid, msgid, message, href, thumb, mac, timestamp);
        return data;
    }
}
