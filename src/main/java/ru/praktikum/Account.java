package ru.praktikum;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if(name != null &&
           name.length() >= 3 &&
           name.length() <= 19 &&
           !name.startsWith(" ") &&
           !name.endsWith(" ") &&
           name.replaceAll("[^ ]", "").length() == 1) {
            return true;
        }
        return false;
    }
}
