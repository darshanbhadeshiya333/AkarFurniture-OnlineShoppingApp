package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProductCategoryActivity extends AppCompatActivity {

    private ImageView bed, sofa, diningtable;
    private ImageView wardrobe, chair, door;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_category);

        bed = (ImageView)findViewById(R.id.c_bed);
        sofa = (ImageView)findViewById(R.id.c_sofa);
        diningtable = (ImageView)findViewById(R.id.c_diningtable);
        wardrobe = (ImageView)findViewById(R.id.c_wardrobe);
        chair = (ImageView)findViewById(R.id.c_chair);
        door = (ImageView)findViewById(R.id.c_door);

        bed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCategoryActivity.this, CategoryWiseProductsActivity.class);
                intent.putExtra("category","bed");
                startActivity(intent);
            }
        });

        sofa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCategoryActivity.this, CategoryWiseProductsActivity.class);
                intent.putExtra("category","sofa");
                startActivity(intent);
            }
        });

        diningtable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCategoryActivity.this, CategoryWiseProductsActivity.class);
                intent.putExtra("category","diningtable");
                startActivity(intent);
            }
        });

        wardrobe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCategoryActivity.this, CategoryWiseProductsActivity.class);
                intent.putExtra("category","wardrobe");
                startActivity(intent);
            }
        });

        chair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCategoryActivity.this, CategoryWiseProductsActivity.class);
                intent.putExtra("category","chair");
                startActivity(intent);
            }
        });

        door.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCategoryActivity.this, CategoryWiseProductsActivity.class);
                intent.putExtra("category","door");
                startActivity(intent);
            }
        });
    }
}