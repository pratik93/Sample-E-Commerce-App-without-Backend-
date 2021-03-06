package com.example.balarajum.swiping;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WelcomeActivity extends Activity {

    private ViewPager viewPager;
    private  MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private  int[] layouts;
    private Button btnskip ,btnNext;
    private  PreManage preManage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preManage = new PreManage(this);

        if(Build.VERSION.SDK_INT>=21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_welcome);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        btnNext = (Button) findViewById(R.id.btn_next);
        btnskip = (Button) findViewById(R.id.btn_Skip);

        layouts =  new int[]{
                R.layout.slide1,
                R.layout.slide2,
                R.layout.slide3,
                R.layout.slide4
        };
        addBottomDots(0);
        changeStatusBarColor();
        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        btnskip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                launchHomeScreen();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int current = getItem(+1);
                if (current < layouts.length) {
                    viewPager.setCurrentItem(current);
                } else {
                    launchHomeScreen();
                }

            }
        });
    }

    public void addBottomDots(int currentPage){
        dots = new TextView[layouts.length];
        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInActive = getResources().getIntArray(R.array.array_dot_inactive);
        dotsLayout.removeAllViews();
        for(int i= 0;i<dots.length;i++){
            dots[i]= new TextView(this);
            dots[i].setText("");
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInActive[currentPage]);
            dotsLayout.addView(dots[i]);
        }
        if(dots.length > 0){
            dots[currentPage].setTextColor(colorsActive[currentPage]);}
    }

    private int getItem(int i ){
        return viewPager.getCurrentItem()+i;
    }
    private void launchHomeScreen(){
        preManage.setIsFirstLaucnh(false);
        startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
        finish();
    }
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener(){
        @Override
        public  void onPageSelected(int position){
            addBottomDots(position);
            if(position == layouts.length-1){
                btnNext.setText(getString(R.string.start));
                btnskip.setVisibility(View.GONE);
            }else{
                btnNext.setText(getString(R.string.next));
                btnskip.setVisibility(View.VISIBLE);
            }
        }
        @Override
        public  void onPageScrolled(int arg0,float arg1,int arg2){

        }
        @Override
        public void onPageScrollStateChanged(int arg0){

        }
    };
    private void changeStatusBarColor(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
    public class MyViewPagerAdapter extends PagerAdapter{
        private LayoutInflater layoutInflater;
        public MyViewPagerAdapter(){

        }
        @Override
        public  Object instantiateItem(ViewGroup container,int position){
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(layouts[position],container,false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount(){
            return layouts.length;
        }
        @Override
        public  boolean isViewFromObject(View view,Object bj){
            return  view == bj;
        }
        @Override
        public void destroyItem(ViewGroup container,int position ,Object object){
            View view = (View) object;
            container.removeView(view);
        }
    }
}
