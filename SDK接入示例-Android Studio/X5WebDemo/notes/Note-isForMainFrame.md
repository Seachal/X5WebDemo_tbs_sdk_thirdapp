

该 `isForMainFrame` 方法实际上是从 WebKit 继承的。 例如，这是在 [Apple 文档中](https://developer.apple.com/reference/webkit/wknavigationresponse/1459482-isformainframe)

因此，这里的 MainFrame 指的是 WebKit 概念，即根 WebFrame。

> 在幕后，WebFrame 对象将包含在单个框架元素中的内容封装起来。 WebFrame 对象的层次结构用于对整个网页进行建模，其中根称为主框架

您可以在 [文档中](https://developer.apple.com/reference/webkit/webview) 找到更多相关信息[](https://developer.apple.com/reference/webkit/webview)

根据这个定义，只有初始请求是针对“主框架”的，其余都是针对子 WebFrame 的请求。

参考：
[google chrome - What is "isForMainFrame" request in Android WebViewClient property meaning? - Stack Overflow](https://stackoverflow.com/questions/40000939/what-is-isformainframe-request-in-android-webviewclient-property-meaning)

The `isForMainFrame` method is actually inherited from WebKit. For instance, here is in the [Apple docs](https://developer.apple.com/reference/webkit/wknavigationresponse/1459482-isformainframe)

Thus, here MainFrame refers to the WebKit concept, which is the root WebFrame.

> Behind the scenes, WebFrame objects encapsulate the content contained in a single frame element. A hierarchy of WebFrame objects is used to model an entire webpage where the root is called the main frame

You can find more on that in [the docs](https://developer.apple.com/reference/webkit/webview)

By this definition, only the initial request is for the "main frame", the rest are requests for the children WebFrames.


# 2
### isForMainFrame

在 [API 级别 21 中](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) 添加[](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public abstract boolean isForMainFrame ()

获取请求是否是为了获取主框架的文档。

| 返回        |
|-----------|
| `boolean` | 是否对主框架文件提出请求。 例如， 对于子资源或 iframe 是`false` 。 |


参考： [WebResourceRequest  |  Android Developers](https://developer.android.com/reference/android/webkit/WebResourceRequest)
### isForMainFrame

Added in [API level 21](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)

public abstract boolean isForMainFrame ()

Gets whether the request was made in order to fetch the main frame's document.

| Returns |
| --- |
| `boolean` | whether the request was made for the main frame document. Will be `false` for subresources or iframes, for example. |