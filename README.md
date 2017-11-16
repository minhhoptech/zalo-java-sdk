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

## Hướng dẫn sử dụng Official Account Open API
### Zalo Official Account API
**Create an instance of the Zalo OA class**
```java
long oaid = 0l; // put your oaid here
String secrect = "put_your_oa_secret_key_here";
ZaloOaInfo info = new ZaloOaInfo(oaid, secrect);
ZaloOaClient oaClient = new ZaloOaClient(info);
```

**Lấy thông tin người theo dõi**
```java
long userId = 0l // user id or phone number;
JsonObject profile = oaClient.getProfile(userId);
```

**Gửi tin nhắn text**
```java
long userId = 0l // user id;
String message = "Zalo Java SDK Test Message";
JsonObject ret = oaClient.sendTextMessage(userId, message);
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
long userId = 0l // user id;
MsgImage image = new MsgImage();
image.setImageid("imageid");
image.setMessage("Zalo Java SDK");
JsonObject ret = oaClient.sendImageMessage(userId, image);
```

**Gửi tin nhắn ảnh Gif**
```java
long userId = 0l // user id;
MsgGif gif = new MsgGif();
gif.setImageid("imageid");
gif.setHeight(100);
gif.setWidth(100);
JsonObject ret = oaClient.sendGifMessage(userId, gif);
```

**Gửi tin nhắn dạng liên kết**
```java
long userId = 0l // user id;
MsgLink link = new MsgLink();
link.setLink("https://developers.zalo.me/");
link.setLinkdes("Document For Developers");
link.setLinkthumb("https://developers.zalo.me/web/static/images/bg.jpg");
link.setLinktitle("Zalo For Developers");
JsonObject ret = oaClient.sendLinkMessage(userId, Arrays.asList(link));
```

**Gửi tin nhắn tương tác**
```java
long userId = 0l // user id;
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

JsonObject ret  =  oaClient.sendActionMessage(userId, Arrays.asList(action));
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
long userId = 0l // user id;
String templateId = "";
JsonObject templateData = new JsonObject();
templateData.addProperty("content", "This is a test for API send  a customer support message to user id");
JsonObject ret  =  oaClient.sendMessageCustomerCareByUserId(userId, templateId, templateData);
```

