package com.example.pp._old;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pp.R;
import com.example.pp._old._service.ShopsService;
import com.example.pp._old._model.Shop;
import com.example.pp.rest.ApiService;
import com.example.pp.rest.NetworkService;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityselectionActivity extends AppCompatActivity {
    private ShopsService mShopService;
    private ShopAdapter mAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cityselection);
        Objects.requireNonNull(getSupportActionBar()).hide();
        // создаем объект для создания и управления версиями БД

        mShopService = new ShopsService(this);

        loadData();
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        TextView textViewTel = (TextView) view.findViewById(R.id.telephone);
                        TextView textViewAddress = (TextView) view.findViewById(R.id.address);
                        Intent intent = new Intent(getApplicationContext(), DialogActivity.class);
                        intent.putExtra("address",textViewAddress.getText().toString());
                        intent.putExtra("tel",textViewTel.getText().toString());
                        intent.putExtra("shopId", "566554564");
                        //mShopService.getShopIdByPosition(); //або
                        //mShopService.getShop(position);
                        //mShopService.getAllItems().get(position).getId();
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        TextView textViewTel = (TextView) view.findViewById(R.id.telephone);
                         dial(textViewTel.getText().toString());
                    }
                })
        );
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ShopAdapter(this, mShopService.getAllItems());
        recyclerView.setAdapter(mAdapter);
        //заповнення бази тестовими даними
        mShopService.saveToBaseDefaultData();

    }


    private void loadData() {
        NetworkService.getInstance()
                .getJSONApi(ApiService.class)
                .getShops()
                .enqueue(new Callback<List<Shop>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Shop>> call, @NonNull Response<List<Shop>> response) {
                        List<Shop> shops = response.body();
                        if (shops != null) {
                            mShopService.saveToBaseData(shops);
                            mAdapter.swapCursor(mShopService.getAllItems());
                            recyclerView.invalidate();
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Завантаження Сервер - ОК!", Toast.LENGTH_SHORT);
                            toast.show();
                        } else {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Завантаження - не відбулось!", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Shop>> call, @NonNull Throwable t) {
                        t.printStackTrace();
                        mShopService.saveToBaseDefaultData();
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Завантаження DefaultData  - ОК!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
    }







    // виклик дзвінка
    public void dial(String tel) {
        Uri uri = Uri.parse(String.format("tel:%s", tel));
        startActivity(new Intent(Intent.ACTION_DIAL, uri));
    }
}
