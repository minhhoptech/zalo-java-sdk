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
     * Send follow message to user's phone number
     */
    public static String OA_SEND_FOLLOW_MESSAGE = String.format("%s/%s/sendmessage/phone/invite",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get slice tag
     */
    public static String OA_GET_SLICE_TAG = String.format("%s/%s/tag/gettagsofoa",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Remove tag
     */
    public static String OA_REMOVE_TAG = String.format("%s/%s/tag/rmtag",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Remove user from tag
     */
    public static String OA_REMOVE_USER_FROM_TAG = String.format("%s/%s/tag/rmfollowerfromtag",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Tag user
     */
    public static String OA_TAG_USER = String.format("%s/%s/tag/tagfollower",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

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

    /*                                                     ARTICLE API 
     *
     * Get link upload
     */
    public static String OA_ARTICLE_GET_LINK_UPLOAD = String.format("%s/%s/media/upload/video",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get video id
     */
    public static String OA_ARTICLE_GET_VIDEO_ID = String.format("%s/%s/media/getvideoid",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get video status
     */
    public static String OA_ARTICLE_GET_VIDEO_STATUS = String.format("%s/%s/media/getvideostatus",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Create article
     */
    public static String OA_ARTICLE_CREATE_ARTICLE = String.format("%s/%s/media/create",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Update article
     */
    public static String OA_ARTICLE_UPDATE_ARTICLE = String.format("%s/%s/media/update",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Remove article
     */
    public static String OA_ARTICLE_REMOVE_ARTICLE = String.format("%s/%s/media/remove",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get slice article
     */
    public static String OA_ARTICLE_GET_SLICE = String.format("%s/%s/media/getslice",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get slice video article
     */
    public static String OA_ARTICLE_GET_SLICE_VIDEO = String.format("%s/%s/media/video/getslice",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Update video article
     */
    public static String OA_ARTICLE_UPDATE_VIDEO = String.format("%s/%s/media/video/update",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Create video article
     */
    public static String OA_ARTICLE_CREATE_VIDEO = String.format("%s/%s/media/video/create",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get media id from token
     */
    public static String OA_ARTICLE_GET_MEDIA_ID = String.format("%s/%s/media/verify",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Broadcast media
     */
    public static String OA_ARTICLE_BROADCAST_MEDIA = String.format("%s/%s/broadcast/medias",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * OA STORE API
     *
     * Update variation
     */
    public static String OA_STORE_UPDATE_VARIATION = String.format("%s/%s/store/product/updatevariation",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Add variation
     */
    public static String OA_STORE_ADD_VARIATION = String.format("%s/%s/store/product/addvariation",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Multi get attribute info
     */
    public static String OA_STORE_MULTI_GET_ATTR_INFO = String.format("%s/%s/store/product/mgetattr",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get slice attribute
     */
    public static String OA_STORE_GET_SLICE_ATTR = String.format("%s/%s/store/product/getattrofoa",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get update attribute
     */
    public static String OA_STORE_UPDATE_ATTR = String.format("%s/%s/store/product/updateattr",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Create attribute
     */
    public static String OA_STORE_CREATE_ATTR = String.format("%s/%s/store/product/createattr",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get slice attribute type
     */
    public static String OA_STORE_GET_SLICE_ATTR_TYPE = String.format("%s/%s/store/product/getattrtypeofoa",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Create product
     */
    public static String OA_STORE_CREATE_PRODUCT = String.format("%s/%s/store/product/create",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Update product
     */
    public static String OA_STORE_UPDATE_PRODUCT = String.format("%s/%s/store/product/update",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Remove product
     */
    public static String OA_STORE_REMOVE_PRODUCT = String.format("%s/%s/store/product/remove",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Update product
     */
    public static String OA_STORE_GET_PRODUCT_INFO = String.format("%s/%s/store/product/getproduct",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get slice product
     */
    public static String OA_STORE_GET_SLICE_PRODUCT = String.format("%s/%s/store/product/getproductofoa",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Upload product photo
     */
    public static String OA_STORE_UPLOAD_PRODUCT_PHOTO = String.format("%s/%s/store/upload/productphoto",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Create category
     */
    public static String OA_STORE_CREATE_CATEGORY = String.format("%s/%s/store/category/create",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Update category
     */
    public static String OA_STORE_UPDATE_CATEGORY = String.format("%s/%s/store/category/update",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get slice category
     */
    public static String OA_STORE_GET_SLICE_CATEGORY = String.format("%s/%s/store/category/getcategoryofoa",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Upload category photo
     */
    public static String OA_STORE_UPLOAD_CATEGORY_PHOTO = String.format("%s/%s/store/upload/categoryphoto",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Update order
     */
    public static String OA_STORE_UPDATE_ORDER = String.format("%s/%s/store/order/update",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get slice order
     */
    public static String OA_STORE_GET_SLICE_ORDER = String.format("%s/%s/store/order/getorderofoa",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get order info
     */
    public static String OA_STORE_GET_ORDER_INFO = String.format("%s/%s/store/order/getorder",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Update shop info
     */
    public static String OA_STORE_UPDATE_SHOP_INFO = String.format("%s/%s/store/updateshop",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

}
