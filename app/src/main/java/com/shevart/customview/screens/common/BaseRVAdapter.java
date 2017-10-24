package com.shevart.customview.screens.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shevart.customview.R;
import com.shevart.customview.utils.UiUtil;

@SuppressWarnings("WeakerAccess")
public abstract class BaseRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected static final int TITLE_ITEM_VIEW_TYPE = 1;

    @Nullable
    private String title; // if title is null or empty we hide title - else we show title

    protected abstract int getChildAdapterItemsCount();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TITLE_ITEM_VIEW_TYPE:
                return new TitleViewHolder(UiUtil.inflate(parent, R.layout.item_rv_title));
            default:
                throw new IllegalArgumentException("Handle it!");
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TITLE_ITEM_VIEW_TYPE:
                //noinspection ConstantConditions
                bindTitle((TitleViewHolder) holder, title);
                break;
            default:
                throw new IllegalArgumentException("Handle it!");
        }
    }

    @Override
    public final int getItemCount() {
        return getChildAdapterItemsCount()
                + (!TextUtils.isEmpty(title) ? 1 : 0);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && !TextUtils.isEmpty(title)) {
            return TITLE_ITEM_VIEW_TYPE;
        }

        throw new IllegalArgumentException("Handle it!");
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    private void bindTitle(@NonNull TitleViewHolder viewHolder, @NonNull String title) {
        viewHolder.tvTitle.setText(title);
    }

    private static class TitleViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;

        TitleViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}