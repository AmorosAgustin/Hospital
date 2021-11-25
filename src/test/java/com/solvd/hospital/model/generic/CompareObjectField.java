package com.solvd.hospital.model.generic;

import java.lang.reflect.Field;

public class CompareObjectField<U> {

    public boolean compareField(U ob1, U ob2, String field) {
        try {
            Field field1 = ob1.getClass().getDeclaredField(field);
            Field field2 = ob2.getClass().getDeclaredField(field);

            field1.setAccessible(true);
            field2.setAccessible(true);

            Object value1 = field1.get(ob1);
            Object value2 = field2.get(ob2);

            return value1 == value2;


        } catch (NoSuchFieldException | IllegalAccessException e) {
            try {
                Field field1 = ob1.getClass().getSuperclass().getDeclaredField(field);
                Field field2 = ob2.getClass().getSuperclass().getDeclaredField(field);

                field1.setAccessible(true);
                field2.setAccessible(true);

                Object value1 = field1.get(ob1);
                Object value2 = field2.get(ob2);

                return value1 == value2;
            } catch (NoSuchFieldException | IllegalAccessException f) {
                f.printStackTrace();
            }
        }


        return false;

    }
}

