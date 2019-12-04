package com.example.pp.service.imp;

import android.content.Context;

import com.example.pp.data.AddressRepositoryLite;
import com.example.pp.data.ShopRepositoryLite;
import com.example.pp.data.WorkTimeRepositoryLite;
import com.example.pp.data.imp.address.AddressRepositoryImp;
import com.example.pp.data.imp.shop.ShopRepositoryLiteImp;
import com.example.pp.data.imp.worktime.WorkTimeRepositoryLiteImp;
import com.example.pp.model.shop.Address;
import com.example.pp.model.shop.Shop;
import com.example.pp.model.shop.WorkTime;
import com.example.pp.service.ShopService;

import java.util.List;

public class ShopServiceImp implements ShopService {
    private ShopRepositoryLite shopRepository;
    private AddressRepositoryLite addressRepository;
    private WorkTimeRepositoryLite workTimeRepository;

    public ShopServiceImp(Context context) {
        this.shopRepository = new ShopRepositoryLiteImp(context);
        this.addressRepository = new AddressRepositoryImp(context);
        this.workTimeRepository = new WorkTimeRepositoryLiteImp(context);
    }

    @Override
    public void save(Shop shop) {
        if(shop.getId() != null){
            update(shop);
        }

        int newId = shopRepository.save(shop);
        Address address = shop.getAddress();
        address.setIdShop(newId);
        addressRepository.save(address);
        WorkTime workTime = shop.getWorkTime();
        workTime.setIdShop(newId);
        workTimeRepository.save(workTime);
    }

    @Override
    public void saveAll(List<Shop> shops) {
        for(Shop shop : shops){
            save(shop);
        }
    }

    @Override
    public void update(Shop shop) {
        shopRepository.update(shop);
        addressRepository.update(shop.getAddress());
        workTimeRepository.update(shop.getWorkTime());
    }

    @Override
    public List<Shop> getAll() {
        List<Shop> shops = shopRepository.getAll();

        for(Shop shop : shops){
            shop.setAddress(addressRepository.get(shop.getId()));
            shop.setWorkTime(workTimeRepository.get(shop.getId()));
        }

        return shops;
    }
}
