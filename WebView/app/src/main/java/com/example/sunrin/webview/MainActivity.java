package com.example.sunrin.webview;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    WebView webView;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.urlInput);
        button = findViewById(R.id.loadButton);
        webView = findViewById(R.id.webView);

        // WebView 브라우저 설정
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        webView.loadUrl("file:///android_asset/index.html");

        // WebView 안에서 페이지 이동이 생기면 자동 호출
        webView.setWebViewClient(new MyWebClient());

        // JavaScript와 Java 연동
        webView.addJavascriptInterface(new JavascriptMethods(), "sample");

        // 브라우저 자체 이벤트(alert, confirm)
        webView.setWebChromeClient(new MyWebChromeClient(this));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl(editText.getText().toString());
            }
        });
    }

    public class JavascriptMethods{
        JavascriptMethods(){}

        @android.webkit.JavascriptInterface
        public void showToast(String msg){
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }

        @android.webkit.JavascriptInterface
        public void clickOnFace(){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    button.setText("클릭 후 열기");
                    webView.loadUrl("javascript:changeFace()");
                }
            });
        }
    }

    class MyWebChromeClient extends WebChromeClient{
        Context context;

        public MyWebChromeClient(Context context){
            this.context = context;
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("MyWebView");
            builder.setMessage(message);
            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    result.confirm();
                }
            });
            builder.create();
            builder.show();

            return true;
        }

        @Override
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            result.confirm();

            return true;
        }
    }

    class MyWebClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Toast.makeText(getApplicationContext(), url, Toast.LENGTH_SHORT).show();
            view.loadUrl(url);

            return true;
        }
    }
}
