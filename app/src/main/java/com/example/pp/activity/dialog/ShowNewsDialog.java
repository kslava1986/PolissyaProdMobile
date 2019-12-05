package com.example.pp.activity.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pp.R;
import com.example.pp.model.news.News;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ShowNewsDialog extends DialogFragment implements View.OnClickListener{
    private News news;

    public ShowNewsDialog(News news) {
        this.news = news;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.CustomDialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.show_news_dialog, container);

        //todo дорисовать вьюшку
        TextView title = view.findViewById(R.id.news_show_dialog_title);
        TextView text = view.findViewById(R.id.news_show_dialog_text);
        TextView date = view.findViewById(R.id.news_show_dialog_date);
        view.findViewById(R.id.news_show_dialog_close).setOnClickListener(this);

        //todo отформатировать вывод
        title.setText(news.getTitle());
        text.setText(news.getText());
        date.setText(String.valueOf(news.getDate()));

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.news_show_dialog_close) {
            dismiss();
        }
    }
}

