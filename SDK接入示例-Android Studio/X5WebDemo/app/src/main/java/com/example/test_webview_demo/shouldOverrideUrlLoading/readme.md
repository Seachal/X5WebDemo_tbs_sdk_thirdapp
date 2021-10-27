# 前言 shouldOverrideUrlLoading

```Java
    /**
     * Give the host application a chance to take control when a URL is about to be loaded in the
     * current WebView. If a WebViewClient is not provided, by default WebView will ask Activity
     * Manager to choose the proper handler for the URL. If a WebViewClient is provided, returning
     * {@code true} causes the current WebView to abort loading the URL, while returning
     * {@code false} causes the WebView to continue loading the URL as usual.
     *
     * <p class="note"><b>Note:</b> Do not call {@link WebView#loadUrl(String)} with the request's
     * URL and then return {@code true}. This unnecessarily cancels the current load and starts a
     * new load with the same URL. The correct way to continue loading a given URL is to simply
     * return {@code false}, without calling {@link WebView#loadUrl(String)}.
     *
     * <p class="note"><b>Note:</b> This method is not called for POST requests.
     *
     * <p class="note"><b>Note:</b> This method may be called for subframes and with non-HTTP(S)
     * schemes; calling {@link WebView#loadUrl(String)} with such a URL will fail.
     *
     * @param view The WebView that is initiating the callback.
     * @param request Object containing the details of the request.
     * @return {@code true} to cancel the current load, otherwise return {@code false}.
     */
```
机翻：
```
当 URL 即将加载到当前 WebView 中时，让宿主应用程序有机会进行控制。 如果未提供 WebViewClient，默认情况下 WebView 将要求活动管理器为 URL 选择合适的处理程序。 如果提供了 WebViewClient，则返回true会导致当前 WebView 中止加载 URL，而返回false会导致 WebView 像往常一样继续加载 URL。
注意：不要使用请求的 URL 调用WebView.loadUrl(String)然后返回true 。 这会不必要地取消当前加载并使用相同的 URL 启动新加载。 继续加载给定 URL 的正确方法是简单地返回false ，而不调用WebView.loadUrl(String) 。
注意： POST 请求不会调用此方法。
注意：此方法可能会被子帧和非 HTTP(S) 方案调用； 使用这样的 URL 调用WebView.loadUrl(String)将失败。

参数：
view – 发起回调的 WebView。
request – 包含请求详细信息的对象。
返回：
true取消当前加载，否则返回false 。

```

## android webview什么时候调用shouldOverrideUrlLoading()

前进后退（isBackForward ），刷新（isReload），Post请求（navigationParams.isPost）都不会触发shouldOverrideUrlLoading．
如果都不是以上行为，还要满足isRedirect或!isLoadUrl 才能触发shouldOverrideUrlLoading．
isRedirect就是重定向的url,即重定向url也会触发shouldOverrideUrlLoading；
这里重点介绍以下isLoadUrl．
凡是webview.loadUrl出load页面的，isLoadUrl都是true(原因是webview.loadUrl最终会调到loadUrl(LoadUrlParams params)，进而params.setTransitionType(params.getTransitionType() | PageTransition.FROM_API))．


sca亲测：
  * 首次用 loadurl 加载出一个网页时不会触发shouldOverrideUrlLoading的。

  * 当在 webview 中点击网页链接，会触发 shouldOverrideUrlLoading.

  * 当网页中有重定向Redirect 时会触发shouldOverrideUrlLoading。




