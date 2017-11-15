/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk;

/**
 *
 * @author nghiadc
 */
public class ZaloEventData {
    long fromuid;
    long phone;
    long appid;
    String event;
    long pageid;
    long oaid;
    String msgid;
    String message;
    String href;
    String thumb;
    String mac;
    long timestamp;

    @Override
    public String toString() {
        return "ZaloEventData{" + "fromuid=" + fromuid + ", phone=" + phone + ", appid=" + appid + ", event=" + event + ", pageid=" + pageid + ", oaid=" + oaid + ", msgid=" + msgid + ", message=" + message + ", href=" + href + ", thumb=" + thumb + ", mac=" + mac + ", timestamp=" + timestamp + '}';
    }
    
    public ZaloEventData(long fromuid, long phone, long appid, String event, long pageid, long oaid, String msgid, String message, String href, String thumb, String mac, long timestamp) {
        this.fromuid = fromuid;
        this.phone = phone;
        this.appid = appid;
        this.event = event;
        this.pageid = pageid;
        this.oaid = oaid;
        this.msgid = msgid;
        this.message = message;
        this.href = href;
        this.thumb = thumb;
        this.mac = mac;
        this.timestamp = timestamp;
    }
    
    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
    

   
    
    public long getFromuid() {
        return fromuid;
    }

    public void setFromuid(long fromuid) {
        this.fromuid = fromuid;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getAppid() {
        return appid;
    }

    public void setAppid(long appid) {
        this.appid = appid;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public long getPageid() {
        return pageid;
    }

    public void setPageid(long pageid) {
        this.pageid = pageid;
    }

    public long getOaid() {
        return oaid;
    }

    public void setOaid(long oaid) {
        this.oaid = oaid;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    
}
