package ru.praktikum;

public class Praktikum {
    public static void main(String[] args) {
        Account account = new Account(args.toString());
        account.checkNameToEmboss();
    }
}
