package com.example.proxy;

public class Proxy {
    private SensitiveObject sensitiveObject;
    private String correctPassword;

    public Proxy(SensitiveObject sensitiveObject, String correctPassword) {
        this.sensitiveObject = sensitiveObject;
        this.correctPassword = correctPassword;
    }

    public String accessSecretKey(String password) throws Exception {
        if (password.equals(correctPassword)) {
            return sensitiveObject.getSecretKey();
        } else {
            throw new Exception("Incorrect password!");
        }
    }
}
