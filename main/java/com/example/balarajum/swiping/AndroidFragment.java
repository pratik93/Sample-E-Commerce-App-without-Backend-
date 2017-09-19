package com.example.balarajum.swiping;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by balaraju.m on 9/5/2017.
 */

public class AndroidFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        TextView textView = new TextView(container.getContext());
        textView.setText("tab content");
        textView.setGravity(Gravity.CENTER);
        return textView;
    }
}
