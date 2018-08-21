package com.witcher.testjs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {


    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webview);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                L.i("shouldOverrideUrlLoading");
                return super.shouldOverrideUrlLoading(view,request);
            }
        });
        webView.addJavascriptInterface(this, "testJavaAndJs");

        //web的网页
//        webView.loadUrl("http://www.gcssloop.com/customview/CustomViewIndex/");

        //本地的网页
        webView.loadUrl("file:///android_asset/test.html");
        //本地的存放在:assets文件夹中
    }
    @android.webkit.JavascriptInterface
    public void jsCallJava(String content){
        L.i("js调用了java content:"+content);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                javaCallJs();
            }
        });
    }

    public void javaCallJs(){
        String content = "cccbbbaaa";
        String js =  "javascript:javaCallJs('"+content+"')";
        webView.loadUrl(js);
    }
}
