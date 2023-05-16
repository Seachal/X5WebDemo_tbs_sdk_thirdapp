package com.example.test_webview_demo.jscall;

import android.content.Context;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;

import com.tencent.smtt.sdk.WebView;


/**
 * Description:
 * JS、Android交互相关API
 *
 * @author wdliang
 * @date: 2017-05-04 15:46
 */

public class H5Bridge {
    private Context mContext;
    private WebView mWebView;

    public H5Bridge(Context context, WebView webView) {
        mContext = context;
        mWebView = webView;
    }
    public H5Bridge(Context context, WebView webView, ViewGroup viewGroup) {
        mContext = context;
        mWebView = webView;
    }


    @JavascriptInterface
    public void login() {

    }



    @JavascriptInterface
    public void getTokenSignal() {
        Utils.getYxToken3(mWebView);
    }


}
