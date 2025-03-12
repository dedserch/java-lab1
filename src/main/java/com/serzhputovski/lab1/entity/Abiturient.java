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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Abiturient that = (Abiturient) o;

        if (id != that.id) return false;
        if (grade != that.grade) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (patronymic != null ? !patronymic.equals(that.patronymic) : that.patronymic != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        return phone != null ? phone.equals(that.phone) : that.phone == null;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + grade;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Abiturient{");
        sb.append("id=").append(id);
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", patronymic='").append(patronymic).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", grade=").append(grade);
        sb.append('}');
        return sb.toString();
    }
}
