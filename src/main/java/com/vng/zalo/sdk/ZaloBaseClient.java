/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.digest.DigestUtils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author nghiadc
 */
public class ZaloBaseClient {
    protected String sendHttpGetRequest(String enpointUrl, Map<String, String> params, Map<String, String> header) throws APIException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            try {

                URIBuilder builder = new URIBuilder(enpointUrl);
                if (params != null) {
                    for (Map.Entry<String, String> entry : params.entrySet()) {
                        builder.addParameter(entry.getKey(), entry.getValue());
                    }
                }
//                System.out.println(builder.toString());
                HttpGet httpget = new HttpGet(builder.toString());
                if (header != null) {
                    for (Map.Entry<String, String> entry : header.entrySet()) {
//                    httpget.addHeader("authorization", String.format("bearer %s", keyCode));
                        httpget.addHeader(entry.getKey(), entry.getValue());
                    }
                }
                CloseableHttpResponse response = httpclient.execute(httpget);
                try {
                    HttpEntity entity = response.getEntity();
                    String rs = EntityUtils.toString(entity);

                    StatusLine statusLine = response.getStatusLine();

                    return rs;
                } finally {
                    response.close();
                }
            } catch (IOException ex) {
               throw new APIException(ex);
            } finally {
                httpclient.close();
            }
        } catch (Exception ex) {
            throw new APIException(ex);
        }
    }

    protected String sendHttpDeleteRequest(String enpointUrl, Map<String, String> params, Map<String, String> header) throws APIException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            try {

                URIBuilder builder = new URIBuilder(enpointUrl);
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    builder.addParameter(entry.getKey(), entry.getValue());
                }
                HttpDelete httpDelete = new HttpDelete(builder.toString());
                for (Map.Entry<String, String> entry : header.entrySet()) {
                    httpDelete.addHeader(entry.getKey(), entry.getValue());
                }
                CloseableHttpResponse response = httpclient.execute(httpDelete);
                try {
                    HttpEntity entity = response.getEntity();
                    String rs = EntityUtils.toString(entity);
                    StatusLine statusLine = response.getStatusLine();
                    int statusCode = statusLine.getStatusCode();
                    if (statusCode != 200) {
                        throw new Exception(String.format("Status not OK %d", statusCode));
                    }
                    return rs;
                } finally {
                    response.close();
                }
            } catch (IOException ex) {
                 throw new APIException(ex);
            } finally {
                httpclient.close();
            }
        } catch (Throwable ex) {
             throw new APIException(ex);
        }
    }

    

    protected String sendHttpPostRequest(String enpointUrl, Map<String, String> params, Map<String, String> header) throws APIException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            try {
                HttpPost httpPost = new HttpPost(enpointUrl);
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                if (header != null) {
                    for (Map.Entry<String, String> entry : header.entrySet()) {
                        httpPost.addHeader(entry.getKey(), entry.getValue());
                    }
                }
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nvps,"UTF-8");
                httpPost.setEntity(urlEncodedFormEntity);
                CloseableHttpResponse response = httpclient.execute(httpPost);
                try {
                    HttpEntity entity = response.getEntity();
                    return EntityUtils.toString(entity);
                } finally {
                    response.close();
                }
            } catch (IOException ex) {
                 throw new APIException(ex);
            } finally {
                httpclient.close();
            }
        } catch (APIException | IOException | ParseException ex) {
             throw new APIException(ex);
        }
    }

    protected String sendHttpPostRequest(String enpointUrl, String body, Map<String, String> header) throws APIException {
        ContentType type = ContentType.create("application/json", "UTF-8");
        return ZaloBaseClient.this.sendHttpPostRequest(enpointUrl, body, header, type);
    }
    protected String sendHttpPostRequest(String enpointUrl, String body, Map<String, String> header,ContentType type) throws APIException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            try {
                HttpPost httpPost = new HttpPost(enpointUrl);
                if (header != null) {
                    for (Map.Entry<String, String> entry : header.entrySet()) {
//                    httpget.addHeader("authorization", String.format("bearer %s", keyCode));
                        httpPost.addHeader(entry.getKey(), entry.getValue());
                    }
                }
                StringEntity myEntity = new StringEntity(body,
                        type);
                httpPost.setEntity(myEntity);

                CloseableHttpResponse response = httpclient.execute(httpPost);
                try {
                    HttpEntity entity = response.getEntity();
                    return EntityUtils.toString(entity);
                } finally {
                    response.close();
                }
            } catch (Exception ex) {
                throw new APIException(ex);
            } finally {
                httpclient.close();
            }
        } catch (APIException | IOException | UnsupportedCharsetException | ParseException ex) {
             throw new APIException(ex);
        }
    }

    protected String sendHttpUploadRequest(String enpointUrl, File file, Map<String, String> params, Map<String, String> header) throws APIException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            try {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                HttpPost uploadFile = new HttpPost(enpointUrl);
                if (header != null) {
                    for (Map.Entry<String, String> entry : header.entrySet()) {
//                    httpget.addHeader("authorization", String.format("bearer %s", keyCode));
                        uploadFile.addHeader(entry.getKey(), entry.getValue());
                    }
                }
                MultipartEntityBuilder builder = MultipartEntityBuilder.create();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    builder.addTextBody(entry.getKey(), entry.getValue(), ContentType.TEXT_PLAIN);
                }
                // This attaches the file to the POST:
                builder.addBinaryBody(
                        "file",
                        new FileInputStream(file),
                        ContentType.APPLICATION_OCTET_STREAM,
                        file.getName()
                );
                HttpEntity multipart = builder.build();
                uploadFile.setEntity(multipart);
                CloseableHttpResponse response = httpClient.execute(uploadFile);
                try {
                    HttpEntity entity = response.getEntity();
                    return EntityUtils.toString(entity);
                } finally {
                    response.close();
                }

            } catch (IOException ex) {
                throw new APIException(ex);
            } finally {
                httpclient.close();
            }
        } catch (APIException | IOException | ParseException ex) {
            throw new APIException(ex);
        }
    }

}
