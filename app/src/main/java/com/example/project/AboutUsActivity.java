package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {

    private TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        text1 = findViewById(R.id.about_text2);
        text2 = findViewById(R.id.about_text4);

        text1.setText("We, AKAR FURNITURE PVT. LTD are a well-known organization engaged in Interior Designing, Turnkey Interior Contracting, Custom Furniture - modular Furniture Manufacturer and Suppliers of a wide array of Office, Home,and Showroom Furniture.\n" +
                "\n" +
                "We have a modern manufacturing facility, which helps us in fabricating all our products at par with international quality standards. Our facility is equipped with latest machinery and technology that enable us to customize our product range as per clients' demands.\n" +
                "\n" +
                "All our products & services have gained appreciation from the customers due to their durability, aesthetic designs, sophisticated look, seamless finish and smooth edges. These products are available in different designs, shapes and sizes to fulfill the diverse requirements of our clients. Apart from this, our team of expert professionals helps us in making the space for us in the hearts of our clients by providing them the consignments within the stipulated time frame.\n" +
                "\n" +
                "Under the auspices of our owner, AKAR FURNITURE PVT.LTD. who has vast experience in this field, we have been setting new standards for success. His ethical business practices, sound strategies and customer centric approaches have enabled us to muster a huge client base across the nation.");

        text2.setText("We have an in house state of the art manufacturing facility, which is sprawled over a vast area of land. Our unit is well equipped with latest technology, machines, tools and instruments that are needed for crafting a wide collection of office, Home and showroom Furniture. This unit is managed by a team of production personnel, which has years of experience in this domain. Moreover, our team uses all the available resources for carrying our fast and smooth production process.");
    }
}