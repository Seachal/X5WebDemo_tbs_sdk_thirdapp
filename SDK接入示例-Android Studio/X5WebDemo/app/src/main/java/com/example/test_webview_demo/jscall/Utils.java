package com.example.test_webview_demo.jscall;

import com.tencent.smtt.sdk.WebView;

/**
 * *
 * *
 * Project_Name:X5WebDemo
 *
 * @author zhangxc
 * @Description: TODO
 * @date 2023/3/14 17:43
 * @Version：1.0
 */
public class Utils {
    public static void getYxToken3(WebView webView) {
        String s1 =  "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJ4a3ctbWFuYWdlci11c2VyIiwiaXNzIjoieGt3LXl4IiwiY29tcGFueSI6Ind3dy56eHhrLmNvbSIsInRpbWUiOjE2Nzg3ODMwMDkyMTUsImV4cCI6MTY3ODg2OTQwOSwidXNlcklkIjoiMzE3NDI4NTU4In0.YQNQQ3dsksFwtMmKCR51fce5C-FzTo0fetkHqN7Z-Hw";
        webView.loadUrl("javascript:getYxToken("+s1+")");
    }
}
