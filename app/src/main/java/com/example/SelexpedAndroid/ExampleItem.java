package com.example.SelexpedAndroid;

import android.widget.Button;

public class ExampleItem {
    private String mText1;
    private String mText2;
    private Button mButton1;

    public ExampleItem(String text1, String text2){
        mText1=text1;
        mText2=text2;
    }

    public void changeVisibility() {
        if (mButton1.getVisibility() == Button.GONE) {
            mButton1.setVisibility(Button.VISIBLE);
        } else {
            mButton1.setVisibility(Button.GONE);
        }
    }

    public void changeText1(String text) {
        mText1 = text;
    }

    public String getmText1(){
        return mText1;
    }

    public String getmText2(){
        return mText2;
    }
}
