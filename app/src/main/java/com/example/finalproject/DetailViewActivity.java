package com.example.finalproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailViewActivity extends AppCompatActivity {
    ImageView detailImage;
    ImageView detailImage2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_view);
        Intent intent = getIntent();

        final String name = intent.getExtras().getString("name");
        String url = intent.getExtras().getString("url");
        String description = intent.getExtras().getString("description");
        int imageResource = intent.getExtras().getInt("imageResource");
        int imageResource2 = intent.getExtras().getInt("imageResource2");
        int price = intent.getExtras().getInt("price");

        detailImage = (ImageView)findViewById(R.id.imageView2);
        detailImage.setImageResource(imageResource);

        detailImage2 = (ImageView)findViewById(R.id.imageView3);
        detailImage2.setImageResource(imageResource2);

        TextView nameTextView = (TextView)findViewById(R.id.itemName);
        nameTextView.setText(name);

        TextView descriptionTextView = (TextView)findViewById(R.id.itemDescription);
        descriptionTextView.setText(description);

        TextView priceTextView = (TextView)findViewById(R.id.price);
        priceTextView.setText(price + "원");

        TextView urlTextView = (TextView)findViewById(R.id.websiteTextView);
        urlTextView.setText((url));

        Button mailBtn = (Button)findViewById(R.id.emailBtn);
        mailBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                sendEmail(name + " 관련 메일입니다." );
            }
        });

        Button telBtn = (Button)findViewById(R.id.telBtn);
        telBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01089101717"));
                startActivity(intent);
            }
        });

        Button locationBtn = (Button)findViewById(R.id.locationBtn);
        locationBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context,GoogleMapsActivity.class);
                context.startActivity(intent);
            }
        });

    }

    protected void sendEmail(String text) {
        String[] TO = {"madogisa12@naver.com"};
        String[] CC = {""};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, text);
        emailIntent.putExtra(Intent.EXTRA_TEXT, "내용을 입력해주세요.");

        try {
            startActivity(Intent.createChooser(emailIntent,
                    "이메일 보내기..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex)
        {
            Toast.makeText(DetailViewActivity.this, "이메일 클라이언트가 없네요.", Toast.LENGTH_SHORT).show();
        }
    }
}
