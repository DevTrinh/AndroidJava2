package trinhmanhdiv.ListView.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ReadNews extends AppCompatActivity {

    WebView wvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_new);

        wvNews = findViewById(R.id.wv_news);

        Intent intent = getIntent();
        String urlLink =  intent.getStringExtra("urlNews");

        wvNews.loadUrl(urlLink);

        wvNews.setWebViewClient(new WebViewClient());

    }
}