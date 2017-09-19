package com.example.balarajum.swiping;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Selection_one extends Activity {
    private ImageView img;
    private Button btn;
    private final Context context = this;
    String[] listTitle = new String[]{
            "Item Name","Item Name","Item Name","Item Name","Item Name",
            "Item Name","Item Name","Item Name","Item Name","Item Name",
    };
    String[] listDesc = new String[]{
            "Item Description Here","Item Description Here","Item Description Here","Item Description Here","Item Description Here",
            "Item Description Here","Item Description Here","Item Description Here","Item Description Here","Item Description Here",
    };
    int[] listImage = new int[]{
            R.drawable.onee,R.drawable.onee,R.drawable.onee,R.drawable.onee,R.drawable.onee,
            R.drawable.onee,R.drawable.onee,R.drawable.onee,R.drawable.onee,R.drawable.onee,
    };
    @Override
    protected void onCreate(Bundle one) {
        super.onCreate(one);
        setContentView(R.layout.list_one);
        user_selection();
        btn = (Button) findViewById(R.id.one_btn);
    }
    private void user_selection() {

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 10; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listTitle[i]);
            hm.put("listview_description", listDesc[i]);
            hm.put("listview_image", Integer.toString(listImage[i]));
            aList.add(hm);
        }
        String[] from = {"listview_image", "listview_title", "listview_description"};
        int[] to = {R.id.list_view_image, R.id.list_view_item_title, R.id.list_view_item_desc};
        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.list_view_one, from, to);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(simpleAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options,menu);
        return true;
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
        Intent in = new Intent(context,UserProfile.class);
        startActivity(in);
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
}

