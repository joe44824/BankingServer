package com.oop.banking.backend.util;

import java.util.Random;

public class Helper {
    public static int generateAccId() {
        Random random = new Random();
        return (int) ((random.nextInt() % 900000000000L) + 100000000000L);

    }
}
