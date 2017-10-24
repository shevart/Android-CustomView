package com.shevart.customview.customviews;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

    @LayoutRes
    protected abstract int provideLayoutResId();

    protected abstract void bindView(@NonNull View view);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(provideLayoutResId(), container, false);
        bindView(view);
        return view;
    }
}