参考： [(47条消息) android webview 二次验证流程分析 shouldOverrideUrlLoading深度分析_a0407240134的专栏-CSDN博客](https://blog.csdn.net/a0407240134/article/details/51482021?winzoom=1)


# 一
测试 shouldOverrideUrlLoading 的作用

拦截 url 跳转,在里边添加点击链接跳转或者操作。


 * 如果未提供 WebViewClient，默认情况下 WebView 将要求活动管理器为 URL 选择合适的处理程序。

 * 如果提供了 WebViewClient，
    * 则返回true会导致当前 WebView 中止加载 URL，
    * 而返回false会导致 WebView 像往常一样继续加载 URL。
-----




# 二、shouldOverrideUrlLoading不同返回值的使用场景

接上文，还是分三种情况：

## 1.若没有设置 WebViewClient

这种很清晰，字面理解就行了，就是在mWebView.setWebViewClient(new WebViewClient())这句代码不写的情况下加载url时会由系统来指定浏览器打开，如果手机安装了多个浏览器的话会弹出对话框让用户来选择使用哪个浏览器打开。总之也就是不会使用我们自己程序内的webview容器来加载了。

## 2.若设置WebViewClient 且该方法返回 true

设置 WebViewClient 且在其 shouldOverrideUrlLoading 方法返回 true,则系统不会继续处理,处理由开发者接管，例如：

```
			 @Override
              public boolean shouldOverrideUrlLoading(WebView webView, String url) {
                  return true;
              }

```

如上，处理方式由自己来指定，如果不指定则不会跳转，不会响应.

## 3.若设置WebViewClient 且该方法返回 false

```
			 @Override
             public boolean shouldOverrideUrlLoading(WebView webView, String url) {
                 return false;
             }

```

这种情况下就会使用我们自己的webview来打开url.

## 4.loadurl

```
			@Override
            public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            	 webView.loadUrl(url);
                 return false/true;
             }

```

若设置WebViewClient且在方法中调用loadUrl的话则不会走retrun,所以返回true和false都是无效的，会重新加载url。
------------------------------------------------------------------------

# 下面是对此问题的解决

用于测试的网页代码
* [page_refresh.html](../../../../../assets/webpage/page_refresh.html)
* [scheme_error.html](../../../../../assets/webpage/scheme_error.html)
* [scheme_normal.html](../../../../../assets/webpage/scheme_normal.html)

scheme_error.html与scheme_normal.html的区别主要在 <iframe>中


```
<iframe id="__ToutiaoJSBridgeIframe" src="bytedance://dispatch_message/" style="display: none;"></iframe>
```
iframe 的 src 链接 被 shouldOverrideUrlLoading 拦截到，
"bytedance://dispatch_message/"这是一个 scheme,



正常情况下通过 scheme 调起其他 app的activity或者本app的activity的方式是：
```
   //手机银行、微信、打电话 是bocpay:开头的scheme协议
                if (url.startsWith("bocpay:") || url.startsWith("weixin://") ||  url.startsWith("mailto://") || url.startsWith("tel:")) {
                    try {
                        intentUrl(url);
                        return true;
                    } catch (Exception e) {
                        //防止crash (如果手机上没有安装处理某个scheme开头的url的APP, 会导致crash)
                        //没有安装该app时，返回true，表示拦截自定义链接，但不跳转，避免弹出上面的错误页面
                        return true;
                    }
                }
                
      private void intentUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }              
```


而app代码中没有对此 scheme的处理， 如果用
```
view.loadUrl(url);
      return false;
```
view.loadUrl(url); 去加载一个 scheme 就会报错。

那么解决方案是，没有必要多此一举，多写一行
`view.loadUrl(url);`，所以删掉`view.loadUrl(url);` 。

删掉`view.loadUrl(url);`后， 如果 `return
true`,网页中的超链接点击就不会响应了，这样是不行的， 网页中有很多跳转的业务， 那么就
`return false;`。






参考：  
[(41条消息) WebView使用详解（二）——WebViewClient与常用事件监听_启舰-CSDN博客](https://blog.csdn.net/harvic880925/article/details/51523983)

[Carson带你学Android：最全面、易懂的Webview使用教程 - 简书](https://www.jianshu.com/p/3c94ae673e2a)

[(41条消息) shouldOverrideUrlLoading返回值的处理及webview重定向造成无法返回的解决_MR CUI的专栏-CSDN博客_shouldoverrideurlloading 返回值](https://blog.csdn.net/cui130/article/details/85569426#shouldOverrideUrlLoading_3)

[HTTP 的重定向 - HTTP | MDN](https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Redirections)

[HTML <iframe> 标签 | 菜鸟教程](https://www.runoob.com/tags/tag-iframe.html)
