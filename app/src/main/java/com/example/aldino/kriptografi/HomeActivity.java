package com.example.aldino.kriptografi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aldino.kriptografi.PerSubs.Main2Activity;
import com.example.aldino.kriptografi.SubsPer.MainActivity;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeActivity extends AppCompatActivity {

    TextView textView;
    Button PerSubsButton, SubsPerButton;

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.unair, R.drawable.unairkecil, R.drawable.danau, R.drawable.ulaz};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button persubs = (Button) findViewById(R.id.PerSubsButton);
        persubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent persubs = new Intent(HomeActivity.this, Main2Activity.class);
                startActivity(persubs);
            }
        });

        Button subsper = (Button) findViewById(R.id.SubsPerButton);
        subsper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent subsper = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(subsper);
            }
        });

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }

    };
}
