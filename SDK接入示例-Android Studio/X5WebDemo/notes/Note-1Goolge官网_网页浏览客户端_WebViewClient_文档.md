# Goolge官网_网页浏览客户端_WebViewClient_文档
[WebViewClient  Android Developers](https://developer.android.com/reference/android/webkit/WebViewClient)
# webclient

---

# webclient


|                                                 |                              |
| ----------------------------------------------- | ---------------------------- |
| [java.lang.Object](/reference/java/lang/Object) |                              |
| ↳                                               | android.webkit.webViewClient |




- - -

## 总结

| ### 常数 |                                                              |
| -------- | ------------------------------------------------------------ |
| `int`    | `ERROR_AUTHENTICATION`服务器上的用户身份验证失败             |
| `int`    | `ERROR_BAD_URL`格式错误的网址                                |
| `int`    | `ERROR_CONNECT`无法连接到服务器                              |
| `int`    | `ERROR_FAILED_SSL_HANDSHAKE`无法执行 SSL 握手                |
| `int`    | `ERROR_FILE`通用文件错误                                     |
| `int`    | `ERROR_FILE_NOT_FOUND`找不到文件                             |
| `int`    | `ERROR_HOST_LOOKUP`服务器或代理主机名查找失败                |
| `int`    | `ERROR_IO`无法读取或写入服务器                               |
| `int`    | `ERROR_PROXY_AUTHENTICATION`代理上的用户身份验证失败         |
| `int`    | `ERROR_REDIRECT_LOOP`重定向过多                              |
| `int`    | `ERROR_TIMEOUT`连接超时                                      |
| `int`    | `ERROR_TOO_MANY_REQUESTS`此加载期间请求过多                  |
| `int`    | `ERROR_UNKNOWN`一般错误                                      |
| `int`    | `ERROR_UNSAFE_RESOURCE`安全浏览功能已取消资源加载            |
| `int`    | `ERROR_UNSUPPORTED_AUTH_SCHEME`不支持的身份验证方案（非基本或摘要式） |
| `int`    | `ERROR_UNSUPPORTED_SCHEME`不支持的 URI 方案                  |
| `int`    | `SAFE_BROWSING_THREAT_BILLING`资源已被阻止，因为它可能会诱骗用户签订计费协议。 |
| `int`    | `SAFE_BROWSING_THREAT_MALWARE`资源已被阻止，因为它包含恶意软件。 |
| `int`    | `SAFE_BROWSING_THREAT_PHISHING`资源被阻止，因为它包含欺骗性内容。 |
| `int`    | `SAFE_BROWSING_THREAT_UNKNOWN`资源因未知原因被阻止。         |
| `int`    | `SAFE_BROWSING_THREAT_UNWANTED_SOFTWARE`资源被阻止，因为它包含不需要的软件。 |

| ### 公共构造函数  |      |
| ----------------- | ---- |
| `WebViewClient()` |      |

| ### 公共方法          |                                                              |
| --------------------- | ------------------------------------------------------------ |
| `void`                | `doUpdateVisitedHistory(WebView view,String url,boolean isReload)`通知主机应用程序更新其访问的链接数据库。 |
| `void`                | `onFormResubmission(WebView view,Message dontResend,Message resend)`作为主机应用程序，如果浏览器应将数据重新发送为 请求的页面是开机自检的结果。 |
| `void`                | `onLoadResource(WebView view,String url)`通知主机应用程序 Web 视图将加载资源 由给定的 URL 指定。 |
| `void`                | `onPageCommitVisible(WebView view,String url)`通知主机应用程序剩余的内容 将不再绘制以前的页面导航。`WebView` |
| `void`                | `onPageFinished(WebView view,String url)`通知主机应用程序页面已加载完毕。 |
| `void`                | `onPageStarted(WebView view,String url,Bitmap favicon)`通知主机应用程序页面已开始加载。 |
| `void`                | `onReceivedClientCertRequest(WebView view,ClientCertRequest request)`通知主机应用程序处理 SSL 客户端证书请求。 |
| `void`                | `onReceivedError(WebView view,int errorCode,String description,String failingUrl)`_此方法已弃用 在 API 级别 23 中。 请改用``。_ |
| `void`                | `onReceivedError(WebView view,WebResourceRequest request,WebResourceError error)`向主机应用程序报告 Web 资源加载错误。 |
| `void`                | `onReceivedHttpAuthRequest(WebView view,HttpAuthHandler handler,String host,String realm)`通知主机应用程序 Web 视图收到 HTTP 身份验证请求。 |
| `void`                | `onReceivedHttpError(WebView view,WebResourceRequest request,WebResourceResponse errorResponse)`通知主机应用程序已从服务器收到 HTTP 错误，同时 加载资源。 |
| `void`                | `onReceivedLoginRequest(WebView view,String realm,String account,String args)`通知主机应用程序自动登录的请求 用户已被处理。 |
| `void`                | `onReceivedSslError(WebView view,SslErrorHandler handler,SslError error)`通知主机应用程序加载 资源。 |
| `boolean`             | `onRenderProcessGone(WebView view,RenderProcessGoneDetail detail)`通知主机应用程序给定 WebView 的呈现进程已退出。 |
| `void`                | `onSafeBrowsingHit(WebView view,WebResourceRequest request,int threatType,SafeBrowsingResponse callback)`通知主机应用程序安全浏览已标记加载 URL。 |
| `void`                | `onScaleChanged(WebView view,float oldScale,float newScale)`通知主机应用程序应用于 WebView 的比例具有 改变。 |
| `void`                | `onTooManyRedirects(WebView view,Message cancelMsg,Message continueMsg)`_此方法已弃用 在 API 级别 15 中。 不再调用此方法。当 Web 视图遇到 重定向循环，它将取消加载。_ |
| `void`                | `onUnhandledKeyEvent(WebView view,KeyEvent event)`通知主机应用程序 Web 视图未处理密钥。 |
| `WebResourceResponse` | `shouldInterceptRequest(WebView view,WebResourceRequest request)`将资源请求通知主机应用程序，并允许 应用程序以返回数据。 |
| `WebResourceResponse` | `shouldInterceptRequest(WebView view,String url)`_此方法已弃用 在 API 级别 21 中。 请改用``。_ |
| `boolean`             | `shouldOverrideKeyEvent(WebView view,KeyEvent event)`为主机应用程序提供同步处理密钥事件的机会。 |
| `boolean`             | `shouldOverrideUrlLoading(WebView view,WebResourceRequest request)`让主机应用程序有机会在 URL 即将加载到 当前网络视图。 |
| `boolean`             | `shouldOverrideUrlLoading(WebView view,String url)`_此方法已弃用 在 API 级别 24 中。 请改用``。_ |



### 继承的方法

从课堂` java.lang.Object`

|                  |                                                              |
| ---------------- | ------------------------------------------------------------ |
| `Object`         | `clone()`Creates and returns a copy of this object.          |
| `boolean`        | `equals(Object obj)`Indicates whether some other object is "equal to" this one. |
| `void`           | `finalize()`Called by the garbage collector on an object when garbage collection determines that there are no more references to the object. |
| `final Class<?>` | `getClass()`Returns the runtime class of this . `Object`     |
| `int`            | `hashCode()`Returns a hash code value for the object.        |
| `final void`     | `notify()`Wakes up a single thread that is waiting on this object's monitor. |
| `final void`     | `notifyAll()`Wakes up all threads that are waiting on this object's monitor. |
| `String`         | `toString()`Returns a string representation of the object.   |
| `final void`     | `wait(long timeoutMillis,int nanos)`Causes the current thread to wait until it is awakened, typically by being _notified_ or _interrupted_, or until a certain amount of real time has elapsed. |
| `final void`     | `wait(long timeoutMillis)`Causes the current thread to wait until it is awakened, typically by being _notified_ or _interrupted_, or until a certain amount of real time has elapsed. |
| `final void`     | `wait()`Causes the current thread to wait until it is awakened, typically by being _notified_ or _interrupted_. |



## 常数

### ERROR\_AUTHENTICATION

[在 API 级别 5](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int ERROR_AUTHENTICATION
```

服务器上的用户身份验证失败

常量值： -4 （0xfffffffc）

### ERROR\_BAD\_URL

[在 API 级别 5](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int ERROR_BAD_URL
```

格式错误的网址

常量值： -12 （0xfffffff4）

### ERROR\_CONNECT

[在 API 级别 5](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int ERROR_CONNECT
```

无法连接到服务器

常量值： -6 （0xfffffffa）

### ERROR\_FAILED\_SSL\_HANDSHAKE

[在 API 级别 5](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int ERROR_FAILED_SSL_HANDSHAKE
```

无法执行 SSL 握手

常量值： -11 （0xfffffff5）

### ERROR\_FILE

[在 API 级别 5](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int ERROR_FILE
```

通用文件错误

常量值： -13 （0xfffffff3）

### ERROR\_FILE\_NOT\_FOUND

[在 API 级别 5](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int ERROR_FILE_NOT_FOUND
```

找不到文件

常量值： -14 （0xfffffff2）

### ERROR\_HOST\_LOOKUP

[在 API 级别 5](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int ERROR_HOST_LOOKUP
```

服务器或代理主机名查找失败

常量值： -2 （0xfffffffe）

### ERROR\_IO

[在 API 级别 5](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int ERROR_IO
```

无法读取或写入服务器

常量值： -7 （0xfffffff9）

### ERROR\_PROXY\_AUTHENTICATION

[在 API 级别 5](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int ERROR_PROXY_AUTHENTICATION
```

代理上的用户身份验证失败

常量值： -5 （0xfffffffb）

### ERROR\_REDIRECT\_LOOP

[在 API 级别 5](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int ERROR_REDIRECT_LOOP
```

重定向过多

常量值： -9 （0xfffffff7）

### ERROR\_TIMEOUT

[在 API 级别 5](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int ERROR_TIMEOUT
```

连接超时

常量值： -8 （0xfffffff8）

### ERROR\_TOO\_MANY\_REQUESTS

[在 API 级别 5](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int ERROR_TOO_MANY_REQUESTS
```

此加载期间请求过多

常量值： -15 （0xfffffff1）

### ERROR\_UNKNOWN

[在 API 级别 5](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int ERROR_UNKNOWN
```

一般错误

常量值： -1 （0xffffffff）

### ERROR\_UNSAFE\_RESOURCE

[在 API 级别 26](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int ERROR_UNSAFE_RESOURCE
```

安全浏览功能已取消资源加载

常量值： -16 （0xfffffff0）

### ERROR\_UNSUPPORTED\_AUTH\_SCHEME

[在 API 级别 5](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int ERROR_UNSUPPORTED_AUTH_SCHEME
```

不支持的身份验证方案（非基本或摘要式）

常量值： -3 （0xfffffffd）

### ERROR\_UNSUPPORTED\_SCHEME

[在 API 级别 5](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int ERROR_UNSUPPORTED_SCHEME
```

不支持的 URI 方案

常量值： -10 （0xfffffff6）

### SAFE\_BROWSING\_THREAT\_BILLING

[在 API 级别 29](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int SAFE_BROWSING_THREAT_BILLING
```

资源已被阻止，因为它可能会诱骗用户签订计费协议。

仅当 targetSdkVersion 至少为 .否则，使用 相反。`Build.VERSION_CODES.Q``SAFE_BROWSING_THREAT_UNKNOWN`

常量值： 4 （0x00000004）

### SAFE\_BROWSING\_THREAT\_MALWARE

[在 API 级别 27](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int SAFE_BROWSING_THREAT_MALWARE
```

资源已被阻止，因为它包含恶意软件。

常量值： 1 （0x00000001）

### SAFE\_BROWSING\_THREAT\_PHISHING

[在 API 级别 27](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int SAFE_BROWSING_THREAT_PHISHING
```

资源被阻止，因为它包含欺骗性内容。

常量值： 2 （0x00000002）

### SAFE\_BROWSING\_THREAT\_UNKNOWN

[在 API 级别 27](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int SAFE_BROWSING_THREAT_UNKNOWN
```

资源因未知原因被阻止。

常量值： 0 （0x00000000）

### SAFE\_BROWSING\_THREAT\_UNWANTED\_SOFTWARE

[在 API 级别 27](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public static final int SAFE_BROWSING_THREAT_UNWANTED_SOFTWARE
```

资源被阻止，因为它包含不需要的软件。

常量值： 3 （0x00000003）

## 公共构造函数

### 网络视图客户端

```
public WebViewClient ()
```

## 公共方法

### doUpdateVisitedHistory

[在 API 级别 1](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public void doUpdateVisitedHistory (WebView view, 
                String url, 
                boolean isReload)
```

通知主机应用程序更新其访问的链接数据库。

| 参数       |                                           |
| ---------- | ----------------------------------------- |
| `view`     | `WebView`：启动回调的 Web 视图。          |
| `url`      | `String`：正在访问的网址。                |
| `isReload` | `boolean`：如果正在重新加载此 URL。`true` |

### 在表单上重新提交

[在 API 级别 1](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public void onFormResubmission (WebView view, 
                Message dontResend, 
                Message resend)
```

作为主机应用程序，如果浏览器应将数据重新发送为 请求的页面是开机自检的结果。默认设置是不重新发送 数据。

| 参数         |                                               |
| ------------ | --------------------------------------------- |
| `view`       | `WebView`：启动回调的 Web 视图。              |
| `dontResend` | `Message`：浏览器不应重新发送时要发送的消息   |
| `resend`     | `Message`：浏览器应重新发送数据时要发送的消息 |

### 加载资源

[在 API 级别 1](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public void onLoadResource (WebView view, 
                String url)
```

通知主机应用程序 Web 视图将加载资源 由给定的 URL 指定。

| 参数   |                                        |
| ------ | -------------------------------------- |
| `view` | `WebView`：启动回调的 Web 视图。       |
| `url`  | `String`：Web 视图将加载的资源的 URL。 |

### onPageCommitVisible

[在 API 级别 23](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public void onPageCommitVisible (WebView view, 
                String url)
```

通知主机应用程序剩余的内容 将不再绘制以前的页面导航。`WebView`

此回调可用于确定使回收的内容可见的安全点，以确保不显示过时的内容。它被称为 在可以保证的最早点上不会 更长的时间绘制以前导航中的任何内容。下一次抽奖将显示 的 或部分 新加载的页面的内容。`WebView``WebView#onDraw``background color``WebView`

当 HTTP 响应的正文开始加载时，将调用此方法，并反映出来 在 DOM 中，并将在随后的抽奖中可见。此回调发生在 文档加载过程，因此您应该期望链接的资源（例如， CSS 和图像）可能不可用。

有关可视状态更新的更细粒度通知，请参见。`WebView.postVisualStateCallback(long, VisualStateCallback)`

请注意，适用于的所有条件和建议也适用于此 API。`WebView#postVisualStateCallback`

此回调仅用于主帧导航。

| 参数   |                                            |
| ------ | ------------------------------------------ |
| `view` | `WebView`：发生导航的位置。`WebView`       |
| `url`  | `String`：触发该回调的页面导航对应的 URL。 |

### 上页完成

[在 API 级别 1](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public void onPageFinished (WebView view, 
                String url)
```

通知主机应用程序页面已加载完毕。此方法 仅对主机调用。接收回调不会 保证 WebView 绘制的下一帧将反映此时 DOM 的状态 点。为了收到当前 DOM 状态已准备好呈现的通知，请请求 视觉状态回调和等待提供的 要触发的回调。`onPageFinished()``WebView#postVisualStateCallback`

| 参数   |                                  |
| ------ | -------------------------------- |
| `view` | `WebView`：启动回调的 Web 视图。 |
| `url`  | `String`：页面的网址。           |

### onPageStarted

[在 API 级别 1](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public void onPageStarted (WebView view, 
                String url, 
                Bitmap favicon)
```

通知主机应用程序页面已开始加载。此方法 为每个主帧加载调用一次，因此具有 iframe 或 框架集将为主框架调用一次 onPageStarted。这也 表示当 onPageStarted 的内容 嵌入的帧更改，即单击目标为 iframe 的链接， 片段导航也不会调用它（导航到 #fragment\_id）。

| 参数      |                                                 |
| --------- | ----------------------------------------------- |
| `view`    | `WebView`：启动回调的 Web 视图。                |
| `url`     | `String`：要加载的网址。                        |
| `favicon` | `Bitmap`：此页面的图标（如果它已存在于 数据库。 |

### onReceivedClientCertRequest

[在 API 级别 21](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public void onReceivedClientCertRequest (WebView view, 
                ClientCertRequest request)
```

通知主机应用程序处理 SSL 客户端证书请求。主机应用程序 负责显示 UI 并提供密钥（如果需要）。有三种方法可以 响应：、 或 。Webview 将响应存储在内存中（在 应用程序）如果或 已呼叫，并且不再呼叫同一主机，并且 端口对。如果调用，则 Web 视图不存储响应。请注意，铬网络堆栈中的多层可能是 缓存响应，因此忽略的行为只是最佳情况 努力。 此方法在 UI 线程上调用。在回调期间， 连接已挂起。 对于大多数用例，应用程序应实现接口并将其传递给以启动 用户选择正确别名的活动。钥匙串活动将 通过实现的接口中的回调方法提供别名。下一个 应用程序应创建一个异步任务来调用以接收密钥。 可以在 [AOSP 浏览器中](https://android.googlesource.com/platform/packages/apps/Browser/+/android-5.1.1_r1/src/com/android/browser/Tab.java)看到客户端证书的示例实现 默认行为是取消，不返回任何客户端证书。`ClientCertRequest#proceed``ClientCertRequest#cancel``ClientCertRequest.ignore()``ClientCertRequest#proceed``ClientCertRequest#cancel``onReceivedClientCertRequest()``ClientCertRequest#ignore``KeyChainAliasCallback``KeyChain.choosePrivateKeyAlias(Activity, KeyChainAliasCallback, String, Principal, Uri, String)``KeyChain.getPrivateKey(Context, String)`

| 参数      |                                                  |
| --------- | ------------------------------------------------ |
| `view`    | `WebView`：启动回调的 Web 视图                   |
| `request` | `ClientCertRequest`：一个实例`ClientCertRequest` |

### onReceiveError

在 API 级别 1 中添加 在 [API 级别](/guide/topics/manifest/uses-sdk-element#ApiLevels)中\
已弃用[ 23](/guide/topics/manifest/uses-sdk-element#ApiLevels)

```
public void onReceivedError (WebView view, 
                int errorCode, 
                String description, 
                String failingUrl)
```

**此方法已弃用 在 API 级别 23 中。**\
请改用。`onReceivedError(WebView, WebResourceRequest, WebResourceError)`

向主机应用程序报告错误。这些错误是不可恢复的 （即主要资源不可用）。参数 对应于其中一个常量。`errorCode``ERROR_*`

| 参数          |                                        |
| ------------- | -------------------------------------- |
| `view`        | `WebView`：启动回调的 Web 视图。       |
| `errorCode`   | `int`：对应于 ERROR\_\* 值的错误代码。 |
| `description` | `String`：描述错误的字符串。           |
| `failingUrl`  | `String`：加载失败的网址。             |

### onReceiveError

[在 API 级别 23](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public void onReceivedError (WebView view, 
                WebResourceRequest request, 
                WebResourceError error)
```

向主机应用程序报告 Web 资源加载错误。这些错误通常表明 无法连接到服务器。请注意，与已弃用的回调版本不同， 新版本将针对任何资源（iframe，图像等）调用，而不仅仅是主资源 页。因此，建议在此回调中执行所需的最小工作。

| 参数      |                                          |
| --------- | ---------------------------------------- |
| `view`    | `WebView`：启动回调的 Web 视图。         |
| `request` | `WebResourceRequest`：发起请求。         |
| `error`   | `WebResourceError`：有关发生错误的信息。 |

### onReceivedHttpAuthRequest

[在 API 级别 1](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public void onReceivedHttpAuthRequest (WebView view, 
                HttpAuthHandler handler, 
                String host, 
                String realm)
```

通知主机应用程序 Web 视图收到 HTTP 身份验证请求。主机应用程序可以使用提供的来设置 WebView 对请求的响应。 默认行为是取消请求。`HttpAuthHandler`

**注意：**提供的 HttpAuthHandler 必须用于 UI 线程。

| 参数      |                                                            |
| --------- | ---------------------------------------------------------- |
| `view`    | `WebView`：启动回调的 Web 视图                             |
| `handler` | `HttpAuthHandler`：用于设置 Web 视图响应的 HttpAuthHandler |
| `host`    | `String`：需要身份验证的主机                               |
| `realm`   | `String`：需要身份验证的领域                               |

**另请参阅：**

* `WebView.getHttpAuthUsernamePassword(String, String)`

### onReceivedHttpError

[在 API 级别 23](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public void onReceivedHttpError (WebView view, 
                WebResourceRequest request, 
                WebResourceResponse errorResponse)
```

通知主机应用程序已从服务器收到 HTTP 错误，同时 加载资源。HTTP 错误的状态代码为 >= 400。此回调将调用 对于任何资源（iframe、图像等），而不仅仅是主页。因此，建议 以在此回调中执行所需的最小工作。请注意，服务器的内容 参数中可能未提供响应。`errorResponse`

| 参数            |                                             |
| --------------- | ------------------------------------------- |
| `view`          | `WebView`：启动回调的 Web 视图。            |
| `request`       | `WebResourceRequest`：发起请求。            |
| `errorResponse` | `WebResourceResponse`：有关发生错误的信息。 |

### onReceivedLoginRequest

[在 API 级别 12](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public void onReceivedLoginRequest (WebView view, 
                String realm, 
                String account, 
                String args)
```

通知主机应用程序自动登录的请求 用户已被处理。

| 参数      |                                                              |
| --------- | ------------------------------------------------------------ |
| `view`    | `WebView`：请求登录的 Web 视图。                             |
| `realm`   | `String`：用于查找帐户的帐户领域。                           |
| `account` | `String`：可选帐户。如果不是，则帐户应为 根据设备上的帐户进行检查。如果它是有效的 帐户，它应该用于登录用户。`null` |
| `args`    | `String`：用于登录用户的身份验证器特定参数。                 |

### onReceivedSslError

[在 API 级别 8](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public void onReceivedSslError (WebView view, 
                SslErrorHandler handler, 
                SslError error)
```

通知主机应用程序加载 资源。主机应用程序必须调用 或 。请注意，该决定可能会保留以用于 响应将来的 SSL 错误。默认行为是取消 负荷。`SslErrorHandler#cancel``SslErrorHandler#proceed`

仅针对可恢复的 SSL 证书错误调用此 API。在以下情况下： 不可恢复的错误（例如，当服务器使客户端出现故障时），WebView 将使用 进行调用。`onReceivedError(android.webkit.WebView, android.webkit.WebResourceRequest, android.webkit.WebResourceError)``ERROR_FAILED_SSL_HANDSHAKE`

建议应用程序不要提示用户有关 SSL 错误的信息，因为 用户不太可能做出明智的安全决策 并且 WebView 不提供任何用于显示详细信息的 UI 以有意义的方式出错。

此方法的应用程序重写可能会显示自定义错误页或 以静默方式记录问题，但强烈建议始终调用并且永远不允许继续过去的错误。`SslErrorHandler#cancel`

| 参数      |                                                         |
| --------- | ------------------------------------------------------- |
| `view`    | `WebView`：启动回调的 Web 视图。                        |
| `handler` | `SslErrorHandler`：将处理用户的 响应。`SslErrorHandler` |
| `error`   | `SslError`：SSL 错误对象。                              |

### onRenderProcessGone

[在 API 级别 26](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public boolean onRenderProcessGone (WebView view, 
                RenderProcessGoneDetail detail)
```

通知主机应用程序给定 WebView 的呈现进程已退出。 多个 WebView 实例可能与单个呈现进程相关联; onRenderProcessGone将为受影响的每个WebView调用。 应用程序对此回调的实现应仅尝试 清理作为参数给出的特定 WebView，并且不应假设 其他 Web 视图实例受到影响。 给定的 WebView 无法使用，应从视图层次结构中删除， 应清除对它的所有引用，例如活动中的任何引用 或使用类似调用等保存的其他类。 若要出于测试目的导致呈现进程崩溃，应用程序可以 调用网络视图。请注意，多个 Web 视图 如果实例共享一个渲染进程，而不仅仅是 加载 chrome://crash 的特定网络视图。`View.findViewById(int)``loadUrl("chrome://crash")`

| 参数     |                                         |
| -------- | --------------------------------------- |
| `view`   | `WebView`：需要清理的 Web 视图。        |
| `detail` | `RenderProcessGoneDetail`：退出的原因。 |

| 返回      |                                                              |
| --------- | ------------------------------------------------------------ |
| `boolean` | `true`如果主机应用程序处理了该进程具有的情况 退出，否则，如果渲染进程崩溃，应用程序将崩溃， 或者，如果渲染进程被系统终止，则被杀死。 |

### 安全浏览命中

[在 API 级别 27](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public void onSafeBrowsingHit (WebView view, 
                WebResourceRequest request, 
                int threatType, 
                SafeBrowsingResponse callback)
```

通知主机应用程序安全浏览已标记加载 URL。 应用程序必须调用回调以指示首选响应。默认 行为是向用户显示插页式广告，并显示“报告”复选框。 如果应用程序需要显示自己的自定义插页式 UI，则可以调用回调 与 或 异步，具体取决于用户响应。`SafeBrowsingResponse#backToSafety``SafeBrowsingResponse.proceed(boolean)`

| 参数         |                                                              |
| ------------ | ------------------------------------------------------------ |
| `view`       | `WebView`：命中恶意资源的 Web 视图。                         |
| `request`    | `WebResourceRequest`：包含请求详细信息的对象。               |
| `threatType` | `int`：安全浏览捕获资源的原因，对应于一个值。 值为 、、 或`SAFE_BROWSING_THREAT_*``SAFE_BROWSING_THREAT_UNKNOWN``SAFE_BROWSING_THREAT_MALWARE``SAFE_BROWSING_THREAT_PHISHING``SAFE_BROWSING_THREAT_UNWANTED_SOFTWARE``SAFE_BROWSING_THREAT_BILLING` |
| `callback`   | `SafeBrowsingResponse`：应用程序必须调用其中一个回调方法。   |

### 规模已更改

[在 API 级别 1](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public void onScaleChanged (WebView view, 
                float oldScale, 
                float newScale)
```

通知主机应用程序应用于 WebView 的比例具有 改变。

| 参数       |                                  |
| ---------- | -------------------------------- |
| `view`     | `WebView`：启动回调的 Web 视图。 |
| `oldScale` | `float`：旧比例因子              |
| `newScale` | `float`：新的比例因子            |

### onTooMany重定向

在 API 级别 1 中添加 在 [API 级别](/guide/topics/manifest/uses-sdk-element#ApiLevels)中\
已弃用[ 15](/guide/topics/manifest/uses-sdk-element#ApiLevels)

```
public void onTooManyRedirects (WebView view, 
                Message cancelMsg, 
                Message continueMsg)
```

**此方法已弃用 在 API 级别 15 中。**\
不再调用此方法。当 Web 视图遇到 重定向循环，它将取消加载。

通知主机应用程序存在过多的 HTTP 重定向。作为主机应用程序，如果它想要继续 尝试加载资源。默认行为是发送取消 消息。

| 参数          |                                     |
| ------------- | ----------------------------------- |
| `view`        | `WebView`：启动回调的 Web 视图。    |
| `cancelMsg`   | `Message`：主机要取消时要发送的消息 |
| `continueMsg` | `Message`：主机要继续时要发送的消息 |

### onUnhandledKeyEvent

在 API 级别 1 中添加 在 [API 级别](/guide/topics/manifest/uses-sdk-element#ApiLevels)中\
已弃用[ 21](/guide/topics/manifest/uses-sdk-element#ApiLevels)

```
public void onUnhandledKeyEvent (WebView view, 
                KeyEvent event)
```

通知主机应用程序 Web 视图未处理密钥。 除系统密钥外，WebView 始终使用正常流中的密钥 或者如果返回.这称为异步 从哪里发送密钥。它为主机应用程序提供了机会 以处理未处理的键事件。`shouldOverrideKeyEvent(WebView, KeyEvent)``true`

| 参数    |                                  |
| ------- | -------------------------------- |
| `view`  | `WebView`：启动回调的 Web 视图。 |
| `event` | `KeyEvent`：关键事件。           |

### 应该拦截请求

[在 API 级别 21](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public WebResourceResponse shouldInterceptRequest (WebView view, 
                WebResourceRequest request)
```

将资源请求通知主机应用程序，并允许 应用程序以返回数据。如果返回值为 ，则 Web 视图 将继续像往常一样加载资源。否则，返回 将使用响应和数据。`null`

此回调用于各种 URL 方案（例如、、等），而不仅仅是那些通过网络发送请求的方案。 对于 URL、URL 或访问的资产，不需要这样做 通过或网址。`http(s):``data:``file:``javascript:``blob:``file:///android_asset/``file:///android_res/`

在重定向的情况下，仅对初始资源 URL 调用此 URL，而不对任何 后续重定向网址。

**注意：**此方法在线程上调用 除了 UI 线程之外，因此客户端应谨慎行事 访问私有数据或视图系统时。

**注意：**启用安全浏览功能后，这些网址仍会经历安全处理 浏览检查。如果不希望这样做，您可以使用 跳过对该主机的安全浏览检查，或者通过调用 来消除警告。`WebView#setSafeBrowsingWhitelist``onSafeBrowsingHit(WebView, WebResourceRequest, int, SafeBrowsingResponse)``SafeBrowsingResponse#proceed`

| 参数      |                                                |
| --------- | ---------------------------------------------- |
| `view`    | `WebView`：请求 资源。`WebView`                |
| `request` | `WebResourceRequest`：包含请求详细信息的对象。 |

| 返回                  |                                                              |
| --------------------- | ------------------------------------------------------------ |
| `WebResourceResponse` | A 包含 响应信息或 Web 视图是否应加载 资源本身。`WebResourceResponse``null` |

### 应该拦截请求

在 API 级别 11 中添加 在 [API 级别](/guide/topics/manifest/uses-sdk-element#ApiLevels)中\
已弃用[ 21](/guide/topics/manifest/uses-sdk-element#ApiLevels)

```
public WebResourceResponse shouldInterceptRequest (WebView view, 
                String url)
```

**此方法已弃用 在 API 级别 21 中。**\
请改用。`shouldInterceptRequest(WebView, WebResourceRequest)`

将资源请求通知主机应用程序，并允许 应用程序以返回数据。如果返回值为 ，则 Web 视图 将继续像往常一样加载资源。否则，返回 将使用响应和数据。`null`

此回调用于各种 URL 方案（例如、、等），而不仅仅是那些通过网络发送请求的方案。 对于 URL、URL 或访问的资产，不需要这样做 通过或网址。`http(s):``data:``file:``javascript:``blob:``file:///android_asset/``file:///android_res/`

在重定向的情况下，仅对初始资源 URL 调用此 URL，而不对任何 后续重定向网址。

**注意：**此方法在线程上调用 除了 UI 线程之外，因此客户端应谨慎行事 访问私有数据或视图系统时。

**注意：**启用安全浏览功能后，这些网址仍会经历安全处理 浏览检查。如果不希望这样做，您可以使用 跳过对该主机的安全浏览检查，或者通过调用 来消除警告。`WebView#setSafeBrowsingWhitelist``onSafeBrowsingHit(WebView, WebResourceRequest, int, SafeBrowsingResponse)``SafeBrowsingResponse#proceed`

| 参数   |                                 |
| ------ | ------------------------------- |
| `view` | `WebView`：请求 资源。`WebView` |
| `url`  | `String`：资源的原始网址。      |

| 返回                  |                                                              |
| --------------------- | ------------------------------------------------------------ |
| `WebResourceResponse` | A 包含 响应信息或 Web 视图是否应加载 资源本身。`WebResourceResponse``null` |

### 应该覆盖键事件

[在 API 级别 1](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public boolean shouldOverrideKeyEvent (WebView view, 
                KeyEvent event)
```

为主机应用程序提供同步处理密钥事件的机会。 例如，菜单快捷键事件需要以这种方式过滤。如果返回 true，WebView 不会处理密钥事件。如果返回，则网络视图 将始终处理键事件，因此视图链中没有 super 将看到关键事件。默认行为返回 。`false``false`

| 参数    |                                  |
| ------- | -------------------------------- |
| `view`  | `WebView`：启动回调的 Web 视图。 |
| `event` | `KeyEvent`：关键事件。           |

| 返回      |                                                              |
| --------- | ------------------------------------------------------------ |
| `boolean` | `true`如果主机应用程序想要处理密钥事件 本身，否则返回`false` |

### 应该覆盖网址加载

[在 API 级别 24](/guide/topics/manifest/uses-sdk-element#ApiLevels) 中添加

```
public boolean shouldOverrideUrlLoading (WebView view, 
                WebResourceRequest request)
```

让主机应用程序有机会在 URL 即将加载到 当前网络视图。如果未提供 WebViewClient，则默认情况下，WebView 将询问 Activity 管理器，为 URL 选择适当的处理程序。如果提供了 WebViewClient，则返回会导致当前 Web 视图中止加载 URL，而返回会导致 Web 视图像往常一样继续加载 URL。`true``false`

**注意：**不要使用请求的 网址，然后返回 。这会不必要地取消当前负载并启动 具有相同 URL 的新加载。继续加载给定 URL 的正确方法是简单地 返回 ，无需调用 。`WebView#loadUrl(String)``true``false``WebView#loadUrl(String)`

**注意：**不会对 POST 请求调用此方法。

**注意：**此方法可以用于子帧和非 HTTP（S） 计划;使用此类 URL 调用将失败。`WebView#loadUrl(String)`

| 参数      |                                                |
| --------- | ---------------------------------------------- |
| `view`    | `WebView`：启动回调的 Web 视图。               |
| `request` | `WebResourceRequest`：包含请求详细信息的对象。 |

| 返回      |                                        |
| --------- | -------------------------------------- |
| `boolean` | `true`取消当前负载，否则返回 。`false` |

### 应该覆盖网址加载

在 API 级别 1 中添加 在 [API 级别](/guide/topics/manifest/uses-sdk-element#ApiLevels)中\
已弃用[ 24](/guide/topics/manifest/uses-sdk-element#ApiLevels)

```
public boolean shouldOverrideUrlLoading (WebView view, 
                String url)
```

**此方法已弃用 在 API 级别 24 中。**\
请改用。`shouldOverrideUrlLoading(WebView, WebResourceRequest)`

让主机应用程序有机会在 URL 即将加载到 当前网络视图。如果未提供 WebViewClient，则默认情况下，WebView 将询问 Activity 管理器，为 URL 选择适当的处理程序。如果提供了 WebViewClient，则返回会导致当前 Web 视图中止加载 URL，而返回会导致 Web 视图像往常一样继续加载 URL。`true``false`

**注意：**不要用相同的方式呼叫 网址，然后返回 。这会不必要地取消当前负载并启动 具有相同 URL 的新加载。继续加载给定 URL 的正确方法是简单地 返回 ，无需调用 。`WebView#loadUrl(String)``true``false``WebView#loadUrl(String)`

**注意：**不会对 POST 请求调用此方法。

**注意：**此方法可以用于子帧和非 HTTP（S） 计划;使用此类 URL 调用将失败。`WebView#loadUrl(String)`

| 参数   |                                  |
| ------ | -------------------------------- |
| `view` | `WebView`：启动回调的 Web 视图。 |
| `url`  | `String`：要加载的网址。         |

| 返回      |                                        |
| --------- | -------------------------------------- |
| `boolean` | `true`取消当前负载，否则返回 。`false` |

该内容对您有帮助吗？

