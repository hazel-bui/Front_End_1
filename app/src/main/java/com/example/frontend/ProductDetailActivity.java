package com.example.frontend;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

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

    private TextView quantityValue, totalPriceValue;
    private ImageView btnDecrease, btnPlus; // bạn dùng ImageView hay Button thì khai báo tương ứng
    private int quantity = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        productImage = findViewById(R.id.productImage);
        goldColor = findViewById(R.id.goldColor);
        silverColor = findViewById(R.id.silverColor);
        checkGold = findViewById(R.id.checkGold);
        checkSilver = findViewById(R.id.checkSilver);

        quantityValue = findViewById(R.id.quantityValue);
        totalPriceValue = findViewById(R.id.totalPriceValue);
        btnDecrease = findViewById(R.id.btnDecrease);
        btnPlus = findViewById(R.id.btnPlus);

        // Khởi tạo số lượng và giá hiển thị lần đầu
        quantityValue.setText(String.valueOf(quantity));
        updateTotalPrice();

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

        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 1) {
                    quantity--;
                    quantityValue.setText(String.valueOf(quantity));
                    updateTotalPrice();
                }
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                quantityValue.setText(String.valueOf(quantity));
                updateTotalPrice();
            }
        });
    }

    private void updateTotalPrice() {
        int pricePerItem = 150000;
        int totalPrice = pricePerItem * quantity;

        // Định dạng giá như "150.000vnd"
        String priceText = String.format("%,d", totalPrice).replace(',', '.') + "vnd";
        totalPriceValue.setText(priceText);
    }
}