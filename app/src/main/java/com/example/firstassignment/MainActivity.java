package com.example.firstassignment;

import android.os.Bundle;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    protected void onStart() {
        super.onStart();

        ImageView gameImage = findViewById(R.id.game);
        ImageView logoImage = findViewById(R.id.logo);


        logoImage.setVisibility(logoImage.INVISIBLE);


        Animation rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        gameImage.startAnimation(rotateAnim);

        rotateAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {

                logoImage.setVisibility(logoImage.VISIBLE);


                Animation zoomOut = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_out_for_logo);
                logoImage.startAnimation(zoomOut);

                zoomOut.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {}

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        Intent intent = new Intent(MainActivity.this, LogInSecondScreen.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {}
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
    }


}