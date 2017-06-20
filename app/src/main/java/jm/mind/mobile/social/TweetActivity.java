package jm.mind.mobile.social;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import jm.mind.mobile.ContactActivity;
import jm.mind.mobile.MainActivity;
import jm.mind.mobile.R;

public class TweetActivity extends AppCompatActivity {

    public WebView web;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        web = (WebView) findViewById(R.id.home7);
        web.setWebViewClient(new myWebClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("http://www.mind.edu.jm/www.twitter.com");

        // Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TweetActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }

        });
        getSupportActionBar().setTitle("Twitter Feed");

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nf = cm.getActiveNetworkInfo();
        if (nf != null && nf.isConnected()) {
            // do your stuff here
        } else {
            Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
        }
    }
    // Action Button/Menu Icon

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(TweetActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        this.finish();
    }

    private class myWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
            //To Prevent  Web page not available
            if (errorCode == -2) {
                view.loadData("", "", null);

                AlertDialog.Builder builder = new AlertDialog.Builder(TweetActivity.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#0d4d8b'><b>Conference 2017</b></font>"));
                builder.setMessage(Html.fromHtml("<font color='#120049'>The Facebook Feed will not open, your data services are not working. Please check your data services.</font>"));
                builder.setPositiveButton(Html.fromHtml("<font color='#7F02AE'><center><b>OK</b></center></font>"), new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //SplashScreenActivity.class is your Launcher Activity
                        // In Case of Fragment instead of Activity Replace getApplicationContext()  with getActivity()

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("EXIT", true);
                        startActivity(intent);
                        finish();

                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        }

    }
}
