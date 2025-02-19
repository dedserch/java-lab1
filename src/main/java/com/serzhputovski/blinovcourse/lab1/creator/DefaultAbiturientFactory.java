package com.serzhputovski.blinovcourse.lab1.creator;

import com.serzhputovski.blinovcourse.lab1.entity.Abiturient;

public class DefaultAbiturientFactory extends AbiturientFactory {
    @Override
    public Abiturient createAbiturient() {
        return new Abiturient(
                1,
                "Иванов",
                "Иван",
                "Иванович",
                "ул. Ленина, д.1",
                "123456789",
                95
        );
    }
}
