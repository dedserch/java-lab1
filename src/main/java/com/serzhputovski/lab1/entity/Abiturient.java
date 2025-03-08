package com.serzhputovski.lab1.entity;

public class Abiturient {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private String phone;
    private int grade;

    public Abiturient(int id, String surname, String name, String patronymic, String address, String phone, int grade) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }


    public String getPatronymic() {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getGrade() {
        return grade;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Abiturient{");
        sb.append("id=").append(id);
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", name=").append(name);
        sb.append(", patronymic='").append(patronymic).append('\'');
        sb.append(", address=").append(address);
        sb.append(", phone=").append(phone);
        sb.append(", grade=").append(grade);
        sb.append('}');
        return sb.toString();
    }
}
