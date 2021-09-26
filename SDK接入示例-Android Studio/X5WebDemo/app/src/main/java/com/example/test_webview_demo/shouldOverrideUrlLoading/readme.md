测试 shouldOverrideUrlLoading 的作用

拦截 url 跳转,在里边添加点击链接跳转或者操作。


参考：[(41条消息) WebView使用详解（二）——WebViewClient与常用事件监听_启舰-CSDN博客](https://blog.csdn.net/harvic880925/article/details/51523983)

[Carson带你学Android：最全面、易懂的Webview使用教程 - 简书](https://www.jianshu.com/p/3c94ae673e2a)

[(41条消息) shouldOverrideUrlLoading返回值的处理及webview重定向造成无法返回的解决_MR CUI的专栏-CSDN博客_shouldoverrideurlloading 返回值](https://blog.csdn.net/cui130/article/details/85569426#shouldOverrideUrlLoading_3)

 * 如果未提供 WebViewClient，默认情况下 WebView 将要求活动管理器为 URL 选择合适的处理程序。

 * 如果提供了 WebViewClient，
    * 则返回true会导致当前 WebView 中止加载 URL，
    * 而返回false会导致 WebView 像往常一样继续加载 URL。
