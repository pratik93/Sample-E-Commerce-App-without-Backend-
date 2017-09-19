package com.example.balarajum.swiping;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by balaraju.m on 9/4/2017.
 */

public class UserProfile extends Activity {
    private TextView t1;
    private TextView fb,link,insta,pin;
    private final Context context = this;
    @Override
    protected void onCreate(Bundle profile){
        super.onCreate(profile);
        setContentView(R.layout.profile_page);
        Typeface icontype = Typeface.createFromAsset(getAssets(),"fontawesome-webfont.ttf");
        t1 = (TextView)findViewById(R.id.add_friend);
        t1.setTypeface(icontype);
        fb=(TextView) findViewById(R.id.fb);
        link=(TextView) findViewById(R.id.link);
        insta=(TextView) findViewById(R.id.inst);
        pin=(TextView) findViewById(R.id.pin);
        fb.setTypeface(icontype);
        link.setTypeface(icontype);
        pin.setTypeface(icontype);
        insta.setTypeface(icontype);
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
}
