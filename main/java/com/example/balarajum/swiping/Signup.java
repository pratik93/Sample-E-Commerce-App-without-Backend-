package com.example.balarajum.swiping;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by balaraju.m on 9/5/2017.
 */

public class Signup extends Activity {
    private Button btn;
    private EditText fn,ln,em,pd,cpd;
    private TextView t1;
    private Context context = this;
    @Override
    protected void onCreate(Bundle signup){
        super.onCreate(signup);
        setContentView(R.layout.signup);
        Typeface icontype = Typeface.createFromAsset(getAssets(),"fontawesome-webfont.ttf");
        fn = (EditText) findViewById(R.id.fname);
        ln=(EditText) findViewById(R.id.lname);
        em=(EditText) findViewById(R.id.email);
        pd=(EditText) findViewById(R.id.pwd);
        cpd=(EditText) findViewById(R.id.confmpwd);
        t1= (TextView) findViewById(R.id.text12);
        fn.setTypeface(icontype);
        ln.setTypeface(icontype);
        em.setTypeface(icontype);
        pd.setTypeface(icontype);
        cpd.setTypeface(icontype);
        t1.setTypeface(icontype);
        clickSingup();
    }
    private void clickSingup(){
        btn = (Button) findViewById(R.id.mysign);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sinup = new Intent(context,MainActivity.class);
                startActivity(sinup);
            }
        });
    }
}
