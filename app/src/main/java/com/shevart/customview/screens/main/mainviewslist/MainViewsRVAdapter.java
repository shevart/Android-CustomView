package com.shevart.customview.screens.main.mainviewslist;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.shevart.customview.screens.common.BaseRVAdapter;

class MainViewsRVAdapter extends BaseRVAdapter {

    @Override
    protected int getChildAdapterItemsCount() {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {

            default:
                return super.onCreateViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {

            default:
                super.onBindViewHolder(holder, position);
        }
    }
}
