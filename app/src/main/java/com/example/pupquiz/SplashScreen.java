package com.example.pupquiz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3000;

    //variables
    Animation topAnim, bottomAnim;
    ImageView logoImage;
    TextView slogan;
    @Override
    @SuppressWarnings("DEPRECATION")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            final WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.statusBars());
            }
        } else {
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );

        }
        //animations
        topAnim = AnimationUtils.loadAnimation(this ,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this ,R.anim.bottom_animation);

        //hooks
        logoImage = findViewById(R.id.pupQuizLogo);
        slogan = findViewById(R.id.textViewLabel);

        logoImage.setAnimation(topAnim);
        slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                Animatoo.animateSplit(SplashScreen.this);
                finish();
            }
        },SPLASH_SCREEN);


    }
}