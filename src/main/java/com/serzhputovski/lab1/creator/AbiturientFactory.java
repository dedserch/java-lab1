package com.serzhputovski.lab1.creator;

import com.serzhputovski.lab1.entity.Abiturient;

public interface AbiturientFactory {
    Abiturient createAbiturient(int id, String surname, String name, String patronymic, String address, String phone, int grade);
}
