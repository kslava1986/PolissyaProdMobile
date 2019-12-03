package com.example.pp.data;

import com.example.pp.models.Address;

public interface AddressRepositoryLite {
    void save(Address address);
    void update(Address address);
    void delete(Address address);
    Address get(int idShop);
}
