package com.serzhputovski.blinovcourse.lab1.creator;

import com.serzhputovski.blinovcourse.lab1.entity.Abiturient;

public class DefaultAbiturientFactory extends AbiturientFactory {
    @Override
    public Abiturient[] createAbiturients() {
        return new Abiturient[] {
                new Abiturient(1, "Serzhputovski", "Dmitry", "Andree", "Mama", "+3752222222", 400),
                new Abiturient(2, "Ivanov", "Ivan", "Ivanovich", "ул. Ленина, д.2", "+3753333333", 380),
                new Abiturient(3, "Petrov", "Petr", "Petrovich", "ул. Ленина, д.3", "+3754444444", 390),
                new Abiturient(4, "Sidorov", "Alexey", "Alexeevich", "ул. Ленина, д.4", "+3755555555", 370),
                new Abiturient(5, "Kuznetsov", "Sergey", "Sergeevich", "ул. Ленина, д.5", "+3756666666", 360),
                new Abiturient(6, "Smirnov", "Nikolay", "Nikolaevich", "ул. Ленина, д.6", "+3757777777", 350),
                new Abiturient(7, "Popov", "Vladimir", "Vladimirovich", "ул. Ленина, д.7", "+3758888888", 340),
                new Abiturient(8, "Vasiliev", "Dmitry", "Dmitrievich", "ул. Ленина, д.8", "+3759999999", 330),
                new Abiturient(9, "Fedorov", "Andrey", "Andreevich", "ул. Ленина, д.9", "+3751010101", 320),
                new Abiturient(10, "Mikhailov", "Mikhail", "Mikhailovich", "ул. Ленина, д.10", "+3752020202", 310)
        };
    }
}
