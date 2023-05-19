

# 此项目包含这些内容



[Note-1Goolge官网_网页浏览客户端_WebViewClient](https://github.com/Seachal/X5WebDemo_tbs_sdk_thirdapp/blob/master/SDK%E6%8E%A5%E5%85%A5%E7%A4%BA%E4%BE%8B-Android%20Studio/X5WebDemo/notes/Note-1Goolge%E5%AE%98%E7%BD%91_%E7%BD%91%E9%A1%B5%E6%B5%8F%E8%A7%88%E5%AE%A2%E6%88%B7%E7%AB%AF_WebViewClient_%E6%96%87%E6%A1%A3.md)

[Note-2Goolge官网shouldOverrideUrlLoading文档](https://github.com/Seachal/X5WebDemo_tbs_sdk_thirdapp/blob/master/SDK%E6%8E%A5%E5%85%A5%E7%A4%BA%E4%BE%8B-Android%20Studio/X5WebDemo/notes/Note-2Goolge%E5%AE%98%E7%BD%91shouldOverrideUrlLoading%E6%96%87%E6%A1%A3.md)

[Note-3WebView使用详解（二）——WebViewClient与常用事件监听](https://github.com/Seachal/X5WebDemo_tbs_sdk_thirdapp/blob/master/SDK%E6%8E%A5%E5%85%A5%E7%A4%BA%E4%BE%8B-Android%20Studio/X5WebDemo/notes/Note-3WebView%E4%BD%BF%E7%94%A8%E8%AF%A6%E8%A7%A3%EF%BC%88%E4%BA%8C%EF%BC%89%E2%80%94%E2%80%94WebViewClient%E4%B8%8E%E5%B8%B8%E7%94%A8%E4%BA%8B%E4%BB%B6%E7%9B%91%E5%90%AC.md)

[Note-4Android笔记WebView详细注释](https://github.com/Seachal/X5WebDemo_tbs_sdk_thirdapp/blob/master/SDK%E6%8E%A5%E5%85%A5%E7%A4%BA%E4%BE%8B-Android%20Studio/X5WebDemo/notes/Note-4Android%E7%AC%94%E8%AE%B0WebView%E8%AF%A6%E7%BB%86%E6%B3%A8%E9%87%8A.md)

[Note-5Android WebView：onReceiveError的应用与变迁](https://github.com/Seachal/X5WebDemo_tbs_sdk_thirdapp/blob/master/SDK%E6%8E%A5%E5%85%A5%E7%A4%BA%E4%BE%8B-Android%20Studio/X5WebDemo/notes/Note-5Android%20WebView%EF%BC%9AonReceiveError%E7%9A%84%E5%BA%94%E7%94%A8%E4%B8%8E%E5%8F%98%E8%BF%81.md)


[Note-6isForMainFrame](https://github.com/Seachal/X5WebDemo_tbs_sdk_thirdapp/blob/master/SDK%E6%8E%A5%E5%85%A5%E7%A4%BA%E4%BE%8B-Android%20Studio/X5WebDemo/notes/Note-6isForMainFrame.md)


[Note-7js 与原生调用](https://github.com/Seachal/X5WebDemo_tbs_sdk_thirdapp/blob/master/SDK%E6%8E%A5%E5%85%A5%E7%A4%BA%E4%BE%8B-Android%20Studio/X5WebDemo/notes/Note-7js%20%E4%B8%8E%E5%8E%9F%E7%94%9F%E8%B0%83%E7%94%A8.md)


[Problem-1记录一次webView 报错排查过程](https://github.com/Seachal/X5WebDemo_tbs_sdk_thirdapp/blob/master/SDK%E6%8E%A5%E5%85%A5%E7%A4%BA%E4%BE%8B-Android%20Studio/X5WebDemo/notes/Problem-1%E8%AE%B0%E5%BD%95%E4%B8%80%E6%AC%A1webView%20%E6%8A%A5%E9%94%99%E6%8E%92%E6%9F%A5%E8%BF%87%E7%A8%8B.md)


[Problem-2问题处理-无法上传图片](https://github.com/Seachal/X5WebDemo_tbs_sdk_thirdapp/blob/master/SDK%E6%8E%A5%E5%85%A5%E7%A4%BA%E4%BE%8B-Android%20Studio/X5WebDemo/notes/Problem-2%E9%97%AE%E9%A2%98%E5%A4%84%E7%90%86-%E6%97%A0%E6%B3%95%E4%B8%8A%E4%BC%A0%E5%9B%BE%E7%89%87.md)

---

# Goolge官网shouldOverrideUrlLoading文档

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


# 



---

待 补充 Java js 互相调用  [webview_java/me.txt at main · wangweijun123/webview_java](https://github.com/wangweijun123/webview_java/blob/main/me.txt)




