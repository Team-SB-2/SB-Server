package com.example.sbserver.global.util.password;

import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {
    private static final int PASSWORD_LENGTH = 10;

    public String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        StringBuilder passwordBuilder = new StringBuilder();

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int randomIndex = (int) (Math.random() * characters.length());
            passwordBuilder.append(characters.charAt(randomIndex));
        }

        return passwordBuilder.toString();
    }
}
