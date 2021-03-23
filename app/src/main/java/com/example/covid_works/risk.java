package com.example.covid_works;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class risk extends Activity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.risk_menu);
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openCases();
            }
        });
        WebView webview = (WebView) findViewById(R.id.webview);

        webview.setWebChromeClient(new WebChromeClient());
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        String html = "<iframe height = \" 650 \" width = \" 390 \"  id=\"hf-iframe\" src=\"https://covid19.infermedica.com/en\"></iframe>";
        webview.loadData(html, "text/html", null);
    }
    public void openCases(){
        Intent intent = new Intent(this, vaccination.class);
        startActivity(intent);

    }
}
