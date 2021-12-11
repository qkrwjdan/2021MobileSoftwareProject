package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);

        ArrayList<Items.Item> ItemsInfo = new ArrayList<>();
        ItemsInfo.add(new Items.Item(R.drawable.apple_watch, R.drawable.apple_watch2,"애플워치", "https://www.apple.com/kr/shop/buy-watch/apple-watch-se", "애플워치 입니다.",359000));
        ItemsInfo.add(new Items.Item(R.drawable.imac, R.drawable.imac2, "아이맥", "https://www.apple.com/kr/shop/buy-mac/imac", "아이맥 입니다.",1690000));
        ItemsInfo.add(new Items.Item(R.drawable.ipad, R.drawable.ipad2, "아이패드", "https://www.apple.com/kr/shop/buy-ipad/ipad-10-2", "아이패드 입니다.",449000));
        ItemsInfo.add(new Items.Item(R.drawable.ipad_air, R.drawable.ipad_air2, "아이패드 에어", "https://www.apple.com/kr/shop/buy-ipad/ipad-air", "아이패드 에어 입니다.",779000));
        ItemsInfo.add(new Items.Item(R.drawable.ipad_pro, R.drawable.ipad_pro2, "아이패드 프로", "https://www.apple.com/kr/shop/buy-ipad/ipad-pro", "아이패드 프로 입니다.",999000));
        ItemsInfo.add(new Items.Item(R.drawable.iphone_13, R.drawable.iphone_132, "아이폰13", "https://www.apple.com/kr/shop/buy-iphone/iphone-13", "아이폰 13 입니다.",950000));
        ItemsInfo.add(new Items.Item(R.drawable.iphone_13_pro, R.drawable.iphone_13_pro2, "아이폰13프로", "https://www.apple.com/kr/shop/buy-iphone/iphone-13-pro", "아이폰 13 프로 입니다.",1350000));
        ItemsInfo.add(new Items.Item(R.drawable.iphone_se, R.drawable.iphone_se2, "아이폰se", "https://www.apple.com/kr/shop/buy-iphone/iphone-se", "아이폰 se 입니다.",550000));
        ItemsInfo.add(new Items.Item(R.drawable.mac_mini, R.drawable.mac_mini2, "맥미니", "https://www.apple.com/kr/shop/buy-mac/mac-mini", "맥 미니 입니다.",890000));
        ItemsInfo.add(new Items.Item(R.drawable.mac_pro, R.drawable.mac_pro2, "맥프로", "https://www.apple.com/kr/shop/buy-mac/mac-pro", "맥 프로 입니다.",7899000));

        // 목록을 어댑터에 연결해 준다.
        MyAdapter myAdapter = new MyAdapter(ItemsInfo);
        // 어댑터를 뷰에 연결해 준다.
        myRecyclerView.setAdapter(myAdapter);

    }


}