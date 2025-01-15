package com.brunov.proyectointegrador;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        ImageView mlogo=findViewById(R.id.logo);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.caida);
        mlogo.startAnimation(myanim);

        Glide.with(this)
                .load(R.drawable.fontway)
//                .transition(DrawableTransitionOptions.withCrossFade(1000))
                .centerCrop()
//            .circleCrop()
//            .placeholder(new ColorDrawable(this.getResources().getColor(R.color.white)))
                .into(mlogo);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}