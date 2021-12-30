# 网页浏览客户端

[科特林](https://developer.android.com/reference/kotlin/android/webkit/WebViewClient) | 爪哇

`public class WebViewClient`
`extends [Object](https://developer.android.com/reference/java/lang/Object)`

| [对象](https://developer.android.com/reference/java/lang/Object) |
|    ↳ | android.webkit.WebViewClient |

---

## 概括

|
### 常数

 |
| --- |
| `int` | `[ERROR_AUTHENTICATION](https://developer.android.com/reference/android/webkit/WebViewClient#ERROR_AUTHENTICATION)`

服务器上的用户身份验证失败

 |
| `int` | `[ERROR_BAD_URL](https://developer.android.com/reference/android/webkit/WebViewClient#ERROR_BAD_URL)`

格式错误的网址

 |
| `int` | `[ERROR_CONNECT](https://developer.android.com/reference/android/webkit/WebViewClient#ERROR_CONNECT)`

无法连接到服务器

 |
| `int` | `[ERROR_FAILED_SSL_HANDSHAKE](https://developer.android.com/reference/android/webkit/WebViewClient#ERROR_FAILED_SSL_HANDSHAKE)`

未能执行 SSL 握手

 |
| `int` | `[ERROR_FILE](https://developer.android.com/reference/android/webkit/WebViewClient#ERROR_FILE)`

通用文件错误

 |
| `int` | `[ERROR_FILE_NOT_FOUND](https://developer.android.com/reference/android/webkit/WebViewClient#ERROR_FILE_NOT_FOUND)`

文件未找到

 |
| `int` | `[ERROR_HOST_LOOKUP](https://developer.android.com/reference/android/webkit/WebViewClient#ERROR_HOST_LOOKUP)`

服务器或代理主机名查找失败

 |
| `int` | `[ERROR_IO](https://developer.android.com/reference/android/webkit/WebViewClient#ERROR_IO)`

无法读取或写入服务器

 |
| `int` | `[ERROR_PROXY_AUTHENTICATION](https://developer.android.com/reference/android/webkit/WebViewClient#ERROR_PROXY_AUTHENTICATION)`

代理上的用户身份验证失败

 |
| `int` | `[ERROR_REDIRECT_LOOP](https://developer.android.com/reference/android/webkit/WebViewClient#ERROR_REDIRECT_LOOP)`

重定向过多

 |
| `int` | `[ERROR_TIMEOUT](https://developer.android.com/reference/android/webkit/WebViewClient#ERROR_TIMEOUT)`

连接超时

 |
| `int` | `[ERROR_TOO_MANY_REQUESTS](https://developer.android.com/reference/android/webkit/WebViewClient#ERROR_TOO_MANY_REQUESTS)`

在此加载期间请求过多

 |
| `int` | `[ERROR_UNKNOWN](https://developer.android.com/reference/android/webkit/WebViewClient#ERROR_UNKNOWN)`

一般错误

 |
| `int` | `[ERROR_UNSAFE_RESOURCE](https://developer.android.com/reference/android/webkit/WebViewClient#ERROR_UNSAFE_RESOURCE)`

安全浏览取消了资源加载

 |
| `int` | `[ERROR_UNSUPPORTED_AUTH_SCHEME](https://developer.android.com/reference/android/webkit/WebViewClient#ERROR_UNSUPPORTED_AUTH_SCHEME)`

不支持的身份验证方案（非基本或摘要）

 |
| `int` | `[ERROR_UNSUPPORTED_SCHEME](https://developer.android.com/reference/android/webkit/WebViewClient#ERROR_UNSUPPORTED_SCHEME)`

不支持的 URI 方案

 |
| `int` | `[SAFE_BROWSING_THREAT_BILLING](https://developer.android.com/reference/android/webkit/WebViewClient#SAFE_BROWSING_THREAT_BILLING)`

该资源已被阻止，因为它可能会诱使用户签订计费协议。

 |
| `int` | `[SAFE_BROWSING_THREAT_MALWARE](https://developer.android.com/reference/android/webkit/WebViewClient#SAFE_BROWSING_THREAT_MALWARE)`

资源被阻止，因为它包含恶意软件。

 |
| `int` | `[SAFE_BROWSING_THREAT_PHISHING](https://developer.android.com/reference/android/webkit/WebViewClient#SAFE_BROWSING_THREAT_PHISHING)`

该资源被阻止，因为它包含欺骗性内容。

 |
| `int` | `[SAFE_BROWSING_THREAT_UNKNOWN](https://developer.android.com/reference/android/webkit/WebViewClient#SAFE_BROWSING_THREAT_UNKNOWN)`

资源因未知原因被阻止。

 |
| `int` | `[SAFE_BROWSING_THREAT_UNWANTED_SOFTWARE](https://developer.android.com/reference/android/webkit/WebViewClient#SAFE_BROWSING_THREAT_UNWANTED_SOFTWARE)`

该资源被阻止，因为它包含不需要的软件。

 |

|
### 公共构造函数

 |
| --- |
| `[WebViewClient](https://developer.android.com/reference/android/webkit/WebViewClient#WebViewClient())()` |

|
### 公共方法

 |
| --- |
| `void` | `[doUpdateVisitedHistory](https://developer.android.com/reference/android/webkit/WebViewClient#doUpdateVisitedHistory(android.webkit.WebView,%20java.lang.String,%20boolean))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [String](https://developer.android.com/reference/java/lang/String) url, boolean isReload)`

通知主机应用程序更新其访问链接数据库。

 |
| `void` | `[onFormResubmission](https://developer.android.com/reference/android/webkit/WebViewClient#onFormResubmission(android.webkit.WebView,%20android.os.Message,%20android.os.Message))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [Message](https://developer.android.com/reference/android/os/Message) dontResend, [Message](https://developer.android.com/reference/android/os/Message) resend)`

作为主机应用程序，如果浏览器应该重新发送数据，因为请求的页面是 POST 的结果。

 |
| `void` | `[onLoadResource](https://developer.android.com/reference/android/webkit/WebViewClient#onLoadResource(android.webkit.WebView,%20java.lang.String))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [String](https://developer.android.com/reference/java/lang/String) url)`

通知宿主应用程序 WebView 将加载给定 url 指定的资源。

 |
| `void` | `[onPageCommitVisible](https://developer.android.com/reference/android/webkit/WebViewClient#onPageCommitVisible(android.webkit.WebView,%20java.lang.String))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [String](https://developer.android.com/reference/java/lang/String) url)`

通知宿主应用程序 `[WebView](https://developer.android.com/reference/android/webkit/WebView)` 不再绘制前一页导航留下的内容。

 |
| `void` | `[onPageFinished](https://developer.android.com/reference/android/webkit/WebViewClient#onPageFinished(android.webkit.WebView,%20java.lang.String))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [String](https://developer.android.com/reference/java/lang/String) url)`

通知宿主应用程序页面已完成加载。

 |
| `void` | `[onPageStarted](https://developer.android.com/reference/android/webkit/WebViewClient#onPageStarted(android.webkit.WebView,%20java.lang.String,%20android.graphics.Bitmap))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [String](https://developer.android.com/reference/java/lang/String) url, [Bitmap](https://developer.android.com/reference/android/graphics/Bitmap) favicon)`

通知宿主应用程序页面已开始加载。

 |
| `void` | `[onReceivedClientCertRequest](https://developer.android.com/reference/android/webkit/WebViewClient#onReceivedClientCertRequest(android.webkit.WebView,%20android.webkit.ClientCertRequest))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [ClientCertRequest](https://developer.android.com/reference/android/webkit/ClientCertRequest) request)`

通知主机应用程序处理 SSL 客户端证书请求。

 |
| `void` | `[onReceivedError](https://developer.android.com/reference/android/webkit/WebViewClient#onReceivedError(android.webkit.WebView,%20int,%20java.lang.String,%20java.lang.String))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, int errorCode, [String](https://developer.android.com/reference/java/lang/String) description, [String](https://developer.android.com/reference/java/lang/String) failingUrl)`

*此方法在 API 级别 23 中已弃用。请 `[onReceivedError(WebView, WebResourceRequest, WebResourceError)](https://developer.android.com/reference/android/webkit/WebViewClient#onReceivedError(android.webkit.WebView,%20android.webkit.WebResourceRequest,%20android.webkit.WebResourceError))` 改用。*

 |
| `void` | `[onReceivedError](https://developer.android.com/reference/android/webkit/WebViewClient#onReceivedError(android.webkit.WebView,%20android.webkit.WebResourceRequest,%20android.webkit.WebResourceError))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [WebResourceRequest](https://developer.android.com/reference/android/webkit/WebResourceRequest) request, [WebResourceError](https://developer.android.com/reference/android/webkit/WebResourceError) error)`

向宿主应用程序报告 Web 资源加载错误。

 |
| `void` | `[onReceivedHttpAuthRequest](https://developer.android.com/reference/android/webkit/WebViewClient#onReceivedHttpAuthRequest(android.webkit.WebView,%20android.webkit.HttpAuthHandler,%20java.lang.String,%20java.lang.String))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [HttpAuthHandler](https://developer.android.com/reference/android/webkit/HttpAuthHandler) handler, [String](https://developer.android.com/reference/java/lang/String) host, [String](https://developer.android.com/reference/java/lang/String) realm)`

通知主机应用程序 WebView 收到了 HTTP 身份验证请求。

 |
| `void` | `[onReceivedHttpError](https://developer.android.com/reference/android/webkit/WebViewClient#onReceivedHttpError(android.webkit.WebView,%20android.webkit.WebResourceRequest,%20android.webkit.WebResourceResponse))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [WebResourceRequest](https://developer.android.com/reference/android/webkit/WebResourceRequest) request, [WebResourceResponse](https://developer.android.com/reference/android/webkit/WebResourceResponse) errorResponse)`

通知宿主应用程序在加载资源时已从服务器接收到 HTTP 错误。

 |
| `void` | `[onReceivedLoginRequest](https://developer.android.com/reference/android/webkit/WebViewClient#onReceivedLoginRequest(android.webkit.WebView,%20java.lang.String,%20java.lang.String,%20java.lang.String))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [String](https://developer.android.com/reference/java/lang/String) realm, [String](https://developer.android.com/reference/java/lang/String) account, [String](https://developer.android.com/reference/java/lang/String) args)`

通知宿主应用程序已处理自动登录用户的请求。

 |
| `void` | `[onReceivedSslError](https://developer.android.com/reference/android/webkit/WebViewClient#onReceivedSslError(android.webkit.WebView,%20android.webkit.SslErrorHandler,%20android.net.http.SslError))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [SslErrorHandler](https://developer.android.com/reference/android/webkit/SslErrorHandler) handler, [SslError](https://developer.android.com/reference/android/net/http/SslError) error)`

通知宿主应用程序加载资源时发生 SSL 错误。

 |
| `boolean` | `[onRenderProcessGone](https://developer.android.com/reference/android/webkit/WebViewClient#onRenderProcessGone(android.webkit.WebView,%20android.webkit.RenderProcessGoneDetail))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [RenderProcessGoneDetail](https://developer.android.com/reference/android/webkit/RenderProcessGoneDetail) detail)`

通知主机应用程序给定的 WebView 的渲染进程已经退出。

 |
| `void` | `[onSafeBrowsingHit](https://developer.android.com/reference/android/webkit/WebViewClient#onSafeBrowsingHit(android.webkit.WebView,%20android.webkit.WebResourceRequest,%20int,%20android.webkit.SafeBrowsingResponse))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [WebResourceRequest](https://developer.android.com/reference/android/webkit/WebResourceRequest) request, int threatType, [SafeBrowsingResponse](https://developer.android.com/reference/android/webkit/SafeBrowsingResponse) callback)`

通知宿主应用程序加载 URL 已被安全浏览标记。

 |
| `void` | `[onScaleChanged](https://developer.android.com/reference/android/webkit/WebViewClient#onScaleChanged(android.webkit.WebView,%20float,%20float))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, float oldScale, float newScale)`

通知宿主应用程序应用于 WebView 的比例已更改。

 |
| `void` | `[onTooManyRedirects](https://developer.android.com/reference/android/webkit/WebViewClient#onTooManyRedirects(android.webkit.WebView,%20android.os.Message,%20android.os.Message))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [Message](https://developer.android.com/reference/android/os/Message) cancelMsg, [Message](https://developer.android.com/reference/android/os/Message) continueMsg)`

*此方法在 API 级别 15 中已弃用。不再调用此方法。 当 WebView 遇到重定向循环时，它会取消加载。*

 |
| `void` | `[onUnhandledKeyEvent](https://developer.android.com/reference/android/webkit/WebViewClient#onUnhandledKeyEvent(android.webkit.WebView,%20android.view.KeyEvent))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [KeyEvent](https://developer.android.com/reference/android/view/KeyEvent) event)`

通知主机应用程序 WebView 未处理密钥。

 |
| `[WebResourceResponse](https://developer.android.com/reference/android/webkit/WebResourceResponse)` | `[shouldInterceptRequest](https://developer.android.com/reference/android/webkit/WebViewClient#shouldInterceptRequest(android.webkit.WebView,%20android.webkit.WebResourceRequest))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [WebResourceRequest](https://developer.android.com/reference/android/webkit/WebResourceRequest) request)`

将资源请求通知主机应用程序并允许应用程序返回数据。

 |
| `[WebResourceResponse](https://developer.android.com/reference/android/webkit/WebResourceResponse)` | `[shouldInterceptRequest](https://developer.android.com/reference/android/webkit/WebViewClient#shouldInterceptRequest(android.webkit.WebView,%20java.lang.String))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [String](https://developer.android.com/reference/java/lang/String) url)`

*此方法在 API 级别 21 中已弃用。请 `[shouldInterceptRequest(WebView, WebResourceRequest)](https://developer.android.com/reference/android/webkit/WebViewClient#shouldInterceptRequest(android.webkit.WebView,%20android.webkit.WebResourceRequest))` 改用。*

 |
| `boolean` | `[shouldOverrideKeyEvent](https://developer.android.com/reference/android/webkit/WebViewClient#shouldOverrideKeyEvent(android.webkit.WebView,%20android.view.KeyEvent))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [KeyEvent](https://developer.android.com/reference/android/view/KeyEvent) event)`

让宿主应用程序有机会同步处理关键事件。

 |
| `boolean` | `[shouldOverrideUrlLoading](https://developer.android.com/reference/android/webkit/WebViewClient#shouldOverrideUrlLoading(android.webkit.WebView,%20android.webkit.WebResourceRequest))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [WebResourceRequest](https://developer.android.com/reference/android/webkit/WebResourceRequest) request)`

当 URL 即将加载到当前 WebView 中时，让宿主应用程序有机会进行控制。

 |
| `boolean` | `[shouldOverrideUrlLoading](https://developer.android.com/reference/android/webkit/WebViewClient#shouldOverrideUrlLoading(android.webkit.WebView,%20java.lang.String))([WebView](https://developer.android.com/reference/android/webkit/WebView) view, [String](https://developer.android.com/reference/java/lang/String) url)`

*此方法在 API 级别 24 中已弃用。请 `[shouldOverrideUrlLoading(WebView, WebResourceRequest)](https://developer.android.com/reference/android/webkit/WebViewClient#shouldOverrideUrlLoading(android.webkit.WebView,%20android.webkit.WebResourceRequest))` 改用。*

 |

|
### 继承的方法

 |
| --- |
| 从班级 `[java.lang.Object](https://developer.android.com/reference/java/lang/Object)`

| `[Object](https://developer.android.com/reference/java/lang/Object)` | `[clone](https://developer.android.com/reference/java/lang/Object#clone())()`

Creates and returns a copy of this object.

 |
| `boolean` | `[equals](https://developer.android.com/reference/java/lang/Object#equals(java.lang.Object))([Object](https://developer.android.com/reference/java/lang/Object) obj)`

Indicates whether some other object is "equal to" this one.

 |
| `void` | `[finalize](https://developer.android.com/reference/java/lang/Object#finalize())()`

Called by the garbage collector on an object when garbage collection determines that there are no more references to the object.

 |
| `final [Class](https://developer.android.com/reference/java/lang/Class)<?>` | `[getClass](https://developer.android.com/reference/java/lang/Object#getClass())()`

Returns the runtime class of this `Object`.

 |
| `int` | `[hashCode](https://developer.android.com/reference/java/lang/Object#hashCode())()`

Returns a hash code value for the object.

 |
| `final void` | `[notify](https://developer.android.com/reference/java/lang/Object#notify())()`

Wakes up a single thread that is waiting on this object's monitor.

 |
| `final void` | `[notifyAll](https://developer.android.com/reference/java/lang/Object#notifyAll())()`

Wakes up all threads that are waiting on this object's monitor.

 |
| `[String](https://developer.android.com/reference/java/lang/String)` | `[toString](https://developer.android.com/reference/java/lang/Object#toString())()`

Returns a string representation of the object.

 |
| `final void` | `[wait](https://developer.android.com/reference/java/lang/Object#wait(long,%20int))(long timeout, int nanos)`

Causes the current thread to wait until another thread invokes the `[notify()](https://developer.android.com/reference/java/lang/Object#notify())` method or the `[notifyAll()](https://developer.android.com/reference/java/lang/Object#notifyAll())` method for this object, or some other thread interrupts the current thread, or a certain amount of real time has elapsed.

 |
| `final void` | `[wait](https://developer.android.com/reference/java/lang/Object#wait(long))(long timeout)`

Causes the current thread to wait until either another thread invokes the `[notify()](https://developer.android.com/reference/java/lang/Object#notify())` method or the `[notifyAll()](https://developer.android.com/reference/java/lang/Object#notifyAll())` method for this object, or a specified amount of time has elapsed.

 |
| `final void` | `[wait](https://developer.android.com/reference/java/lang/Object#wait())()`

Causes the current thread to wait until another thread invokes the `[notify()](https://developer.android.com/reference/java/lang/Object#notify())` method or the `[notifyAll()](https://developer.android.com/reference/java/lang/Object#notifyAll())` method for this object.

 |

 |

## 常数

### 错误 \_  身份验证

在 [API 级别 5 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int ERROR\_AUTHENTICATION

服务器上的用户身份验证失败

常数值：-4 (0xffffffffc)

### 错误 \_   错误  \_  URL

在 [API 级别 5 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int ERROR\_BAD\_URL

格式错误的网址

常数值：-12 (0xfffffff4)

### ERROR\_CONNECT

在 [API 级别 5 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int ERROR\_CONNECT

无法连接到服务器

常数值：-6 (0xfffffffa)

### ERROR\_FAILED\_SSL\_HANDSHAKE

在 [API 级别 5 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int ERROR\_FAILED\_SSL\_HANDSHAKE

未能执行 SSL 握手

常数值：-11 (0xfffffff5)

### 错误文件

在 [API 级别 5 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int ERROR\_FILE

通用文件错误

常数值：-13 (0xfffffff3)

### ERROR\_FILE\_NOT\_FOUND

在 [API 级别 5 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int ERROR\_FILE\_NOT\_FOUND

文件未找到

常数值：-14 (0xfffffff2)

### ERROR\_HOST\_LOOKUP

在 [API 级别 5 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int ERROR\_HOST\_LOOKUP

服务器或代理主机名查找失败

常数值：-2 (0xffffffffe)

### ERROR\_IO

在 [API 级别 5 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int ERROR\_IO

无法读取或写入服务器

常数值：-7 (0xfffffff9)

### ERROR\_PROXY\_AUTHENTICATION

在 [API 级别 5 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int ERROR\_PROXY\_AUTHENTICATION

代理上的用户身份验证失败

常数值：-5 (0xffffffffb)

### 错误 \_   重定向  \_  循环

在 [API 级别 5 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int ERROR\_REDIRECT\_LOOP

重定向过多

常数值：-9 (0xfffffff7)

### 错误 \_  超时

在 [API 级别 5 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int ERROR\_TIMEOUT

连接超时

常数值：-8 (0xfffffff8)

### ERROR \_   TOO   \_   MANY   \_  REQUESTS

在 [API 级别 5 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int ERROR\_TOO\_MANY\_REQUESTS

在此加载期间请求过多

常数值：-15 (0xfffffff1)

### 错误 \_  未知

在 [API 级别 5 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int ERROR\_UNKNOWN

一般错误

常数值：-1 (0xffffffff)

### 错误 \_   不安全  \_  资源

在 [API 级别 26 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int ERROR\_UNSAFE\_RESOURCE

安全浏览取消了资源加载

常数值：-16 (0xffffffff0)

### 错误 \_   不支持  \_   授权  \_  方案

在 [API 级别 5 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int ERROR\_UNSUPPORTED\_AUTH\_SCHEME

不支持的身份验证方案（非基本或摘要）

常数值：-3 (0xffffffffd)

### 错误 \_   不支持  \_  方案

在 [API 级别 5 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int ERROR\_UNSUPPORTED\_SCHEME

不支持的 URI 方案

常数值：-10 (0xfffffff6)

### 安全 \_   浏览  \_   威胁  \_  计费

在 [API 级别 29 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int SAFE\_BROWSING\_THREAT\_BILLING

该资源已被阻止，因为它可能会诱使用户签订计费协议。

此常量仅在 targetSdkVersion 至少为 时使用 `[Build.VERSION_CODES.Q](https://developer.android.com/reference/android/os/Build.VERSION_CODES#Q)` 。 否则， `[SAFE_BROWSING_THREAT_UNKNOWN](https://developer.android.com/reference/android/webkit/WebViewClient#SAFE_BROWSING_THREAT_UNKNOWN)` 将改为使用。

常数值：4 (0x00000004)

### 安全 \_   浏览  \_   威胁  \_  恶意软件

在 [API 级别 27 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int SAFE\_BROWSING\_THREAT\_MALWARE

资源被阻止，因为它包含恶意软件。

常数值：1（0x00000001）

### 安全 \_   浏览  \_   威胁  \_网络  钓鱼

在 [API 级别 27 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int SAFE\_BROWSING\_THREAT\_PHISHING

该资源被阻止，因为它包含欺骗性内容。

常数值：2 (0x00000002)

### 安全 \_   浏览  \_   威胁  \_  未知

在 [API 级别 27 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int SAFE\_BROWSING\_THREAT\_UNKNOWN

资源因未知原因被阻止。

常数值：0（0x00000000）

### 安全 \_   浏览  \_   威胁  \_   不需要的  \_  软件

在 [API 级别 27 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public static final int SAFE\_BROWSING\_THREAT\_UNWANTED\_SOFTWARE

该资源被阻止，因为它包含不需要的软件。

常数值：3 (0x00000003)

## 公共构造函数

### 网页浏览客户端

public WebViewClient ()

## 公共方法

### doUpdateVisitedHistory

在 [API 级别 1 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public void doUpdateVisitedHistory ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [String](https://developer.android.com/reference/java/lang/String) url,
                boolean isReload)

通知主机应用程序更新其访问链接数据库。

| 参数 |
| --- |
| `view` | `WebView` : 发起回调的 WebView。
 |
| `url` | `String` : 正在访问的网址。

 |
| `isReload` | `boolean` : `true` 如果这个 url 正在被重新加载。

 |

### 表单重新提交

在 [API 级别 1 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public void onFormResubmission ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [Message](https://developer.android.com/reference/android/os/Message) dontResend,
                [Message](https://developer.android.com/reference/android/os/Message) resend)

作为主机应用程序，如果浏览器应该重新发送数据，因为请求的页面是 POST 的结果。 默认是不重新发送数据。

| 参数 |
| --- |
| `view` | `WebView` : 发起回调的 WebView。
 |
| `dontResend` | `Message` : 浏览器不应重新发送时发送的消息

 |
| `resend` | `Message` : 如果浏览器应该重新发送数据要发送的消息

 |

### 加载资源

在 [API 级别 1 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public void onLoadResource ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [String](https://developer.android.com/reference/java/lang/String) url)

通知宿主应用程序 WebView 将加载给定 url 指定的资源。

| 参数 |
| --- |
| `view` | `WebView` : 发起回调的 WebView。
 |
| `url` | `String` ：WebView 将加载的资源的 url。

 |

### onPageCommitVisible

在 [API 级别 23 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public void onPageCommitVisible ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [String](https://developer.android.com/reference/java/lang/String) url)

通知宿主应用程序 `[WebView](https://developer.android.com/reference/android/webkit/WebView)` 不再绘制前一页导航留下的内容。

此回调可用于确定使回收 `[WebView](https://developer.android.com/reference/android/webkit/WebView)` 可见的 安全点 ，确保不显示陈旧的内容。 在可以保证 `[WebView#onDraw](https://developer.android.com/reference/android/webkit/WebView#onDraw(android.graphics.Canvas))` 不再从以前的导航中绘制任何内容 的最早点调用它 。 接下来的抽签将显示任一 `[background color](https://developer.android.com/reference/android/webkit/WebView#setBackgroundColor(int))` 的 `[WebView](https://developer.android.com/reference/android/webkit/WebView)` ，或者一些新加载页面的内容。

当 HTTP 响应的主体开始加载时调用此方法，反映在 DOM 中，并将在后续绘制中可见。 此回调发生在文档加载过程的早期，因此您应该预期链接的资源（例如，CSS 和图像）可能不可用。

有关视觉状态更新的更细粒度的通知，请参阅 `[WebView.postVisualStateCallback(long, WebView.VisualStateCallback)](https://developer.android.com/reference/android/webkit/WebView#postVisualStateCallback(long,%20android.webkit.WebView.VisualStateCallback))` 。

请注意，所有适用的条件和建议 `[WebView#postVisualStateCallback](https://developer.android.com/reference/android/webkit/WebView#postVisualStateCallback(long,%20android.webkit.WebView.VisualStateCallback))` 也适用于此 API。

此回调仅在主框架导航时调用。

| 参数 |
| --- |
| `view` | `WebView` ： `[WebView](https://developer.android.com/reference/android/webkit/WebView)` 发生导航的 。
 |
| `url` | `String` : 触发本次回调的页面导航对应的URL。

 |

### 已完成

在 [API 级别 1 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public void onPageFinished ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [String](https://developer.android.com/reference/java/lang/String) url)

通知宿主应用程序页面已完成加载。 此方法仅在主框架中调用。 接收 `onPageFinished()` 回调并不能保证 WebView 绘制的下一帧会反映此时 DOM 的状态。 为了收到当前 DOM 状态已准备好呈现的通知，请求视觉状态回调 `[WebView#postVisualStateCallback](https://developer.android.com/reference/android/webkit/WebView#postVisualStateCallback(long,%20android.webkit.WebView.VisualStateCallback))` 并等待提供的回调被触发。

| 参数 |
| --- |
| `view` | `WebView` : 发起回调的 WebView。
 |
| `url` | `String` : 页面的网址。

 |

### 页面启动

在 [API 级别 1 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public void onPageStarted ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [String](https://developer.android.com/reference/java/lang/String) url,
                [Bitmap](https://developer.android.com/reference/android/graphics/Bitmap) favicon)

通知宿主应用程序页面已开始加载。 每次加载主框架都会调用一次此方法，因此具有 iframe 或框架集的页面将为主框架调用 onPageStarted 一次。 这也意味着当嵌入框架的内容更改时，不会调用 onPageStarted，即单击目标是 iframe 的链接，它也不会被调用以进行片段导航（导航到#fragment\_id）。

| 参数 |
| --- |
| `view` | `WebView` : 发起回调的 WebView。
 |
| `url` | `String` : 要加载的网址。

 |
| `favicon` | `Bitmap` ：如果此页面已存在于数据库中，则为该页面的图标。

 |

### onReceivedClientCertRequest

在 [API 级别 21 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public void onReceivedClientCertRequest ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [ClientCertRequest](https://developer.android.com/reference/android/webkit/ClientCertRequest) request)

通知主机应用程序处理 SSL 客户端证书请求。 如果需要，主机应用程序负责显示 UI 并提供密钥。 共有三种响应方式： `[ClientCertRequest#proceed](https://developer.android.com/reference/android/webkit/ClientCertRequest#proceed(java.security.PrivateKey,%20java.security.cert.X509Certificate[]))` 、 `[ClientCertRequest#cancel](https://developer.android.com/reference/android/webkit/ClientCertRequest#cancel())` 、 或 `[ClientCertRequest.ignore()](https://developer.android.com/reference/android/webkit/ClientCertRequest#ignore())` 。 Webview 将响应存储在内存中（在应用程序的生命周期内），如果 `[ClientCertRequest#proceed](https://developer.android.com/reference/android/webkit/ClientCertRequest#proceed(java.security.PrivateKey,%20java.security.cert.X509Certificate[]))` 或 `[ClientCertRequest#cancel](https://developer.android.com/reference/android/webkit/ClientCertRequest#cancel())` 被调用并且不再 `onReceivedClientCertRequest()` 为相同的主机和端口对 调用 。 如果 `[ClientCertRequest#ignore](https://developer.android.com/reference/android/webkit/ClientCertRequest#ignore())` 被调用， Webview 不会存储响应 。 请注意，chromium 网络堆栈中的多个层可能会缓存响应，因此忽略行为只是最好的情况。 此方法在 UI 线程上调用。 在回调期间，连接被挂起。 对于大多数用例，应用程序应该实现 `[KeyChainAliasCallback](https://developer.android.com/reference/android/security/KeyChainAliasCallback)` 接口并将其传递给 `[KeyChain.choosePrivateKeyAlias(Activity, KeyChainAliasCallback, String[], Principal[], Uri, String)](https://developer.android.com/reference/android/security/KeyChain#choosePrivateKeyAlias(android.app.Activity,%20android.security.KeyChainAliasCallback,%20java.lang.String[],%20java.security.Principal[],%20android.net.Uri,%20java.lang.String))` 启动一个活动，让用户选择合适的别名。 钥匙串活动将通过已实现接口中的回调方法提供别名。 接下来，应用程序应该创建一个异步任务来调用 `[KeyChain.getPrivateKey(Context, String)](https://developer.android.com/reference/android/security/KeyChain#getPrivateKey(android.content.Context,%20java.lang.String))` 以接收密钥。 可以在 [AOSP 浏览器中](https://android.googlesource.com/platform/packages/apps/Browser/+/android-5.1.1_r1/src/com/android/browser/Tab.java) 看到客户端证书的示例实现 默认行为是取消，不返回客户端证书。

| 参数 |
| --- |
| `view` | `WebView` : 发起回调的 WebView
 |
| `request` | `ClientCertRequest` : 一个实例 `[ClientCertRequest](https://developer.android.com/reference/android/webkit/ClientCertRequest)`

 |

### 接收错误

在 [API 级别 1 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加
已在 [API 级别 23 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 弃用[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public void onReceivedError ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                int errorCode,
                [String](https://developer.android.com/reference/java/lang/String) description,
                [String](https://developer.android.com/reference/java/lang/String) failingUrl)

**此方法在 API 级别 23 中已弃用。**
请 `[onReceivedError(WebView, WebResourceRequest, WebResourceError)](https://developer.android.com/reference/android/webkit/WebViewClient#onReceivedError(android.webkit.WebView,%20android.webkit.WebResourceRequest,%20android.webkit.WebResourceError))` 改用。

向宿主应用程序报告错误。 这些错误是不可恢复的（即主要资源不可用）。 该 `errorCode` 参数对应于 `ERROR_*` 常量之一。

| 参数 |
| --- |
| `view` | `WebView` : 发起回调的 WebView。
 |
| `errorCode` | `int` : 对应于 ERROR\_\* 值的错误代码。

 |
| `description` | `String` : 描述错误的字符串。

 |
| `failingUrl` | `String` : 加载失败的网址。

 |

### 接收错误

在 [API 级别 23 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public void onReceivedError ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [WebResourceRequest](https://developer.android.com/reference/android/webkit/WebResourceRequest) request,
                [WebResourceError](https://developer.android.com/reference/android/webkit/WebResourceError) error)

向宿主应用程序报告 Web 资源加载错误。 这些错误通常表示无法连接到服务器。 请注意，与已弃用的回调版本不同，新版本将针对任何资源（iframe、图像等）调用，而不仅仅是针对主页。 因此，建议在此回调中执行最低要求的工作。

| 参数 |
| --- |
| `view` | `WebView` : 发起回调的 WebView。
 |
| `request` | `WebResourceRequest` : 发起请求。

 |
| `error` | `WebResourceError` : 关于发生错误的信息。

 |

### onReceivedHttpAuthRequest

在 [API 级别 1 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public void onReceivedHttpAuthRequest ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [HttpAuthHandler](https://developer.android.com/reference/android/webkit/HttpAuthHandler) handler,
                [String](https://developer.android.com/reference/java/lang/String) host,
                [String](https://developer.android.com/reference/java/lang/String) realm)

通知主机应用程序 WebView 收到了 HTTP 身份验证请求。 宿主应用程序可以使用提供的 `[HttpAuthHandler](https://developer.android.com/reference/android/webkit/HttpAuthHandler)` 来设置 WebView 对请求的响应。 默认行为是取消请求。

| 参数 |
| --- |
| `view` | `WebView` : 发起回调的 WebView
 |
| `handler` | `HttpAuthHandler` : 用于设置 WebView 响应的 HttpAuthHandler

 |
| `host` | `String` : 需要认证的主机

 |
| `realm` | `String` ：需要身份验证的领域

 |

**也可以看看：**

*   `[WebView.getHttpAuthUsernamePassword(String, String)](https://developer.android.com/reference/android/webkit/WebView#getHttpAuthUsernamePassword(java.lang.String,%20java.lang.String))`

### onReceivedHttpError

在 [API 级别 23 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public void onReceivedHttpError ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [WebResourceRequest](https://developer.android.com/reference/android/webkit/WebResourceRequest) request,
                [WebResourceResponse](https://developer.android.com/reference/android/webkit/WebResourceResponse) errorResponse)

通知宿主应用程序在加载资源时已从服务器接收到 HTTP 错误。 HTTP 错误的状态代码 >= 400。此回调将针对任何资源（iframe、图像等）调用，而不仅仅是针对主页。 因此，建议在此回调中执行最低要求的工作。 请注意， `errorResponse` 参数中 可能未提供服务器响应的内容 。

| 参数 |
| --- |
| `view` | `WebView` : 发起回调的 WebView。
 |
| `request` | `WebResourceRequest` : 发起请求。

 |
| `errorResponse` | `WebResourceResponse` : 关于发生错误的信息。

 |

### 接收到的登录请求

在 [API 级别 12 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public void onReceivedLoginRequest ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [String](https://developer.android.com/reference/java/lang/String) realm,
                [String](https://developer.android.com/reference/java/lang/String) account,
                [String](https://developer.android.com/reference/java/lang/String) args)

通知宿主应用程序已处理自动登录用户的请求。

| 参数 |
| --- |
| `view` | `WebView` ：请求登录的WebView。
 |
| `realm` | `String` ：用于查找帐户的帐户领域。

 |
| `account` | `String` : 一个可选的帐户。 如果不是 `null` ，则应根据设备上的帐户检查该帐户。 如果它是有效帐户，则应用于登录用户。 这个值可能是 `null` 。

 |
| `args` | `String` ：用于登录用户的身份验证器特定参数。

 |

### onReceivedSslError

在 [API 级别 8 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public void onReceivedSslError ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [SslErrorHandler](https://developer.android.com/reference/android/webkit/SslErrorHandler) handler,
                [SslError](https://developer.android.com/reference/android/net/http/SslError) error)

通知宿主应用程序加载资源时发生 SSL 错误。 宿主应用程序必须调用 `[SslErrorHandler#cancel](https://developer.android.com/reference/android/webkit/SslErrorHandler#cancel())` 或 `[SslErrorHandler#proceed](https://developer.android.com/reference/android/webkit/SslErrorHandler#proceed())` 。 请注意，该决定可能会保留以用于响应未来的 SSL 错误。 默认行为是取消加载。

此 API 仅在可恢复的 SSL 证书错误时调用。 在不可恢复的错误的情况下（例如当服务器使客户端失败时），WebView 将 `[onReceivedError(android.webkit.WebView, android.webkit.WebResourceRequest, android.webkit.WebResourceError)](https://developer.android.com/reference/android/webkit/WebViewClient#onReceivedError(android.webkit.WebView,%20android.webkit.WebResourceRequest,%20android.webkit.WebResourceError))` 使用 `[ERROR_FAILED_SSL_HANDSHAKE](https://developer.android.com/reference/android/webkit/WebViewClient#ERROR_FAILED_SSL_HANDSHAKE)` .

建议应用程序不要向用户提示 SSL 错误，因为用户不太可能做出明智的安全决定，而且 WebView 不提供任何 UI 以有意义的方式显示错误的详细信息。

此方法的应用程序覆盖可能会显示自定义错误页面或静默记录问题，但强烈建议始终调用 `[SslErrorHandler#cancel](https://developer.android.com/reference/android/webkit/SslErrorHandler#cancel())` 并且永远不允许继续处理过去的错误。

| 参数 |
| --- |
| `view` | `WebView` : 发起回调的 WebView。
 |
| `handler` | `SslErrorHandler` : `[SslErrorHandler](https://developer.android.com/reference/android/webkit/SslErrorHandler)` 将处理用户的响应。

 |
| `error` | `SslError` ：SSL 错误对象。

 |

### onRenderProcessGone

在 [API 级别 26 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public boolean onRenderProcessGone ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [RenderProcessGoneDetail](https://developer.android.com/reference/android/webkit/RenderProcessGoneDetail) detail)

通知主机应用程序给定的 WebView 的渲染进程已经退出。 多个 WebView 实例可能与单个渲染进程相关联； 将为每个受影响的 WebView 调用 onRenderProcessGone。 应用程序对这个回调的实现应该只尝试清理作为参数给出的特定 WebView，而不应该假设其他 WebView 实例受到影响。 给定的 WebView 不能使用，应该从视图层次结构中删除，所有对它的引用都应该被清除，例如 Activity 中的任何引用或使用 `[View.findViewById(int)](https://developer.android.com/reference/android/view/View#findViewById(int))` 类似调用 保存的其他类 等。 导致渲染进程崩溃出于测试目的，应用程序可以调用 `loadUrl("chrome://crash")` 在 WebView 上。 请注意，如果多个 WebView 实例共享一个渲染进程，则可能会受到影响，而不仅仅是加载 chrome://crash 的特定 WebView。

| 参数 |
| --- |
| `view` | `WebView` ：需要清理的WebView。
 |
| `detail` | `RenderProcessGoneDetail` : 退出的原因。

 |

| 退货 |
| --- |
| `boolean` | `true` 如果宿主应用程序处理了进程已退出的情况，否则，如果渲染进程崩溃，应用程序将崩溃，如果渲染进程被系统杀死，则应用程序将被杀死。
 |

### 安全浏览命中

在 [API 级别 27 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public void onSafeBrowsingHit ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [WebResourceRequest](https://developer.android.com/reference/android/webkit/WebResourceRequest) request,
                int threatType,
                [SafeBrowsingResponse](https://developer.android.com/reference/android/webkit/SafeBrowsingResponse) callback)

通知宿主应用程序加载 URL 已被安全浏览标记。 应用程序必须调用回调来指示首选响应。 默认行为是向用户显示插页式广告，报告复选框可见。 如果应用程序需要显示自己的自定义插页式 UI，则可以使用 `[SafeBrowsingResponse#backToSafety](https://developer.android.com/reference/android/webkit/SafeBrowsingResponse#backToSafety(boolean))` 或 异步调用回调 `[SafeBrowsingResponse.proceed(boolean)](https://developer.android.com/reference/android/webkit/SafeBrowsingResponse#proceed(boolean))` ，具体取决于用户响应。

| 参数 |
| --- |
| `view` | `WebView` ：命中恶意资源的 WebView。
 |
| `request` | `WebResourceRequest` ：包含请求详细信息的对象。

 |
| `threatType` | `int` ：资源被安全浏览捕获的原因，对应一个 值。 值为 , , , , 或 `SAFE_BROWSING_THREAT_*` `[SAFE_BROWSING_THREAT_UNKNOWN](https://developer.android.com/reference/android/webkit/WebViewClient#SAFE_BROWSING_THREAT_UNKNOWN)` `[SAFE_BROWSING_THREAT_MALWARE](https://developer.android.com/reference/android/webkit/WebViewClient#SAFE_BROWSING_THREAT_MALWARE)` `[SAFE_BROWSING_THREAT_PHISHING](https://developer.android.com/reference/android/webkit/WebViewClient#SAFE_BROWSING_THREAT_PHISHING)` `[SAFE_BROWSING_THREAT_UNWANTED_SOFTWARE](https://developer.android.com/reference/android/webkit/WebViewClient#SAFE_BROWSING_THREAT_UNWANTED_SOFTWARE)` `[SAFE_BROWSING_THREAT_BILLING](https://developer.android.com/reference/android/webkit/WebViewClient#SAFE_BROWSING_THREAT_BILLING)`

 |
| `callback` | `SafeBrowsingResponse` ：应用程序必须调用回调方法之一。

 |

### 按比例更改

在 [API 级别 1 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public void onScaleChanged ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                float oldScale,
                float newScale)

通知宿主应用程序应用于 WebView 的比例已更改。

| 参数 |
| --- |
| `view` | `WebView` : 发起回调的 WebView。
 |
| `oldScale` | `float` : 旧的比例因子

 |
| `newScale` | `float` : 新的比例因子

 |

### 太多重定向

在 [API 级别 1 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加
已在 [API 级别 15 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 弃用[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public void onTooManyRedirects ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [Message](https://developer.android.com/reference/android/os/Message) cancelMsg,
                [Message](https://developer.android.com/reference/android/os/Message) continueMsg)

**此方法在 API 级别 15 中已弃用**
。不再调用此方法。 当 WebView 遇到重定向循环时，它会取消加载。

通知主机应用程序 HTTP 重定向次数过多。 作为主机应用程序，如果它想继续尝试加载资源。 默认行为是发送取消消息。

| 参数 |
| --- |
| `view` | `WebView` : 发起回调的 WebView。
 |
| `cancelMsg` | `Message` : 主机要取消时发送的消息

 |
| `continueMsg` | `Message` : 主机要继续时发送的消息

 |

### onUnhandledKeyEvent

在 [API 级别 1 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加
已在 [API 级别 21 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 弃用[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public void onUnhandledKeyEvent ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [KeyEvent](https://developer.android.com/reference/android/view/KeyEvent) event)

通知主机应用程序 WebView 未处理密钥。 除了系统键之外，WebView 总是在正常流程中使用键或者如果 `[shouldOverrideKeyEvent(WebView, KeyEvent)](https://developer.android.com/reference/android/webkit/WebViewClient#shouldOverrideKeyEvent(android.webkit.WebView,%20android.view.KeyEvent))` 返回 `true` 。 这是从分发密钥的地方异步调用的。 它使宿主应用程序有机会处理未处理的关键事件。

| 参数 |
| --- |
| `view` | `WebView` : 发起回调的 WebView。
 |
| `event` | `KeyEvent` : 关键事件。

 |

### 应该拦截请求

在 [API 级别 21 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public [WebResourceResponse](https://developer.android.com/reference/android/webkit/WebResourceResponse) shouldInterceptRequest ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [WebResourceRequest](https://developer.android.com/reference/android/webkit/WebResourceRequest) request)

将资源请求通知主机应用程序并允许应用程序返回数据。 如果返回值为 `null` ，WebView 将继续像往常一样加载资源。 否则，将使用返回响应和数据。

此回调被调用各种URL方案（例如 `http(s):` ， `data:` ， `file:` 等），不仅其在网络上发送请求的方案。 这不叫的 `javascript:` 网址， `blob:` 网址，或通过访问资产 `file:///android_asset/` 或 `file:///android_res/` 网址。

在重定向的情况下，这仅针对初始资源 URL 调用，而不针对任何后续重定向 URL。

**注意：** 此方法是在 UI 线程以外的线程上调用的，因此客户端在访问私有数据或视图系统时应谨慎行事。

**注意：** 启用安全浏览后，这些 URL 仍会接受安全浏览检查。 如果这是不希望的，您可以使用 `[WebView#setSafeBrowsingWhitelist](https://developer.android.com/reference/android/webkit/WebView#setSafeBrowsingWhitelist(java.util.List%3Cjava.lang.String%3E,%20android.webkit.ValueCallback%3Cjava.lang.Boolean%3E))` 跳过对该主机的安全浏览检查或 `[onSafeBrowsingHit(WebView, WebResourceRequest, int, SafeBrowsingResponse)](https://developer.android.com/reference/android/webkit/WebViewClient#onSafeBrowsingHit(android.webkit.WebView,%20android.webkit.WebResourceRequest,%20int,%20android.webkit.SafeBrowsingResponse))` 通过调用 `[SafeBrowsingResponse#proceed](https://developer.android.com/reference/android/webkit/SafeBrowsingResponse#proceed(boolean))` .

| 参数 |
| --- |
| `view` | `WebView` : `[WebView](https://developer.android.com/reference/android/webkit/WebView)` 就是请求资源。
 |
| `request` | `WebResourceRequest` ：包含请求详细信息的对象。

 |

| 退货 |
| --- |
| `[WebResourceResponse](https://developer.android.com/reference/android/webkit/WebResourceResponse)` | 甲 `[WebResourceResponse](https://developer.android.com/reference/android/webkit/WebResourceResponse)` 包含响应信息或 `null` 如果web视图应该加载资源本身。
 |

### 应该拦截请求

在 [API 级别 11 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加
已在 [API 级别 21 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 弃用[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public [WebResourceResponse](https://developer.android.com/reference/android/webkit/WebResourceResponse) shouldInterceptRequest ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [String](https://developer.android.com/reference/java/lang/String) url)

**此方法在 API 级别 21 中已弃用。**
请 `[shouldInterceptRequest(WebView, WebResourceRequest)](https://developer.android.com/reference/android/webkit/WebViewClient#shouldInterceptRequest(android.webkit.WebView,%20android.webkit.WebResourceRequest))` 改用。

将资源请求通知主机应用程序并允许应用程序返回数据。 如果返回值为 `null` ，WebView 将继续像往常一样加载资源。 否则，将使用返回响应和数据。

此回调被调用各种URL方案（例如 `http(s):` ， `data:` ， `file:` 等），不仅其在网络上发送请求的方案。 这不叫的 `javascript:` 网址， `blob:` 网址，或通过访问资产 `file:///android_asset/` 或 `file:///android_res/` 网址。

在重定向的情况下，这仅针对初始资源 URL 调用，而不针对任何后续重定向 URL。

**注意：** 此方法是在 UI 线程以外的线程上调用的，因此客户端在访问私有数据或视图系统时应谨慎行事。

**注意：** 启用安全浏览后，这些 URL 仍会接受安全浏览检查。 如果这是不希望的，您可以使用 `[WebView#setSafeBrowsingWhitelist](https://developer.android.com/reference/android/webkit/WebView#setSafeBrowsingWhitelist(java.util.List%3Cjava.lang.String%3E,%20android.webkit.ValueCallback%3Cjava.lang.Boolean%3E))` 跳过对该主机的安全浏览检查或 `[onSafeBrowsingHit(WebView, WebResourceRequest, int, SafeBrowsingResponse)](https://developer.android.com/reference/android/webkit/WebViewClient#onSafeBrowsingHit(android.webkit.WebView,%20android.webkit.WebResourceRequest,%20int,%20android.webkit.SafeBrowsingResponse))` 通过调用 `[SafeBrowsingResponse#proceed](https://developer.android.com/reference/android/webkit/SafeBrowsingResponse#proceed(boolean))` .

| 参数 |
| --- |
| `view` | `WebView` : `[WebView](https://developer.android.com/reference/android/webkit/WebView)` 就是请求资源。
 |
| `url` | `String` ：资源的原始网址。

 |

| 退货 |
| --- |
| `[WebResourceResponse](https://developer.android.com/reference/android/webkit/WebResourceResponse)` | 甲 `[WebResourceResponse](https://developer.android.com/reference/android/webkit/WebResourceResponse)` 包含响应信息或 `null` 如果web视图应该加载资源本身。
 |

### shouldOverrideKeyEvent

在 [API 级别 1 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public boolean shouldOverrideKeyEvent ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [KeyEvent](https://developer.android.com/reference/android/view/KeyEvent) event)

让宿主应用程序有机会同步处理关键事件。 例如，菜单快捷键事件需要通过这种方式进行过滤。 如果返回 true，WebView 将不会处理按键事件。 如果 return `false` ，WebView 将始终处理 key 事件，因此视图链中的所有 super 都不会看到 key 事件。 默认行为返回 `false` .

| 参数 |
| --- |
| `view` | `WebView` : 发起回调的 WebView。
 |
| `event` | `KeyEvent` : 关键事件。

 |

| 退货 |
| --- |
| `boolean` | `true` 如果宿主应用程序想要自己处理按键事件，否则返回 `false`
 |

### shouldOverrideUrlLoading

在 [API 级别 24 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public boolean shouldOverrideUrlLoading ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [WebResourceRequest](https://developer.android.com/reference/android/webkit/WebResourceRequest) request)

当 URL 即将加载到当前 WebView 中时，让宿主应用程序有机会进行控制。 如果未提供 WebViewClient，默认情况下 WebView 将要求活动管理器为 URL 选择合适的处理程序。 如果提供了 WebViewClient，则返回 `true` 会导致当前 WebView 中止加载 URL，而返回 `false` 会导致 WebView 像往常一样继续加载 URL。

**注意：** 不要 `[WebView#loadUrl(String)](https://developer.android.com/reference/android/webkit/WebView#loadUrl(java.lang.String))` 使用请求的 URL 调用 然后返回 `true` . 这会不必要地取消当前加载并使用相同的 URL 启动新加载。 继续加载给定 URL 的正确方法是简单地 return `false` ，而不调用 `[WebView#loadUrl(String)](https://developer.android.com/reference/android/webkit/WebView#loadUrl(java.lang.String))` .

**注意：** POST 请求不会调用此方法。

**注意：** 此方法可能会被子帧和非 HTTP(S) 方案调用； `[WebView#loadUrl(String)](https://developer.android.com/reference/android/webkit/WebView#loadUrl(java.lang.String))` 使用这样的 URL 调用 将失败。

| 参数 |
| --- |
| `view` | `WebView` : 发起回调的 WebView。
 |
| `request` | `WebResourceRequest` ：包含请求详细信息的对象。

 |

| 退货 |
| --- |
| `boolean` | `true` 取消当前加载，否则返回 `false` 。
 |

### shouldOverrideUrlLoading

在 [API 级别 1 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加
已在 [API 级别 24 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 弃用[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public boolean shouldOverrideUrlLoading ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [String](https://developer.android.com/reference/java/lang/String) url)

**此方法在 API 级别 24 中已弃用。**
请 `[shouldOverrideUrlLoading(WebView, WebResourceRequest)](https://developer.android.com/reference/android/webkit/WebViewClient#shouldOverrideUrlLoading(android.webkit.WebView,%20android.webkit.WebResourceRequest))` 改用。

当 URL 即将加载到当前 WebView 中时，让宿主应用程序有机会进行控制。 如果未提供 WebViewClient，默认情况下 WebView 将要求活动管理器为 URL 选择合适的处理程序。 如果提供了 WebViewClient，则返回 `true` 会导致当前 WebView 中止加载 URL，而返回 `false` 会导致 WebView 像往常一样继续加载 URL。

**注意：** 不要 `[WebView#loadUrl(String)](https://developer.android.com/reference/android/webkit/WebView#loadUrl(java.lang.String))` 使用相同的 URL 调用 然后返回 `true` 。 这会不必要地取消当前加载并使用相同的 URL 启动新加载。 继续加载给定 URL 的正确方法是简单地 return `false` ，而不调用 `[WebView#loadUrl(String)](https://developer.android.com/reference/android/webkit/WebView#loadUrl(java.lang.String))` .

**注意：** POST 请求不会调用此方法。

**注意：** 此方法可能会被子帧和非 HTTP(S) 方案调用； `[WebView#loadUrl(String)](https://developer.android.com/reference/android/webkit/WebView#loadUrl(java.lang.String))` 使用这样的 URL 调用 将失败。

| 参数 |
| --- |
| `view` | `WebView` : 发起回调的 WebView。
 |
| `url` | `String` : 要加载的 URL。|

| 退货 |
| --- |
| `boolean` | `true` 取消当前加载，否则返回 `false` 。|

该内容对您有帮助吗？