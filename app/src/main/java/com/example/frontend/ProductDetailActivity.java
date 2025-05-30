package com.example.frontend;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProductDetailActivity extends AppCompatActivity {

        private ImageView productImage;
        private FrameLayout goldColor, silverColor;
        private ImageView checkGold, checkSilver;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_product_detail);

            productImage = findViewById(R.id.productImage);
            goldColor = findViewById(R.id.goldColor);
            silverColor = findViewById(R.id.silverColor);
            checkGold = findViewById(R.id.checkGold);
            checkSilver = findViewById(R.id.checkSilver);

            goldColor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    productImage.setImageResource(R.mipmap.ic_earring_gold);
                    checkGold.setVisibility(View.VISIBLE);
                    checkSilver.setVisibility(View.GONE);
                }
            });

            silverColor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    productImage.setImageResource(R.mipmap.ic_earring_silver);
                    checkGold.setVisibility(View.GONE);
                    checkSilver.setVisibility(View.VISIBLE);
                }
            });
    }
}