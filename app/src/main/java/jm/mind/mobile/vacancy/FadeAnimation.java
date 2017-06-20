package jm.mind.mobile.vacancy;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/**
 * Created by kminor on 30/4/2017.
 */

class FadeAnimation {

    public void start(@Nullable final View v1, @Nullable final View v2) {
        //View to fade in, view to fade out
        AlphaAnimation fadeIn = new AlphaAnimation(0, 1); //fade in animation from 0 (transparent) to 1 (fully visible)
        fadeIn.setDuration(300); //set duration in milliseconds
        fadeIn.setFillAfter(true);
        if (v1 != null) {
            v1.startAnimation(fadeIn);
        }
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (v1 != null) {
                    v1.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (v1 != null) {
            v1.startAnimation(fadeIn);
        }

        AlphaAnimation fadeOut = new AlphaAnimation(1, 0); //fade out animation from 1 (fully visible) to 0 (transparent)
        fadeOut.setDuration(300); //set duration in milliseconds
        fadeOut.setFillAfter(true);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (v2 != null) {
                    v2.setVisibility(View.GONE);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (v2 != null) {
            v2.startAnimation(fadeOut);
        }
    }
}
