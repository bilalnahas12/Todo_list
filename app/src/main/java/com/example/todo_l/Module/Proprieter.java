package com.example.todo_l.Module;

public enum Proprieter {
    URGENT,MOYENNE,SIMPLE;
    public static String[] getStringValues() {
        Proprieter[] values = values();
        String[] stringValues = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            stringValues[i] = values[i].toString();
        }
        return stringValues;
    }
}
