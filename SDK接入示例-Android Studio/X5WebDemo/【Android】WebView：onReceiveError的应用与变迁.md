`onReceiveError`是WebViewClient提供的方法，用于网页产生错误时进行回调处理。

## 1\. 旧版的onReceiveError

在API23之前，该方法的签名是：

```java
public void onReceivedError(WebView view, int errorCode,String description, String failingUrl);
```

文档是：

> Report an error to the host application. These errors are unrecoverable (i.e. the main resource is unavailable). The errorCode parameter corresponds to one of the ERROR\_\* constants.
> 翻译： 向宿主应用程序报告错误。这些错误是不可恢复的（即主要资源不可用）。该errorCode参数对应于ERROR_*常量之一。

简单来说，onReceivedError只有在遇到不可用的(**unrecoverable**)错误时，才会被调用）。
比如，当WebView加载链接*www.barryzhang.com*时，”不可用”的情况有可以包括有：

*   没有网络连接
*   连接超时
*   找不到页面www.barryzhang.com

而下面的情况则不会被报告：

*   网页内引用其他资源加载错误，比如图片、css不可用
*   js执行错误

## 2\. 应用：显示个自定义ERROR界面

基于以上特性，所以它可以用来处理网页加载不出来的情况，比如显示一段友好的提示语、一个重试按钮等。
比如像这样：

```java
@Override
public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
    super.onReceivedError(view, errorCode, description, failingUrl);
    layoutError.setVisibility(View.VISIBLE);
    textViewErrorMessage.setText("(错误码:" + errorCode + "  " + description + ")"  );
}
```

——这么做的还有一个原因是，虽然默认的网页错误样式每个ROM都可能不一样，但是却是一样的丑……，来个对比图感受一下，从左到右依次是：MIUI(Android5.0.2)、Nexus5X(Android7)、以及自定义之后的效果：
![对比图](https://img-blog.csdn.net/20161004124312697)

## 3\. 新版的onReceiveError

So far so good, but~
API23(Android6)，Google对onReceiveError进行了一次改版重载，**并且把老版本的废弃了**，ㄒoㄒ~~
签名改成了这样：

```java
public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error);
```

文档改成了：

> Report web resource loading error to the host application. These errors usually indicate inability to connect to the server. Note that unlike the deprecated version of the callback,the new version will be called for any resource (iframe, image, etc), not just for the main page. Thus, it is recommended to perform minimum required work in this callback.

> 翻译： 向宿主应用程序报告 Web 资源加载错误。这些错误通常表示无法连接到服务器。请注意，与已弃用的回调版本不同，新版本将针对任何资源（iframe、图像等）调用，而不仅仅是针对主页。因此，建议在此回调中执行最低要求的工作

新版的onReceiveError能接收到的错误更多，不再局限于之前的”不可用”的情况——好像是比之前更强大了。
但是，这时候如果我们依然用使用旧版本的方式来使用新版，像这样：

```java
@Override
public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
    // ！！在新版的onReceivedError中，沿用之前的处理逻辑（这是错误的示例！！）
    super.onReceivedError(view, errorCode, description, failingUrl);
    layoutError.setVisibility(View.VISIBLE);
    textViewErrorMessage.setText("(错误码:" + error.getErrorCode() + "  " + error.getDescription().toString() + ")"  );
}
```

这会导致的问题是：在Android6.0以上的机器上，网页中的任意一个资源获取不到（比如字体），网页就很可能显示自定义的错误界面。尤其是如果Html用了本地化技术，’ERR\_FILE\_NOT\_FOUND’开始变得特别常见。

## 4\. 如何像在老版本一样工作？

### 4.1 继续用老版本呢？

Bingo！可以，起码从目前来看，测试结果表明至少在Andoid6以及Android7上是可以工作的。
然而，终究，使用已废弃的API终究是不太优雅——说不定哪个版本就突然不能用了，仿佛像个定时炸弹一样。

### 4.2 isForMainFrame

我们注意到新版的onReceivedError跟老版相比，多了一个`WebResourceRequest`参数，而`WebResourceRequest`有一个方法叫做`isForMainFrame`，描述为：

> Gets whether the request was made for the main frame
> 获取当前的网络请求是否是为*main frame*创建的.

加上这个条件判断是来试试？

```java
@Override
public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
    super.onReceivedError(view, errorCode, description, failingUrl);
    if(request.isForMainFrame()){// 在这里加上个判断
        // 显示错误界面
    }
}
```

实验证明这个方法是有效的。

### 4.3 当然,也还有其他方法

可以这样，直接上代码：

```java
@Override
public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
    super.onReceivedError(view, errorCode, description, failingUrl);
     if (request.getUrl().toString() .equals(getUrl())) {// 在这里加上个判断
        // 显示错误界面
    }
}
```

原理是：用请求的url来判断，如果出错的url跟webView当前加载的url一致，就显示错误页面。
↑↑经测试，也能通过~

## 总结

总而言之，最终的代码这样写，可以同时兼容新旧版本：

```java
    // 旧版本，会在新版本中也可能被调用，所以加上一个判断，防止重复显示
    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            return;
        }
        // 在这里显示自定义错误页
    }

    // 新版本，只会在Android6及以上调用
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
        if (request.isForMainFrame()){ // 或者： if(request.getUrl().toString() .equals(getUrl()))
            // 在这里显示自定义错误页
        }
    }
```