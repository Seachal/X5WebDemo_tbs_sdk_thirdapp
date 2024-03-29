js想获取原生的数据。 
js  调原生，然后原生调 js 把参数 return 给 js.

## 1 参考 ecej


```java
  @JavascriptInterface
    public void getUserToken() {
        DeviceBridge.getUserToken(mWebView);
    }
```

```java
 public static void getUserToken(WebView mWebView) {
        // 回调H5方法tokenCallback({"token":"xxxxxxx")
        String json = new JsonBuilder().putEnd("token", AppInfo.TOKEN).toString();
        mWebView.loadUrl("javascript:tokenCallback('" + json + "')");
    }
```


---


## 2   js  调原生原理

1. 原生Android通过 addJavascriptInterface给 js  一个对象 ”injectedObject“  注意injectedObject是自定义的名字
```
.addJavascriptInterface("injectedObject", new MyJavascriptInterface(this))
```


 2. js调原生 Android  时， 通过 window.injectedObject， 去找 Android 原生的方法，
```
<li><a onClick="window.injectedObject.startFunction('我是网页传出来的数据')">点击调用java代码并传递参数</a></li><br/>
```


3. 如果在 MyJavascriptInterface中，没有对应的函数。那么就不起作用。 

---


## 3  原生调 js

```java
js  代码
function getToken(parameter) {
            alert(parameter)
        }

        function test() {
            alert("test1")
        }
```

- 如果没有参数：
```java
mWebView.loadUrl("javascript:test()");
```

- 如果有参数
```java

String s1 = ”sss“
mWebView.loadUrl("javascript:getYxToken('"+s1+"')");
```
**注意** 有参数时，一定要注意 （）中间的 (' "+s1+" ')"单引号。

更高的版本可以用 evaluateJavascript 代替 loadUrl。
```java
fun WebView.loadJs(jsString: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        this.evaluateJavascript(jsString, null)
    } else {
        this.loadUrl(jsString)
    }
}
```

**注意    不管是 **evaluateJavascript 还是** **loadUrl，** **loadUrl都需要在页面加载完，调用时才会生效。 
**遇到的没生效案例**：   h5在进入页面就掉 原生，然后在原生的方法内调 js  function, 因为整个页面还没有加载完，
即上一个 loadurl()还没有执行完，     就又新的.loadUrl("javascript: xxx()" ，新的 loadur 是不会生效的。 
**怎么办？**

-  1 在 onFinishied 回调中调用 loadUrl。   但是不能保证 js  调原生，然后原生调 js. 
-  2 或者让js 修改，在页面加载完成之后再  js 调原生。 


> 导出自 语雀