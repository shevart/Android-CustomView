package com.shevart.customview.screens.main.mainviewslist;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.shevart.customview.screens.common.BaseRVAdapter;

public class MainViewsRVAdapter extends BaseRVAdapter {

    @Override
    protected int getChildAdapterItemsCount() {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

}
