package com.example.pp.activity.fragment.drawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pp.R;
import com.example.pp.activity.communication.OnSelectItemRecyclerView;
import com.example.pp.activity.dialog.ShowNewsDialog;
import com.example.pp.activity.recycler.RecyclerUtil;
import com.example.pp.activity.recycler.news.NewsAdapter;
import com.example.pp.model.news.News;
import com.example.pp.service.NewsService;
import com.example.pp.service.imp.NewsServiceImp;
import com.example.pp.util.ToastUtil;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class NewsFragment extends Fragment implements OnSelectItemRecyclerView<News> {
    private NewsService newsService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment, container, false);
        newsService = new NewsServiceImp(view.getContext());

        RecyclerView recyclerView = RecyclerUtil.createRecycler(view);
        NewsAdapter adapter = new NewsAdapter(view.getContext(), this, newsService.getAll());
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void selectItem(News obj) {
        //todo тестовый тостер
        ToastUtil.showLongToast(getContext(), "Long Toast \n" + "Select item: \n"
                + "id: " + obj.getId()
                + "\ntitle: " + obj.getTitle());

        ShowNewsDialog dialog = new ShowNewsDialog(obj);
        dialog.show(Objects.requireNonNull(getFragmentManager()), "news");
    }
}
