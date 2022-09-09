

前言：生活的艰难，更会激发对梦想的渴望，但艰难的生活却往往会成为梦想的绊脚石

**相关文章：**
[1、《WebView使用详解（一）——Native与JS相互调用（附JadX反编译）》](http://blog.csdn.net/harvic880925/article/details/51464687)
[2、《WebView使用详解（二）——WebViewClient与常用事件监听》](http://blog.csdn.net/harvic880925/article/details/51523983)
[3、《WebView使用详解（三）——WebChromeClient与LoadData补充》](http://blog.csdn.net/harvic880925/article/details/51583253)

上篇给大家简单讲了Webview中Native代码与JS相互调用的方法，这篇我们再讲讲有关各种拦截与处理的东东。

## 一、WebViewClient

### 1、概述

前面我们虽然实现了交互，但可能我们会有一个很简单的需求，就是在开始加载网页的时候显示进度条，加载结束以后隐藏进度条，这要怎么做？
这些简单的需求，Android开发的老人们肯定都已经想到了，这些有关各种事件的回调都被封装在WebViewClient类中了，在WebViewClient中有各种的回调方法，就是在某个事件发生时供我们监听
使用方法如下：

```java
mWebView.setWebViewClient(new WebViewClient(){   
    @Override   
     public void onPageStarted(WebView view, String url, Bitmap favicon) {   
        super.onPageStarted(view, url, favicon);  
        Log.d(TAG,"onPageStarted");  
    }     @Override    
    public void onPageFinished(WebView view, String url) {    
        super.onPageFinished(view, url);      
        Log.d(TAG,"onPageFinished");    }});
```

直接调用WebView.setWebViewClient方法即可设置WebViewClient回调，这里重写的两个函数，onPageStarted会在WebView开始加载网页时调用，onPageFinished会在加载结束时调用。这两个函数就可以完成我们开篇时的需求：在开始加载时显示进度条，在结束加载时隐藏进度条。

### 2、WebViewClient中函数概述

在WebViewClient中除了上面我们列举出的onPageStarted、onPageFinished还有很多其它函数，分别是：

```java
/** * 在开始加载网页时会回调 */
public void onPageStarted(WebView view, String url, Bitmap favicon)
 /** * 在结束加载网页时会回调 */
 public void onPageFinished(WebView view, String url)
 /** * 拦截 url 跳转,在里边添加点击链接跳转或者操作 */
 public boolean shouldOverrideUrlLoading(WebView view, String url)/** * 加载错误的时候会回调，在其中可做错误处理，比如再请求加载一次，或者提示404的错误页面 */public void onReceivedError(WebView view, int errorCode,String description, String failingUrl)/** * 当接收到https错误时，会回调此函数，在其中可以做错误处理 */public void onReceivedSslError(WebView view, SslErrorHandler handler,SslError error)/** * 在每一次请求资源时，都会通过这个函数来回调 */public WebResourceResponse shouldInterceptRequest(WebView view,        String url) {    return null;}
```

上面的方法比较多，我们一个个来看

### 3、WebViewClient之onPageStarted与onPageFinished

**onPageStarted**：通知主程序页面当前开始加载。该方法只有在加载main frame时加载一次，如果一个页面有多个frame，onPageStarted只在加载main frame时调用一次。也意味着若内置frame发生变化，onPageStarted不会被调用，如：在iframe中打开url链接。
**onPageFinished**：通知主程序页面加载结束。方法只被main frame调用一次。
我们就利用上面的想法来举个例子：开始加载时显示加载圆圈，结束加载时隐藏加载圆圈

```java
public class MyActivity extends Activity {    private WebView mWebView;     private ProgressDialog mProgressDialog;    private String TAG = "qijian";    @Override    public void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.main);         mWebView = (WebView)findViewById(R.id.webview);        mProgressDialog = new ProgressDialog(this);        mWebView.getSettings().setJavaScriptEnabled(true);         mWebView.loadUrl("http://blog.csdn.net/harvic880925");        mWebView.setWebViewClient(new WebViewClient(){             @Override            public boolean shouldOverrideUrlLoading(WebView view, String url) {                mWebView.loadUrl(url);                return true;            }             @Override            public void onPageStarted(WebView view, String url, Bitmap favicon) {                super.onPageStarted(view, url, favicon);                mProgressDialog.show();            }             @Override            public void onPageFinished(WebView view, String url) {                super.onPageFinished(view, url);                mProgressDialog.hide();            }        });    }}
```

效果图如下：
![](https://img-blog.csdn.net/20160528111639076?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

从效果图中可以明显看出，在加载页面的时候会显示圆形加载框，在加载成功以后会隐藏加载框。

### 4、WebViewClient之shouldOverrideUrlLoading

该函数的完整声明如下：

```java
public boolean shouldOverrideUrlLoading(WebView view, String url)
```

这个函数会在加载超链接时回调过来；所以通过重写shouldOverrideUrlLoading，可以实现对网页中超链接的拦截；
返回值是boolean类型，表示是否屏蔽WebView继续加载URL的默认行为，因为这个函数是WebView加载URL前回调的，所以如果我们return true，则WebView接下来就不会再加载这个URL了，所有处理都需要在WebView中操作，包含加载。如果我们return false，则系统就认为上层没有做处理，接下来还是会继续加载这个URL的。WebViewClient默认就是return false的：

```java
public boolean shouldOverrideUrlLoading(WebView view, String url) {       return false;}
```

（1）、如何在WebView中加载在线网址

在上一篇中，我们提到，如果要在WebView中加载在线网址，必须重写WebViewClient
现在网上铺天盖地的都是重写shouldOverrideUrlLoading来将URL加载进WebView,但在用多了WebView以后会发现，直接下面这样写，就可以实现在WebVIew中加载网页：

```java
public class MyActivity extends Activity {    private WebView mWebView;     private ProgressDialog mProgressDialog;    private String TAG = "qijian";    @Override    public void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.main);         mWebView = (WebView)findViewById(R.id.webview);        mProgressDialog = new ProgressDialog(this);        mWebView.getSettings().setJavaScriptEnabled(true);         mWebView.setWebViewClient(new WebViewClient());         mWebView.loadUrl("http://blog.csdn.net/harvic880925");    }}
```

效果图如下：
![](https://img-blog.csdn.net/20160528111913392?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

从效果图中可以看出即仅仅设置WebViewClient对象，使用它的默认回调就可以实现在WebView中加载在线URL了：

```javascript
mWebView.setWebViewClient(new WebViewClient());
```

（2）、shouldOverrideUrlLoading用途

由于每次超链接在加载前都会先走shouldOverrideUrlLoading回调，所以我们如果想拦截某个URL，将其转换成其它URL可以在这里做。
比如，我们拦截所有包含“blog.csdn.net”的地址，将其替换成”www.baidu.com”：
效果图如下：
![](https://img-blog.csdn.net/20160528112042952?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

代码如下：

```java
public class MyActivity extends Activity {    private WebView mWebView;     private ProgressDialog mProgressDialog;    private String TAG = "qijian";    @Override    public void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.main);         mWebView = (WebView)findViewById(R.id.webview);        mProgressDialog = new ProgressDialog(this);        mWebView.getSettings().setJavaScriptEnabled(true);         mWebView.setWebViewClient(new WebViewClient(){            @Override            public boolean shouldOverrideUrlLoading(WebView view, String url) {                if (url.contains("blog.csdn.net")){                    view.loadUrl("http://www.baidu.com");                }else {                    view.loadUrl(url);                }                return true;            }        });         mWebView.loadUrl("http://blog.csdn.net/harvic880925");    }}
```

最关键的位置在：

```java
public boolean shouldOverrideUrlLoading(WebView view, String url) {   if (url.contains("blog.csdn.net")){        view.loadUrl("http://www.baidu.com");    }else {        view.loadUrl(url);    }   return true;}
```

如果在当前webview加载的url中包含“blog.csdn.net”，则将其转换成”www.baidu.com”
这里需要非常注意的是：如果我们在shouldOverrideUrlLoading中return true,就表示告诉系统我们已经拦截了URL并做处理，不需要再触发系统默认的行为（）在WebView中加载URL；所以对于其它URL我们需要在else里重新调用view.loadUrl(url)来加载；不然WebView将会白屏，因为这个URL根本就没有加载进WebView，在shouldOverrideUrlLoading这就被我们拦截掉了。
那么问题来了，在我们return true了以后，WebView还会请求网络吗？我们来抓下请求：
![](https://img-blog.csdn.net/20160528112338891?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
从请求中可以看到，我们虽然拦截了”http://blog.csdn.net/harvic880925“但是仍然还是会请求网络的。只是请求以后结果并没有通过WebView加载。
那问题来了，如果我们return false呢，如果我们return false的话，是不需要else语句的，因为系统默认会加载这个URL，所以上面的语句与下面的意义相等：

```java
mWebView.setWebViewClient(new WebViewClient(){    @Override    public boolean shouldOverrideUrlLoading(WebView view, String url) {        if (url.contains("blog.csdn.net")){            view.loadUrl("http://www.baidu.com");        }        return false;    }}
```

所以相对而言，我们使用return false好像更方便，只需要对需要拦截的URL进行拦截，拦截以后，让WebView处理默认操作即可。
**所以结论来了：**
在利用shouldOverrideUrlLoading来拦截URL时，如果return true，则会屏蔽系统默认的显示URL结果的行为，不需要处理的URL也需要调用loadUrl()来加载进WebVIew，不然就会出现白屏；如果return false，则系统默认的加载URL行为是不会被屏蔽的，所以一般建议大家return false，我们只关心我们关心的拦截内容，对于不拦截的内容，让系统自己来处理即可。

### 5、WebViewClient之onReceivedError

onReceivedError的完整声明如下：

```java
public void onReceivedError(WebView view, int errorCode,String description, String failingUrl)
```

加载错误的时候会产生这个回调，在其中可做错误处理，比如我们可以加载一个错误提示页面
**这里有四个参数：**

*   WebView view:当前的WebView实例
*   int errorCode：错误码
*   String description：错误描述
*   String failingUrl：当前出错的URL

我们可以先写一个错误提示的本地页面：（error.html）

```html
<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <title>Title</title></head><body>    <h1 id="h">啊哈,出错了……</h1></body></html>
```

然后在加载返回错误时，重新加载错误页面

```java
mWebView.setWebViewClient(new WebViewClient(){    @Override    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {        super.onReceivedError(view, errorCode, description, failingUrl);        mWebView.loadUrl("file:///android_asset/error.html");    }});
```

效果图如下：
![](https://img-blog.csdn.net/20160528112956550?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

**源码在文章底部给出**

### 6、WebViewClient之onReceivedSslError

我们知道HTTPS协议是通过SSL来通信的，所以当使用HTTPS通信的网址（以https://开头的网站）出现错误时，就会通过onReceivedSslError回调通知过来，它的函数声明为：

```java
/** * 当接收到https错误时，会回调此函数，在其中可以做错误处理 */public void onReceivedSslError(WebView view, SslErrorHandler handler,SslError error)
```

*   **WebView view:**当前的WebView实例
*   **SslErrorHandler handler：**当前处理错误的Handler，它只有两个函数SslErrorHandler.proceed()和SslErrorHandler.cancel()，SslErrorHandler.proceed()表示忽略错误继续加载，SslErrorHandler.cancel()表示取消加载。在onReceivedSslError的默认实现中是使用的SslErrorHandler.cancel()来取消加载，所以一旦出来SSL错误，HTTPS网站就会被取消加载了，如果想忽略错误继续加载就只有重写onReceivedSslError，并在其中调用SslErrorHandler.proceed()
*   **SslError error：**当前的的错误对象，SslError包含了当前SSL错误的基本所有信息，大家自己去看下它的方法吧，这里就不再展开了。

示例（1）、默认加载SSL出错的网站——出现空白页面

我们先举个例子来看下默认情况下加载SSL有错的网站，WebView的表现是怎样的：(12306是通过Https协议来传输的，但是它的SSL证书是有问题的，所以我们就以12306网站为例)

```java
public class MyActivity extends Activity {    private WebView mWebView;     private ProgressDialog mProgressDialog;    private String TAG = "qijian";    @Override    public void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.main);         mWebView = (WebView)findViewById(R.id.webview);        mProgressDialog = new ProgressDialog(this);        mWebView.getSettings().setJavaScriptEnabled(true);         mWebView.setWebViewClient(new WebViewClient(){            @Override            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {                super.onReceivedSslError(view, handler, error);                Log.e(TAG,"sslError:"+error.toString());            }         mWebView.loadUrl("https://www.12306.cn/");    }}
```

在这里仅仅重写onReceivedSslError，并调用super.onReceivedSslError(view, handler, error);来调用默认的处理方式，然后把错误日志打出来：
![](https://img-blog.csdn.net/20160528113711099?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
错误日志如下：

![](https://img-blog.csdn.net/20160528113818154?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

示例（2）、使用SslErrorHandler.proceed()来继续加载

```java
mWebView.setWebViewClient(new WebViewClient(){    @Override    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {//      一定要注释掉！    //      super.onReceivedSslError(view, handler, error);        handler.proceed();        Log.e(TAG,"sslError:"+error.toString());    }});
```

这里做了两个改变：
第一：注释掉super.onReceivedSslError(view, handler, error);，取消系统的默认行为，我们看源码，可以发现在WebViewClient中onReceivedSslError的默认实现是这样的：

```java
public void onReceivedSslError(WebView view, SslErrorHandler handler,        SslError error) {    handler.cancel();}
```

所以默认是取消继续加载的，所以我们必须注释掉super.onReceivedSslError(view, handler, error)来取消这个默认行为！
第二：调用handler.proceed();来忽略错误继续加载页面。
所以此时的效果图为：
![](https://img-blog.csdn.net/20160528114922341?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

示例（3）：在SSL发生错误时，onReceivedError会被回调吗？——不会

大家可能还有一个疑问：当SSL发生错误时，我们说会回调onReceivedSslError，我们前面还说了一个出错时会回调的函数：onReceivedError，那么问题来了，当出现SSL错误时onReceivedError会被回调吗？
答案是不会的，我们来做个实验：

```java
mWebView.setWebViewClient(new WebViewClient(){    @Override    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {//                super.onReceivedSslError(view, handler, error);        handler.proceed();        Log.e(TAG,"sslError:"+error.toString());    }     @Override    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {        super.onReceivedError(view, errorCode, description, failingUrl);        Log.e(TAG,"onReceivedError:"+errorCode+"  "+description);    }});
```

在代码中我们同时使用onReceivedSslError和onReceivedError来接收错误，看下在出错时，哪个函数中会打出LOG，结果的日志如下：

![](https://img-blog.csdn.net/20160528210233582?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

从日志中明显可以看出，只有onReceivedSslError的接收日志，所以在SSL出错时，是不会触发onReceivedError回调的
**所以对于onReceivedSslError结论来了：**
当出现SSL错误时，WebView默认是取消加载当前页面，只有去掉onReceivedSslError的默认操作，然后添加SslErrorHandler.proceed()才能继续加载出错页面
当HTTPS传输出现SSL错误时，错误会只通过onReceivedSslError回调传过来

### 7、WebViewClient之shouldInterceptRequest

在每一次请求资源时，都会通过这个函数来回调，比如超链接、JS文件、CSS文件、图片等，也就是说浏览器中每一次请求资源时，都会回调回来，无论任何资源！但是必须注意的是shouldInterceptRequest函数是在非UI线程中执行的，在其中不能直接做UI操作，如果需要做UI操作，则需要利用Handler来实现，该函数声明如下：

```java
public WebResourceResponse shouldInterceptRequest(WebView view,        String url) {    return null;}
```

该函数会在请求资源前调用，我们可以通过返回WebResourceResponse的处理结果来让WebView直接使用我们的处理结果。如果我们不想处理，则直接返回null，系统会继续加载该资源。
利用这个特性，我们可以解决一个需求：假如网页中需要加载本地的图片，我们就可以通过拦截shouldInterceptRequest，并返回结果即可
比如下面的一段HTML代码中，img字段加载图片的地址是：http://localhost/qijian.png，这是我自定义的一个网址，在Android中，当发现要加载这个地址的资源时，我们将它换成本地的图片

```html
<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <title>Title</title></head><body>    <h1 id="h">欢迎光临启舰的blog</h1>    <img src="http://localhost/qijian.png"/></body></html>
```

然后是Native代码：

```java
public class MyActivity extends Activity {    private WebView mWebView;     private ProgressDialog mProgressDialog;    private String TAG = "qijian";    @Override    public void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.main);         mWebView = (WebView)findViewById(R.id.webview);        mProgressDialog = new ProgressDialog(this);        mWebView.getSettings().setJavaScriptEnabled(true);          mWebView.setWebViewClient(new WebViewClient(){            @Override            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {                try {                    if (url.equals("http://localhost/qijian.png")) {                        AssetFileDescriptor fileDescriptor =  getAssets().openFd("s07.jpg");                        InputStream stream = fileDescriptor.createInputStream();                        WebResourceResponse response = new WebResourceResponse("image/png", "UTF-8", stream);                        return response;                    }                }catch (Exception e){                    Log.e(TAG,e.getMessage());                }                return super.shouldInterceptRequest(view, url);            }        });         mWebView.loadUrl("file:///android_asset/web.html");}
```

这里代码比较容易理解，当发现当前加载资源的url是我们自定义的http://localhost/qijian.png时，就直接将本地的图片s07.jpg作为结果返回。有关使用WebResourceResponse来构造结果的方法，我这里就不再展开了，内容实在是太多了，想具体了解针对不同情况如何返回结果的话，自己搜下相关资料吧。
结果图如下：
![](https://img-blog.csdn.net/20160528210431097?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

### 7、WebViewClient之其余函数

上面讲了常用的大部分函数，还些一些函数，并不怎么用，这里由于篇幅有限就不再讲了，把函数声明和作用列出来供大家参考

```java
/** * 在加载页面资源时会调用，每一个资源（比如图片）的加载都会调用一次 */public void onLoadResource(WebView view, String url)  /** *  (WebView发生改变时调用)  *  可以参考http://www.it1352.com/191180.html的用法 */ public void onScaleChanged(WebView view, float oldScale, float newScale) /** * 重写此方法才能够处理在浏览器中的按键事件。 * 是否让主程序同步处理Key Event事件，如过滤菜单快捷键的Key Event事件。 * 如果返回true，WebView不会处理Key Event， * 如果返回false，Key Event总是由WebView处理。默认：false */public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) /** * 是否重发POST请求数据，默认不重发。 */onFormResubmission(WebView view, Message dontResend, Message resend) /** * 更新访问历史 */doUpdateVisitedHistory(WebView view, String url, boolean isReload) /** * 通知主程序输入事件不是由WebView调用。是否让主程序处理WebView未处理的Input Event。 * 除了系统按键，WebView总是消耗掉输入事件或shouldOverrideKeyEvent返回true。 * 该方法由event 分发异步调用。注意：如果事件为MotionEvent，则事件的生命周期只存在方法调用过程中， * 如果WebViewClient想要使用这个Event，则需要复制Event对象。 */onUnhandledInputEvent(WebView view, InputEvent event) /** * 通知主程序执行了自动登录请求。 */onReceivedLoginRequest(WebView view, String realm, String account, String args)/** * 通知主程序：WebView接收HTTP认证请求，主程序可以使用HttpAuthHandler为请求设置WebView响应。默认取消请求。 */onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm)/** * 通知主程序处理SSL客户端认证请求。如果需要提供密钥，主程序负责显示UI界面。 * 有三个响应方法：proceed(), cancel() 和 ignore()。 * 如果调用proceed()和cancel()，webview将会记住response， * 对相同的host和port地址不再调用onReceivedClientCertRequest方法。 * 如果调用ignore()方法，webview则不会记住response。该方法在UI线程中执行， * 在回调期间，连接被挂起。默认cancel()，即无客户端认证 */onReceivedClientCertRequest(WebView view, ClientCertRequest request)
```

## 二、其它事件处理

上面讲了有关WebViewClient的用法，但其中还有一些小问题是WebViewClient无法解决的，比如返回按键、滚动事件监听等，下面我们就这些问题来跟大家做下探讨

### 1、返回按键

如果用webview点链接看了很多页以后，如果不做任何处理，点击系统“Back”键，整个浏览器会调用finish()而结束自身，如果希望浏览的网页回退而不是退出浏览器，需要在当前Activity中处理并消费掉该Back事件。 覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法。

```java
public class MyActivity extends Activity {    private WebView mWebView;     private ProgressDialog mProgressDialog;    private String TAG = "qijian";    @Override    public void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.main);         mWebView = (WebView)findViewById(R.id.webview);        mProgressDialog = new ProgressDialog(this);        mWebView.getSettings().setJavaScriptEnabled(true);        mWebView.setWebViewClient(new WebViewClient());         mWebView.loadUrl("http://blog.csdn.net/harvic880925/");    }     @Override    public boolean onKeyDown(int keyCode, KeyEvent event) {         //改写物理返回键的逻辑        if(keyCode==KeyEvent.KEYCODE_BACK) {            if(mWebView.canGoBack()) {                mWebView.goBack();//返回上一页面                 return true;            } else {                System.exit(0);//退出程序             }        }        return super.onKeyDown(keyCode, event);    }}
```

在未重写onKeyDown前的效果图：点击回退按钮，整个Activity就销毁了
![](https://img-blog.csdn.net/20160528210701162?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

重写onKeyDown后的效果图：
![](https://img-blog.csdn.net/20160528210715302?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

可见在重写onKeyDown后，点击回退按钮时，就会回退到WebView的上一个页面。

### 2、滚动事件监听

我们都知道监听滚动事件一般都是设置setOnScrollChangedListener，可惜的是 WebView并没有给我们提供这样的方法，但是我们可以重写WebView，覆盖里面的一个方法： protected void onScrollChanged(final int l, final int t, final int oldl,final int oldt){} 然后再对外提供一个接口，示例代码如下：

```java
public class MyWebView extends WebView {     private OnScrollChangedCallback mOnScrollChangedCallback;     public MyWebView(Context context) {        super(context);    }     public MyWebView(Context context, AttributeSet attrs) {        super(context, attrs);    }     public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {        super(context, attrs, defStyleAttr);    }     @Override    protected void onScrollChanged(int l, int t, int oldl, int oldt) {        super.onScrollChanged(l, t, oldl, oldt);        if (mOnScrollChangedCallback != null) {            mOnScrollChangedCallback.onScroll(l,t,oldl,oldt);        }    }     public OnScrollChangedCallback getOnScrollChangedCallback() {        return mOnScrollChangedCallback;    }     public void setOnScrollChangedCallback(            final OnScrollChangedCallback onScrollChangedCallback) {        mOnScrollChangedCallback = onScrollChangedCallback;    }     public static interface OnScrollChangedCallback {        public void onScroll(int left,int top ,int oldLeft,int oldTop);    }}
```

这段代码难度不大，就不再细讲了。

### 3、如何强制使用外部浏览器打开网页

如果不想在 webview 中显示网页，而是直接跳转到浏览器的话，可以像下边那样调用。

```java
Uri uri = Uri.parse("http://www.example.com"); Intent intent = new Intent(Intent.ACTION_VIEW, uri); startActivity(intent);
```

这里是使用隐式Intent的方式来启用外部应用，有关隐式Intent的知识，可以参考：
[《intent详解（一）》](http://blog.csdn.net/harvic880925/article/details/38399723)
[《intent详解（二）》](http://blog.csdn.net/harvic880925/article/details/38406421)

好了，这篇文章就到这里了，下篇文章给大家继续讲解有关WebView的知识。

**如果本文有帮到你，记得加关注哦**

**源码下载地址：[http://download.csdn.net/detail/harvic880925/9534186](http://download.csdn.net/detail/harvic880925/9534186)**

**请大家尊重原创者版权，转载请标明出处：[http://blog.csdn.net/harvic880925/article/details/51523983](http://blog.csdn.net/harvic880925/article/details/51523983)谢谢**