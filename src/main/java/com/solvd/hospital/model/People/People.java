package com.solvd.hospital.model.People;

import com.solvd.hospital.model.Room.Reception;

import java.util.Objects;

public abstract class People {
    private String name;
    private String surname;

    public People() {
        this.name = "empty";
        this.surname = "empty";
    }

    public People(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void arrive(Reception reception);

    public abstract void leave();

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(name, people.name) && Objects.equals(surname, people.surname);
    }

    @Override
    public int hashCode() {
        return name.hashCode() * surname.hashCode();
    }
}
