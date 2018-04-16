/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.example;

import com.vng.zalo.sdk.oa.ZaloOaClient;
import com.vng.zalo.sdk.oa.ZaloOaInfo;

/**
 *
 * @author nguyenhc2
 */
public class TestStoreAPI {

    public static void main(String[] args) {

        long oaid = 579745863508352884l; // zalo for developer
        String secrect = "pIJESQgIZtK4N1noHd8t";
        ZaloOaInfo info = new ZaloOaInfo(oaid, secrect); // zalo for developer
        ZaloOaClient oaClient = new ZaloOaClient(info);
        
    }
}
