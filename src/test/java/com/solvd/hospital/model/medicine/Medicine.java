package com.solvd.hospital.model.medicine;

import java.util.Objects;

public class Medicine {
    private String name;


    public Medicine() {
        this.name = "unknown";
    }

    public Medicine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\n Name=" + name
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(name, medicine.name);
    }

    @Override
    public int hashCode() {
        int num = 31;
        int res = 1;
        res = (num * res) + ((name == null) ? name.hashCode() : 0);
        return res;
    }
}
