package com.sync.thread;

import java.util.List;
import java.util.Random;

public class RandomUtil {
    public static Integer randomBalance() {
        Random randomGenerator = new Random();
        int upperbound = 1000;
        int testNum = randomGenerator.nextInt(upperbound) + 1;
        return testNum;
    }

    public static User randomAccount(List<User> users) {
        Random randomGenerator = new Random();
        int upperbound = 3;
        int index = randomGenerator.nextInt(upperbound);
        return users.get(index);
    }
}
