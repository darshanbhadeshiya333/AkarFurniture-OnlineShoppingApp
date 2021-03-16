package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.project.Model.Products;
import com.example.project.ViewHolder.ProductViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class CategoryWiseProductsActivity extends AppCompatActivity {

    private String CategoryName, category;
    private TextView categoryNameHeading;
    private Query ProductsReference;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_wise_products);

        CategoryName = getIntent().getExtras().get("category").toString();

        categoryNameHeading = findViewById(R.id.category_name_txt);

        recyclerView = findViewById(R.id.recycler_products_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void CheckCategory() {
        if (CategoryName.equals("bed")){
            category = "bed";
            categoryNameHeading.setText("Bed");
        }
        if (CategoryName.equals("sofa")){
            category = "sofa";
            categoryNameHeading.setText("Sofa");
        }
        if (CategoryName.equals("diningtable")){
            category = "diningtable";
            categoryNameHeading.setText("Dining-Table");
        }
        if (CategoryName.equals("wardrobe")){
            category = "wardrobe";
            categoryNameHeading.setText("Wardrobe");
        }
        if (CategoryName.equals("chair")){
            category = "chair";
            categoryNameHeading.setText("Chair");
        }
        if (CategoryName.equals("door")){
            category = "door";
            categoryNameHeading.setText("Door");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        CheckCategory();

        ProductsReference = FirebaseDatabase.getInstance().getReference("Products").orderByChild("category").equalTo(category);

        FirebaseRecyclerOptions<Products> options =
                new FirebaseRecyclerOptions.Builder<Products>()
                        .setQuery(ProductsReference, Products.class)
                        .build();

        FirebaseRecyclerAdapter<Products, ProductViewHolder> adapter =
                new FirebaseRecyclerAdapter<Products, ProductViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull Products model) {

                        holder.txtProductName.setText(model.getPname());
                        holder.txtProductDescription.setText(model.getDescription());
                        holder.txtProductPrice.setText(model.getPrice());
                        Picasso.get().load(model.getImage()).into(holder.imageview);

                        holder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent intent = new Intent(CategoryWiseProductsActivity.this, ProductDetailsActivity.class);
                                intent.putExtra("pid", model.getPid());
                                intent.putExtra("editProductToCart","false");
                                intent.putExtra("fromCategory","yes");
                                startActivity(intent);
                                finish();
                            }
                        });
                    }

                    @NonNull
                    @Override
                    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_items_layout, parent, false);
                        ProductViewHolder holder = new ProductViewHolder(view);
                        return holder;
                    }
                };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }
}