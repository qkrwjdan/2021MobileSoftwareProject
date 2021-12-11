package com.example.finalproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView myPicture;
        TextView myText;

        MyViewHolder(View view) {
            super(view);
            myPicture = view.findViewById(R.id.imageView);
            myText = view.findViewById(R.id.textView);
        }
    }

    private ArrayList<Items.Item> myItemList;
    MyAdapter(ArrayList<Items.Item> items){
        this.myItemList = items;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        final int imageId = myItemList.get(position).getImageID();
        final int imageId2 = myItemList.get(position).getImageID2();

        myViewHolder.myPicture.setImageResource(imageId);
        myViewHolder.myText.setText(myItemList.get(position).getImageName());

        myViewHolder.myText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context,DetailViewActivity.class);
                intent.putExtra("name",myItemList.get(position).getImageName());
                intent.putExtra("url",myItemList.get(position).getImageURL());
                intent.putExtra("description",myItemList.get(position).getItemDescription());
                intent.putExtra("imageResource", imageId);
                intent.putExtra("imageResource2", imageId2);
                intent.putExtra("price", myItemList.get(position).getPrice());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myItemList.size();
    }
}
