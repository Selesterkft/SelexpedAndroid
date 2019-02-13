package com.example.SelexpedAndroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ExampleItem> mExampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();
    }

    public void createExampleList() {

        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem("DKD International Kft.", "24 000 Ft"));
        mExampleList.add(new ExampleItem("Transhungária Kft.", "64 000 000 Ft"));
        mExampleList.add(new ExampleItem("Cégnevetide", "0 000 000 Ft"));
    }

    public void changeItem(int position, String text){

        mExampleList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);

    }

    public void changeVisibility(int position){

        mExampleList.get(position).changeVisibility();
        mAdapter.notifyItemChanged(position);
    }

    public void buildRecyclerView(){

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);
        mAdapter.stOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");
            }
        });

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);



    }
}
