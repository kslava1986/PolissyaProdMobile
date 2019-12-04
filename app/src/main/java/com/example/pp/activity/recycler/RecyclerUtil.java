package com.example.pp.activity.recycler;

import android.app.Activity;

import com.example.pp.R;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerUtil {

    private RecyclerUtil() {
    }

    public static RecyclerView createRecycler(Activity activity){
        RecyclerView recyclerView = activity.findViewById(R.id.recyclerview_fragment_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        return recyclerView;
    }
}
