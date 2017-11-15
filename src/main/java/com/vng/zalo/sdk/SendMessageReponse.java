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
public class SendMessageReponse {
    String msgId;
    public String getMsgId() {
        return msgId;
    }

    @Override
    public String toString() {
        return "SendMessageReponse{" + "msgId=" + msgId + '}';
    }
    
}
