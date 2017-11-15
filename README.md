# Zalo SDK for Java (v1.0.0)

## Hướng dẫn sử dụng Social API
**Create an instance of the Zalo class**
```java
long appId = 0l; // put your app id here
String secretKey = "put_your_app_secret_key_here";
String callBackUrl = "put_your_call_back_url_here"
Zalo3rdAppInfo appInfo = new Zalo3rdAppInfo(appId, secretKey, callBackUrl);
Zalo3rdAppClient sdk = new Zalo3rdAppClient(appInfo);
```

## Social API
**Lấy LoginUrl**
```java
String loginUrl = sdk.getLoginUrl();
```

**Lấy AccessToken**
```java
String code = "put_your_oauth_code_here";
JsonObject accessToken = sdk.getAccessToken(code);
String accessToken = accessToken.get("access_token").getAsString();
int expiresIn = accessToken.get("expires_in").getAsInt();
```

**Thông tin người dùng**
```java
String accessToken = "put_your_access_token_here";
String params = "id,name,picture.type(large),gender,birthday";
JsonObject profile = sdk.getProfile(accessToken, params);
```

**Danh sách bạn bè**
```java
String accessToken = "put_your_access_token_here";
String params = "id,name,picture.type(large),gender,birthday";
int offset = 0; // start index
int count = 10; // total record you want get
JsonObject friends =  sdk.getFriends(accessToken, offset, count, params);
```

**Danh sách bạn bè có thể được mời sử dụng ứng dụng**
```java
String accessToken = "put_your_access_token_here";
String params = "id,name,picture.type(large),gender,birthday";
int offset = 0; // start index
int count = 100; // total record you want get
JsonObject invitableFriends = sdk.getInvitableFriends(accessToken, offset, count, params);
```

**Đăng bài viết**
```java
String accessToken = "put_your_access_token_here";
String textShare = "put_your_text_here";
String linkShare = "put_your_link_here";
JsonObject postFeed =  sdk.postFeed(accessToken, textShare, linkShare);
```

**Mời sử dụng ứng dụng**
```java
String accessToken = "put_your_access_token_here";
String text = "put_your_text_here";
String linkShare = "put_your_link_here";
JsonObject sendAppRequest = sdk.sendAppRequest(accessToken, Arrays.asList(3241414134132l), text);
```

**Gởi tin nhắn tới bạn bè**
```java
String accessToken = "put_your_access_token_here";
long userId = 0l; // put your friends uid here
String textMessage = "put_your_message_here";
String link = "put_your_link_here";
JsonObject sendMessage = sdk.sendMessage(accessToken, userId, textMessage, link);
```

## Official Account Open API

```java
long oaid = 0l; // put your oaid here
String secrect = "put_your_oa_secret_key_here";
ZaloOaInfo info = new ZaloOaInfo(oaid, secrect);
ZaloOaClient oaClient = new ZaloOaClient(info);
```

**Lấy thông tin người theo dõi**
```java
long userid = 0l // user id or phone number;
JsonObject profile = oaClient.getProfile(userid);
```

**Gửi tin nhắn text**
```java
long userid = 0l // user id;
String message = "Zalo Java SDK Test Message";
JsonObject ret = oaClient.sendTextMessage(userid, message);
```

**Lấy trạng thái tin nhắn**
```java
String msgid = "message id";
JsonObject ret = oaClient.getMessageStatus(msgid);
```

**Upload hình ảnh**
```java
String fileUrl = "url of file you want to upload or absolute file path";
JsonObject ret = oaClient.uploadPhoto(fileUrl);
```

**Upload ảnh Gìf**
```java
String fileUrl = "url of file you want to upload or absolute file path";
JsonObject ret = oaClient.uploadGifPhoto(fileUrl);
```

**Gửi tin nhắn hình**
```java
long userid = 0l // user id;
MsgImage image = new MsgImage();
image.setImageid("imageid");
image.setMessage("Zalo Java SDK");
JsonObject ret = oaClient.sendImageMessage(userid, image);
```

**Gửi tin nhắn ảnh Gif**
```java
long userid = 0l // user id;
MsgGif gif = new MsgGif();
gif.setImageid("imageid");
gif.setHeight(100);
gif.setWidth(100);
JsonObject ret = oaClient.sendGifMessage(userid, gif);
```

**Gửi tin nhắn dạng liên kết**
```java
long userid = 0l // user id;
MsgLink link = new MsgLink();
link.setLink("https://developers.zalo.me/");
link.setLinkdes("Document For Developers");
link.setLinkthumb("https://developers.zalo.me/web/static/images/bg.jpg");
link.setLinktitle("Zalo For Developers");
JsonObject ret = oaClient.sendLinkMessage(userid, Arrays.asList(link));
```

**Gửi tin nhắn tương tác**
```java
long userid = 0l // user id;
MsgAction action = new OpenInAppAction();
action.setTitle("Send interactive messages");
action.setDescription("This is a test for API send interactive messages");
action.setThumb("https://developers.zalo.me/web/static/images/bg.jpg");

JsonObject popup = new JsonObject();
popup.addProperty("title", "Open Website Zalo For Developers");
popup.addProperty("desc", "Click ok to visit Zalo For Developers and read more Document");
popup.addProperty("ok", "ok");
popup.addProperty("cancel", "cancel");
action.setPopup(popup);

JsonObject ret  =  oaClient.sendActionMessage(userid, Arrays.asList(action));
```

**Gửi tin nhắn chăm sóc khách hàng tới số điện thoại**
```java
String phone = "";
String templateId = "";
JsonObject templateData = new JsonObject();
templateData.addProperty("content", "This is a test for API send  a customer support message to the phone number");
JsonObject ret  =  oaClient.sendMessageCustomerCareByPhone(phone, templateId, templateData);
```

**Gửi tin nhắn chăm sóc khách hàng**
```java
long userid = 0l // user id;
String templateId = "";
JsonObject templateData = new JsonObject();
templateData.addProperty("content", "This is a test for API send  a customer support message to user id");
JsonObject ret  =  oaClient.sendMessageCustomerCareByUserId(userid, templateId, templateData);
```

**Gửi tin nhắn Sticker**
```java
long userid = 0l; // user id
String stickerid = ""; // sticker id
JsonObject ret  =  oaClient.sendStickerMessage(userid, stickerid);
```

**Trả lời tin nhắn dạng text**
```java
String msgid = ""; // message id
String message = "";
JsonObject ret  =  oaClient.replyTextMessage(msgid, message);
```

**Trả lời tin nhắn dạng hình**
```java
String msgid = ""; // message id
String imageid = ""; // image id
String message = "";
JsonObject ret  =  oaClient.replyImageMessage(msgid, imageid, message);
```

**Trả lời tin nhắn dạng liên kết**
```java
String msgid = ""; // message id
MsgLink link = new MsgLink();
link.setLink("https://developers.zalo.me/");
link.setLinkdes("Document For Developers");
link.setLinkthumb("https://developers.zalo.me/web/static/images/bg.jpg");
link.setLinktitle("Zalo For Developers");
JsonObject ret  =  oaClient.replyLinksMessage(msgid, Arrays.asList(link));
```

**Tạo QR Code**
```java
String qrdata = "";
int size = 0;
JsonObject ret  =  oaClient.createQRCode(qrdata, size);
```

## Versioning

Current version is 1.0.0. We will update more features in next version.

## Authors

* **Zalo's developers** 

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

