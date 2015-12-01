package com.beswell.viewpagerdemo;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by beswell10 on 2015/12/1.
 */
public class ViewPagerAdapter extends PagerAdapter {

    public List<View> mListView;
    public Context context;

    public ViewPagerAdapter(List<View> listView, Context context){
        this.mListView = listView;
        this.context = context;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mListView.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mListView.get(position), 0);
        return mListView.get(position);
    }

    @Override
    public int getCount() {
        return mListView.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }
}
