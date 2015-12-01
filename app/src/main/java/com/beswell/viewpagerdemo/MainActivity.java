package com.beswell.viewpagerdemo;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    public TextView tab1;
    public TextView tab2;
    public TextView tab3;

    public ViewPager vp;
    public List<View> lv;
    public ViewPagerAdapter vpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab1 = (TextView)findViewById(R.id.tab1);
        tab2 = (TextView)findViewById(R.id.tab2);
        tab3 = (TextView)findViewById(R.id.tab3);

        vp = (ViewPager)findViewById(R.id.vp);

        tab1.setOnClickListener(new TabOnClickListener(0));
        tab2.setOnClickListener(new TabOnClickListener(1));
        tab3.setOnClickListener(new TabOnClickListener(2));


        initViewPager();
    }

    void initViewPager(){
        lv = new ArrayList<View>();
        LayoutInflater mLayoutInflater = getLayoutInflater();
        lv.add(mLayoutInflater.inflate(R.layout.viewpager_layout_1, null));
        lv.add(mLayoutInflater.inflate(R.layout.viewpager_layout_2, null));
        lv.add(mLayoutInflater.inflate(R.layout.viewpager_layout_3, null));
        vpa = new ViewPagerAdapter(lv, this);
        vp.setAdapter(vpa);
    }

    public class TabOnClickListener implements View.OnClickListener{
        private int index = 0;

        public TabOnClickListener(int index){
            this.index = index;
        }

        @Override
        public void onClick(View v) {
            vp.setCurrentItem(index);
        }
    }

}
