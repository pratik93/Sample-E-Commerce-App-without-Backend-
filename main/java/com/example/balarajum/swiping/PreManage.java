package com.example.balarajum.swiping;


import android.content.Context;
import android.content.SharedPreferences;

public class PreManage {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;
    private  static  final String PREF_NAME = "Rx Welcome";
    private static final String IS_FIRST_LAUCNH = "is first time launch";
    public  PreManage(Context context){
        this._context=  context;
        pref = _context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = pref.edit();

    }

    public void setIsFirstLaucnh(boolean isFirstTime){
        editor.putBoolean(IS_FIRST_LAUCNH,isFirstTime);
        editor.commit();
    }
    public boolean isFirstTimeLaunch(){
        return pref.getBoolean(IS_FIRST_LAUCNH,true);
    }
}
