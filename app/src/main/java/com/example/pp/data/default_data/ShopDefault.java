package com.example.pp.data.default_data;

import com.example.pp.models.Address;
import com.example.pp.models.Shop;
import com.example.pp.models.WorkTime;

import java.util.ArrayList;
import java.util.List;

public class ShopDefault {
    private ShopDefault() {
    }

    public static final List<Shop> SHOPS = new ArrayList<>();

    static {
        SHOPS.add(new Shop("shop_1",
                new Address("Adress_name_1", 1),
                12345,
                new WorkTime(8, 0, 22, 0)));
        SHOPS.add(new Shop("shop_2",
                new Address("adress_name_2", 2),
                123456789,
                new WorkTime(8, 0, 22, 0)));
        SHOPS.add(new Shop("shop_3",
                new Address("adress_name_3", 3),
                123456789,
                new WorkTime(8, 0, 22, 0)));
        SHOPS.add(new Shop("shop_4",
                new Address("adress_name_4", 4),
                123456789,
                new WorkTime(9, 0, 23, 0)));
        SHOPS.add(new Shop("shop_5",
                new Address("adress_name_5", 5),
                123456789,
                new WorkTime(8, 0, 22, 0)));
        SHOPS.add(new Shop("shop_6",
                new Address("adress_name_6", 6),
                123456789,
                new WorkTime(9, 0, 23, 0)));
        SHOPS.add(new Shop("shop_7",
                new Address("adress_name_7", 7),
                123456789,
                new WorkTime(8, 0, 22, 0)));
        SHOPS.add(new Shop("shop_8",
                new Address("adress_name_8", 8),
                123456789,
                new WorkTime(9, 0, 23, 0)));
        SHOPS.add(new Shop("shop_9",
                new Address("adress_name_9", 9),
                123456789,
                new WorkTime(8, 0, 22, 0)));
        SHOPS.add(new Shop("shop_10",
                new Address("adress_name_10", 10),
                123456789,
                new WorkTime(9, 0, 23, 0)));
    }
}
