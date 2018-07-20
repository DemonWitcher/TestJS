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
//
//            @Override
//            public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
//                L.i("onRenderProcessGone");
//                return false;
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                L.i("onPageFinished  url:"+url);
//            }
        });

        //web的网页
//        webView.loadUrl("http://www.gcssloop.com/customview/CustomViewIndex/");

        //本地的网页
        webView.loadUrl("file:///android_asset/test.html");
        //本地的存放在:assets文件夹中

    }
}
