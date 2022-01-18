package ru.praktikum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private final String name;
    private static final String NAME_PATTERN = "^(?=[\\S\\s]{3,19}$)[\\S]+[\\s][\\S]+";
    private static final Pattern pattern = Pattern.compile(NAME_PATTERN);

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if (name == null) return false;
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