**Gửi tin nhắn Sticker**
```java
long userId = 0l; // user id
String stickerid = ""; // sticker id
JsonObject ret  =  oaClient.sendStickerMessage(userId, stickerid);
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

### Zalo Official Account API Onbehalf
**Create an instance of the Zalo OA class**
```java
long appId = 0l; // put your appid here
String appSecrectKey = "put_your_app_secret_key_here";
String callbackUrl = "put_your_call_back_url_here";
ZaloAppInfo appInfo = new ZaloAppInfo(appId, appSecrectKey, callbackUrl);
ZaloOaClient oaClient = new ZaloOaClient(appInfo);
```

**Cài đặt proxy**
```java
String proxyHost = "";
int proxyPort = 0;
oaClient.setProxy(proxyHost, proxyPort);
```

**Lấy login url**
```java
String url = oaClient.getLoginOAUrl();
```

**Lấy thông tin người theo dõi**
```java
long userId = 0l // user id or phone number;
String accessToken = "put_your_access_token_here";
JsonObject profile = oaClient.getProfile(userId, accessToken);
```

**Lấy thông tin Offical Account**
```java
String accessToken = "put_your_access_token_here";
JsonObject oaInfo = oaClient.getOAInfo(accessToken);
```

**Lấy đoạn hội thoại giữa người quan tâm và OA**
```java
long userId = 0l // user id;
String accessToken = "put_your_access_token_here";
int offset = 0;
int count = 10;
JsonObject conversation = oaClient.getOAConversation(userId, accessToken, offset, count);
```

**Lấy danh sách người quan tâm vừa chat với OA**
```java
String accessToken = "put_your_access_token_here";
int offset = 0;
int count = 10;
JsonObject listRecentChat = oaClient.getOAListRecentChat(accessToken, offset, count);
```

**Upload hình ảnh**
```java
String accessToken = "put_your_access_token_here";
APIConfig.setTempDir("put_your_temporary_directory_here"); // upload from url need this setting
String fileUrl = "url of file you want to upload";
JsonObject uploadByUrl = oaClient.uploadPhotoFromUrl(fileUrl, accessToken);
String filePath = "absolute path of file you want to upload";
JsonObject uploadByPath = oaClient.uploadPhoto(filePath, accessToken);
```

**Upload ảnh Gìf**
```java
String accessToken = "put_your_access_token_here";
APIConfig.setTempDir("put_your_temporary_directory_here"); // upload from url need this setting
String fileUrl = "url of file you want to upload";
JsonObject uploadByUrl = oaClient.uploadGifPhotoFromUrl(fileUrl, accessToken);
String filePath = "absolute path of file you want to upload";
JsonObject uploadByPath = oaClient.uploadGifPhoto(filePath, accessToken);
```

**Gửi tin nhắn text**
```java
long userId = 0l // user id;
String message = "Zalo Java SDK Test Message";
String accessToken = "put_your_access_token_here";
JsonObject ret = oaClient.sendTextMessage(userId, message, accessToken);
```

**Gửi tin nhắn hình**
```java
long userId = 0l // user id;
String accessToken = "put_your_access_token_here";
MsgImage imageMsg = new MsgImage();
imageMsg.setImageid("imageid");
imageMsg.setMessage("Zalo Java SDK");
JsonObject ret = oaClient.sendImageMessage(userId, imageMsg, accessToken);
```

**Gửi tin nhắn ảnh Gif**
```java
long userId = 0l // user id;
String accessToken = "put_your_access_token_here";
MsgGif gifMsg = new MsgGif();
gifMsg.setImageid("imageid");
gifMsg.setHeight(100);
gifMsg.setWidth(100);
JsonObject ret = oaClient.sendGifMessage(userId, gifMsg, accessToken);
```

**Gửi tin nhắn dạng liên kết**
```java
long userId = 0l // user id;
String accessToken = "put_your_access_token_here";
MsgLink link = new MsgLink();
link.setLink("https://developers.zalo.me/");
link.setLinkdes("Document For Developers");
link.setLinkthumb("https://developers.zalo.me/web/static/images/bg.jpg");
link.setLinktitle("Zalo For Developers");
List<MsgLink> links = Arrays.asList(link);
JsonObject ret = oaClient.sendLinkMessage(userId, links, accessToken);
```

**Gửi tin nhắn tương tác**
```java
long userId = 0l // user id;
String accessToken = "put_your_access_token_here";
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
List<MsgAction> actions = Arrays.asList(action);
JsonObject ret  =  oaClient.sendActionMessage(userId, actions, accessToken);
```

**Gửi tin nhắn Sticker**
```java
long userId = 0l; // user id
String accessToken = "put_your_access_token_here";
String stickerId = ""; // sticker id
JsonObject ret  =  oaClient.sendStickerMessage(userId, stickerId, accessToken);
```

**Trả lời tin nhắn dạng text**
```java
String msgid = ""; // message id
String accessToken = "put_your_access_token_here";
String message = "";
JsonObject ret  =  oaClient.replyTextMessage(msgId, message, accessToken);
```

**Trả lời tin nhắn dạng hình**
```java
String msgid = ""; // message id
String accessToken = "put_your_access_token_here";
MsgImage imageMsg = new MsgImage();
imageMsg.setImageid("put_image_id_here");
imageMsg.setMessage("put_message_here");
JsonObject ret  =  oaClient.replyImageMessage(msgId, imageMsg, accessToken);
```

**Trả lời tin nhắn dạng liên kết**
```java
String msgid = ""; // message id
String accessToken = "put_your_access_token_here";
MsgLink link = new MsgLink();
link.setLink("https://developers.zalo.me/");
link.setLinkdes("Document For Developers");
link.setLinkthumb("https://developers.zalo.me/web/static/images/bg.jpg");
link.setLinktitle("Zalo For Developers");
List<MsgLink> links = Arrays.asList(link);
JsonObject ret  =  oaClient.replyLinksMessage(msgId, links, accessToken);
```

## Versioning

Current version is 1.0.0. We will update more features in next version.

## Authors

* **Zalo's developers** 

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

