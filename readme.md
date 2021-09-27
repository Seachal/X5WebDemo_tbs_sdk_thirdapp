测试 shouldOverrideUrlLoading 的作用

拦截 url 跳转,在里边添加点击链接跳转或者操作。


 * 如果未提供 WebViewClient，默认情况下 WebView 将要求活动管理器为 URL 选择合适的处理程序。

 * 如果提供了 WebViewClient，
    * 则返回true会导致当前 WebView 中止加载 URL，
    * 而返回false会导致 WebView 像往常一样继续加载 URL。
-----

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
