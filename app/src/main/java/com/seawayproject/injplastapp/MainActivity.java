package com.seawayproject.injplastapp;

import android.content.res.TypedArray;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * @author : Alexandr Onuferco
 * @created : 21/11/2021, Sunday
 * This project was created for educational purposes
 * all the referenced works are properties of respected copyright owners
 **/
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<CardItem> cardList;
    private CardItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        cardList = new ArrayList<>();

        mAdapter = new CardItemAdapter(this, cardList);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();
    }

    private void initializeData() {
        String[] titleArray = getResources()
                .getStringArray(R.array.main_titles);
        String[] descArray = getResources()
                .getStringArray(R.array.main_description);
        TypedArray imageResources = getResources()
                .obtainTypedArray(R.array.main_images);

        cardList.clear();

        for(int i=0;i<titleArray.length;i++){
            cardList.add(new CardItem(titleArray[i],descArray[i],
                    imageResources.getResourceId(i,0)));
        }

        imageResources.recycle();
        mAdapter.notifyDataSetChanged();
    }

}