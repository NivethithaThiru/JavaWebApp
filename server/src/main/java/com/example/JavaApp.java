package com.example;

public class JavaApp {

    public static String message = "Hello Nivethitha!";
    
    public JavaApp() {}
    public static void main(String[] args) {
        String a = displayMessage();
        System.out.println(a);
    }

    public static String displayMessage()
    {
        return message;
    }
}
