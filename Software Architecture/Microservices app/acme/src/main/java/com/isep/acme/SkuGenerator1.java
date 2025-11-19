package com.isep.acme;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SkuGenerator1 {
    public static String generateSku() {
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        Set<String> generatedCodes = new HashSet<>();

        while (generatedCodes.isEmpty()) { // Ensure uniqueness
            for (int i = 0; i < 12; i++) {
                int index = random.nextInt(characters.length());
                code.append(characters.charAt(index));
            }

            if (!generatedCodes.contains(code.toString())) {
                generatedCodes.add(code.toString());
            }
        }

        return code.toString();
    }
}
