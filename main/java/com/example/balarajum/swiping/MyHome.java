package com.example.balarajum.swiping;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Typeface;
/**
 * Created by balaraju.m on 9/6/2017.
 */

public class MyHome extends Activity {

    private TextView fb,link,insta,pin;
    private ImageView img1,img2,img3,img4,img5,img6,img7,img8;
    private final Context context = this;
    @Override
    protected void onCreate(Bundle hm){
        super.onCreate(hm);
        setContentView(R.layout.homemenu);
        Typeface icontype = Typeface.createFromAsset(getAssets(),"fontawesome-webfont.ttf");
        fb=(TextView) findViewById(R.id.fb);
        link=(TextView) findViewById(R.id.link);
        insta=(TextView) findViewById(R.id.inst);
        pin=(TextView) findViewById(R.id.pin);
        fb.setTypeface(icontype);
        link.setTypeface(icontype);
        pin.setTypeface(icontype);
        insta.setTypeface(icontype);
        user_selection();
    }
    private void showlogin(){
        Intent in = new Intent(context,MainActivity.class);
        startActivity(in);
    }
    private void showhome(){
        Intent in = new Intent(context,MyHome.class);
        startActivity(in);
    }
    private void showprofile(){
        Intent pro = new Intent(context,UserProfile.class);
        startActivity(pro);
    }
    private void showlog(){

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.one:
                showhome();
                return true;
            case R.id.two:
                showprofile();
                return true;
            case R.id.three:
                showlog();
                return true;
            case R.id.four:
                showlogin();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options,menu);
        return true;
    }
    private void user_selection(){
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);
        img6 = (ImageView) findViewById(R.id.img6);
        img7 = (ImageView) findViewById(R.id.img7);
        img8 = (ImageView) findViewById(R.id.img8);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent img_intent = new Intent(context,Selection_one.class);
                startActivity(img_intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent img_intent = new Intent(context,Selection_one.class);
                startActivity(img_intent);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent img_intent = new Intent(context,Selection_one.class);
                startActivity(img_intent);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent img_intent = new Intent(context,Selection_one.class);
                startActivity(img_intent);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent img_intent = new Intent(context,Selection_one.class);
                startActivity(img_intent);
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent img_intent = new Intent(context,Selection_one.class);
                startActivity(img_intent);
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent img_intent = new Intent(context,Selection_one.class);
                startActivity(img_intent);
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent img_intent = new Intent(context,Selection_one.class);
                startActivity(img_intent);
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent img_intent = new Intent(context,Selection_one.class);
                startActivity(img_intent);
            }
        });
    }

}
