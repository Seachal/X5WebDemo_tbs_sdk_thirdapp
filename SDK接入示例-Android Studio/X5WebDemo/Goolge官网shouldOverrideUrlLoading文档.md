## shouldOverrideUrlLoading

在 [API 级别 24 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)


public boolean shouldOverrideUrlLoading ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [WebResourceRequest](https://developer.android.com/reference/android/webkit/WebResourceRequest) request)
                


当 URL 即将加载到当前 WebView 中时，让宿主应用程序有机会进行控制。 如果未提供 WebViewClient，默认情况下 WebView 将要求活动管理器为 URL 选择合适的处理程序。 如果提供了 WebViewClient，则返回 `true` 会导致当前 WebView 中止加载 URL，而返回 `false` 会导致 WebView 像往常一样继续加载 URL。

**注意：** 不要使用请求的 URL 调用[WebView#loadUrl(String)](https://developer.android.com/reference/android/webkit/WebView#loadUrl(java.lang.String)) 然后返回 `true` . 这会不必要地取消当前加载并使用相同的 URL 启动新加载。 继续加载给定 URL 的正确方法是简单地 return `false` ，而不调用 [WebView#loadUrl(String)](https://developer.android.com/reference/android/webkit/WebView#loadUrl(java.lang.String)) .

**注意：** POST 请求不会调用此方法。

**注意：** 此方法可能会被subframes和非 HTTP(S) 方案调用； [WebView#loadUrl(String)](https://developer.android.com/reference/android/webkit/WebView#loadUrl(java.lang.String))使用这样的 URL 调用 将失败。

| 参数 ||
| --- |--- |
| `view` | `WebView` : 发起回调的 WebView。|
| `request` | `WebResourceRequest` ：包含请求详细信息的对象。|

| 返回 ||
| --- |--- |
| `boolean` | `true` 取消当前加载，否则返回 `false` 。|

## shouldOverrideUrlLoading

在 [API 级别 1 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加
已在 [API 级别 24 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 弃用[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public boolean shouldOverrideUrlLoading ([WebView](https://developer.android.com/reference/android/webkit/WebView) view,
                [String](https://developer.android.com/reference/java/lang/String) url)

<font color="red">**此方法在 API 级别 24 中已弃用。**
请改用 [shouldOverrideUrlLoading(WebView, WebResourceRequest)](https://developer.android.com/reference/android/webkit/WebViewClient#shouldOverrideUrlLoading(android.webkit.WebView,%20android.webkit.WebResourceRequest)) 。</font>

当 URL 即将加载到当前 WebView 中时，让宿主应用程序有机会进行控制。 如果未提供 WebViewClient，默认情况下 WebView 将要求活动管理器为 URL 选择合适的处理程序。 如果提供了 WebViewClient，则返回 `true` 会导致当前 WebView 中止加载 URL，而返回 `false` 会导致 WebView 像往常一样继续加载 URL。

**注意：** 不要 [WebView#loadUrl(String)](https://developer.android.com/reference/android/webkit/WebView#loadUrl(java.lang.String)) 使用相同的 URL 调用 然后返回 `true` 。 这会不必要地取消当前加载并使用相同的 URL 启动新加载。 继续加载给定 URL 的正确方法是简单地 return `false` ，而不调用 [WebView#loadUrl(String)](https://developer.android.com/reference/android/webkit/WebView#loadUrl(java.lang.String)) .

**注意：** POST 请求不会调用此方法。

**注意：** 此方法可能会被subframes和非 HTTP(S) 方案调用； [WebView#loadUrl(String)](https://developer.android.com/reference/android/webkit/WebView#loadUrl(java.lang.String)) 使用这样的 URL 调用 将失败。
> 这种场景我经历过， 网页中有个 `iframe` 标签
代码内容如下：   
```Html
<iframe id="__ToutiaoJSBridgeIframe" src="bytedance://dispatch_message/" style="display: none;"></iframe>
```
> iframe 的 src 链接 被 shouldOverrideUrlLoading 拦截到，
"bytedance://dispatch_message/"这是一个 scheme, 然后最后当前网页就变成空白页了。 


| 参数 ||
| --- |--- |
| `view` | `WebView` : 发起回调的 WebView。|
| `url` | `String` : 要加载的 URL。|

| 返回 ||
| --- |--- |
| `boolean` | `true` 取消当前加载，否则返回 `false` 。|



