/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk;

/**
 * ZALO API ENDPOINT
 *
 * @author linhndh
 */
public class EndPoint {

    /* OFFICAL ACCOUNT API ENDPOINT */
    /**
     * Get profile
     */
    public static final String OA_GET_PROFILE = String.format("%s/%s/getprofile",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Get message status
     */
    public static final String OA_GET_MESSAGE_STATUS = String.format("%s/%s/getmessagestatus",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Send customer care message by phone
     */
    public static String OA_SEND_MESSAGE_CUSTOMER_CARE_BY_PHONE = String.format("%s/%s/sendmessage/phone/cs",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Send customer care message by user id
     */
    public static String OA_SEND_MESSAGE_CUSTOMER_CARE_BY_USERID = String.format("%s/%s/sendmessage/cs",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Send action message
     */
    public static String OA_SEND_ACTION_MESSAGE = String.format("%s/%s/sendmessage/actionlist",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Send link message
     */
    public static String OA_SEND_LINK_MESSAGE = String.format("%s/%s/sendmessage/links",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Send image message
     */
    public static String OA_SEND_IMAGE_MESSAGE = String.format("%s/%s/sendmessage/image",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Send gif message
     */
    public static String OA_SEND_GIF_MESSAGE = String.format("%s/%s/sendmessage/gif",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Send text message
     */
    public static String OA_SEND_TEXT_MESSAGE = String.format("%s/%s/sendmessage/text",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Send sticker message
     */
    public static String OA_SEND_STICKER_MESSAGE = String.format("%s/%s/sendmessage/sticker",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Upload photo
     */
    public static String OA_UPLOAD_PHOTO = String.format("%s/%s/upload/image",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Upload gif photo
     */
    public static String OA_UPLOAD_GIF_PHOTO = String.format("%s/%s/upload/gif",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Reply text message
     */
    public static String OA_REPLY_TEXT_MESSAGE = String.format("%s/%s/sendmessage/reply/text",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Reply image message
     */
    public static String OA_REPLY_IMAGE_MESSAGE = String.format("%s/%s/sendmessage/reply/image",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Reply link message
     */
    public static String OA_REPLY_LINKS_MESSAGE = String.format("%s/%s/sendmessage/reply/links",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Create QR code
     */
    public static String OA_CREATE_QRCODE = String.format("%s/%s/qrcode",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /* OFFICAL ACCOUNT API ONBEHALF ENDPOINT */
    /**
     * Get profile onbehalf
     */
    public static String OA_ONBEHALF_GET_PROFILE = String.format("%s/%s/onbehalf/getprofile",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Get offical acccount info onbehalf
     */
    public static String OA_ONBEHALF_GET_OFFICAL_ACCOUNT_INFO = String.format("%s/%s/onbehalf/getoa",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Get conversation onbehalf
     */
    public static String OA_ONBEHALF_GET_CONVERSATION = String.format("%s/%s/onbehalf/conversation",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Get list recent chat onbehalf
     */
    public static String OA_ONBEHALF_GET_LIST_RECENT_CHAT = String.format("%s/%s/onbehalf/listrecentchat",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Upload photo onbehalf
     */
    public static String OA_ONBEHALF_UPLOAD_PHOTO = String.format("%s/%s/onbehalf/upload/image",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Upload gif photo onbehalf
     */
    public static String OA_ONBEHALF_UPLOAD_GIF_PHOTO = String.format("%s/%s/onbehalf/upload/gif",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Send text message onbehalf
     */
    public static String OA_ONBEHALF_SEND_TEXT_MESSAGE = String.format("%s/%s/onbehalf/sendmessage/text",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Send image message onbehalf
     */
    public static String OA_ONBEHALF_SEND_IMAGE_MESSAGE = String.format("%s/%s/onbehalf/sendmessage/image",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Send link message onbehalf
     */
    public static String OA_ONBEHALF_SEND_LINK_MESSAGE = String.format("%s/%s/onbehalf/sendmessage/links",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Send action message onbehalf
     */
    public static String OA_ONBEHALF_SEND_ACTION_MESSAGE = String.format("%s/%s/onbehalf/sendmessage/actionlist",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Send sticker message onbehalf
     */
    public static String OA_ONBEHALF_SEND_STICKER_MESSAGE = String.format("%s/%s/onbehalf/sendmessage/sticker",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Send gif message onbehalf
     */
    public static String OA_ONBEHALF_SEND_GIF_MESSAGE = String.format("%s/%s/onbehalf/sendmessage/gif",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Reply text message onbehalf
     */
    public static String OA_ONBEHALF_REPLY_TEXT_MESSAGE = String.format("%s/%s/onbehalf/sendmessage/reply/text",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Reply image message onbehalf
     */
    public static String OA_ONBEHALF_REPLY_IMAGE_MESSAGE = String.format("%s/%s/onbehalf/sendmessage/reply/image",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Reply link message onbehalf_ONBEHALF
     */
    public static String OA_ONBEHALF_REPLY_LINKS_MESSAGE = String.format("%s/%s/onbehalf/sendmessage/reply/links",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Login OA onbehalf link
     */
    public static String LOGIN_OA_ONBEHALF = "https://oauth.zaloapp.com/page/login?app_id=%s&redirect_uri=%s";
}
