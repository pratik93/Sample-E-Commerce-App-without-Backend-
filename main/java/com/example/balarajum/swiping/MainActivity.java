package com.example.balarajum.swiping;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Typeface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends Activity {
    private Button log;
    private TextView signup,text12;
    private EditText un, pd;
    private Context context = this;

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_main);
        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(),"fontawesome-webfont.ttf");
        un = (EditText) findViewById(R.id.usernm);
        pd=(EditText) findViewById(R.id.userpwd);
        text12 =(TextView) findViewById(R.id.text12);
        un.setTypeface(fontAwesomeFont);
        pd.setTypeface(fontAwesomeFont);
        text12.setTypeface(fontAwesomeFont);
        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPageAndroid);
        ImageAdapter adapterView = new ImageAdapter(this);
        mViewPager.setAdapter(adapterView);
        startLogin();
        signup=  (TextView) findViewById(R.id.sign);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signintent = new Intent(context,Signup.class);
                startActivity(signintent);
            }
        });
    }
    private void  logOntoHome(){
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,MyHome.class);
                startActivity(intent);
            }
        });
    }
    public void startLogin(){
        log = (Button) findViewById(R.id.log);
        un = (EditText) findViewById(R.id.usernm);
        pd=(EditText) findViewById(R.id.userpwd);
        un.addTextChangedListener(mTextWatcher);
        pd.addTextChangedListener(mTextWatcher);
        checkValues();
    }

    private void checkValues() {
        final String user = un.getText().toString();
        final String pass = pd.getText().toString();
        if (user.equals("")) {
            log.setEnabled(false);
        }
        if (pass.equals("")) {
            log.setEnabled(false);
        } else {
            log.setEnabled(true);
            log.setBackgroundColor(Color.parseColor("#a854d4"));
            logOntoHome();

        }
    }
    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            checkValues();
        }
    };
}