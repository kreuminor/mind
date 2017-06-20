package jm.mind.mobile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.view.WindowManager;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;


public class SplashActivity extends AwesomeSplash {

    private static final String TAG1 = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_splash);

    }
    @Override
    public void initSplash(ConfigSplash configSplash) {

       // ActionBar actionBar = getSupportActionBar();
        //actionBar.hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set Background Animation

        configSplash.setBackgroundColor(R.color.bg_splash);
        configSplash.setAnimCircularRevealDuration(1000);
        configSplash.setRevealFlagX(Flags.WITH_LOGO);
        configSplash.setRevealFlagX(Flags.REVEAL_TOP);

        //Logo

        configSplash.setLogoSplash(R.drawable.logo1);
        configSplash.setAnimLogoSplashDuration(1200);
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeIn);

        //Title on Splash

        configSplash.setTitleSplash("");
        configSplash.setTitleTextColor(R.color.text);
        configSplash.setTitleTextSize(19f);
        configSplash.setAnimTitleDuration(1100);
        configSplash.setAnimTitleTechnique(Techniques.FadeIn);

    }

    @Override
    public void animationsFinished() {
    startActivity(new Intent(SplashActivity.this, MainActivity.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        SplashActivity.this.finish();

    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

}

