package com.example.SelexpedAndroid;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private ArrayList<ExampleItem> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {

        void onItemClick(int position);
    }

    public void stOnItemClickListener(OnItemClickListener listener){

        mListener=listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView1;
        public TextView mTextView2;
        public Button mButton1;


        public ExampleViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.textView1);
            mTextView2 = itemView.findViewById(R.id.textView2);
            mButton1 = itemView.findViewById(R.id.button1);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public ExampleAdapter (ArrayList<ExampleItem> exampleList) {

        mExampleList=exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
       ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
       return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ExampleViewHolder exampleViewHolder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

        exampleViewHolder.mTextView1.setText(currentItem.getmText1());
        exampleViewHolder.mTextView2.setText(currentItem.getmText2());

        exampleViewHolder.mButton1.setVisibility(View.GONE);
        exampleViewHolder.mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exampleViewHolder.mButton1.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
