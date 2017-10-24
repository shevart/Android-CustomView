package com.shevart.customview.screens.main.mainviewslist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shevart.customview.R;

public class MainViewsListFragment extends Fragment {
    public MainViewsListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_main_views_list, container, false);

        MainViewsRVAdapter adapter = new MainViewsRVAdapter();
        adapter.setTitle(getString(R.string.select_views_topic));
        RecyclerView rvMainViewsList = view.findViewById(R.id.rvMainViewsList);
        rvMainViewsList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMainViewsList.setAdapter(adapter);

        return view;
    }
}