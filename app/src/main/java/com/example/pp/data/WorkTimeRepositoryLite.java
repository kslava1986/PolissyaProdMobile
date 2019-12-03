package com.example.pp.data;

import com.example.pp.models.WorkTime;

public interface WorkTimeRepositoryLite {
    void save(WorkTime workTime);
    void delete(WorkTime workTime);
    void update(WorkTime workTime);
    WorkTime get(int idShop);
}
