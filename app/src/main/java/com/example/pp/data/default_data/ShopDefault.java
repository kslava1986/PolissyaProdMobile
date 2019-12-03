package com.example.pp.data.default_data;

import com.example.pp.models.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopDefault {
    private ShopDefault() {
    }

    public static final List<Shop> SHOPS = new ArrayList<>();

    static {
        SHOPS.add(new Shop("shop_1", "tel_shop_1"));
        SHOPS.add(new Shop("shop_2", "tel_shop_2"));
        SHOPS.add(new Shop("shop_3", "tel_shop_3"));
        SHOPS.add(new Shop("shop_4", "tel_shop_4"));
        SHOPS.add(new Shop("shop_5", "tel_shop_5"));
        SHOPS.add(new Shop("shop_6", "tel_shop_6"));
        SHOPS.add(new Shop("shop_7", "tel_shop_7"));
        SHOPS.add(new Shop("shop_8", "tel_shop_8"));
        SHOPS.add(new Shop("shop_9", "tel_shop_9"));
        SHOPS.add(new Shop("shop_10", "tel_shop_10"));
    }
}
