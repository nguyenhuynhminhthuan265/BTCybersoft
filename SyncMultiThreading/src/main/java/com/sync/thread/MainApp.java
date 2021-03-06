package com.sync.thread;


import org.apache.commons.logging.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;


public class MainApp {
    private static final int NUMBER_TRANSACTION = 1000;
    static Log logger = LoggerHelperUtils.getLog(MainApp.class);

    public static void main(String[] args) {
        Log logger = LoggerHelperUtils.getLog(MainApp.class);
        User user1 = new User(1, "user1", 1000);
        User user2 = new User(2, "user2", 1000);
        User user3 = new User(3, "user3", 1000);
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        users.add(user3);



        long startTime = System.nanoTime();
        ExecutorService threadpool = Executors.newCachedThreadPool();
        for (int i = 0; i < NUMBER_TRANSACTION; i++) {
            threadpool.execute(new Transaction(RandomUtil.randomAccount(users), users, RandomUtil.randomBalance()));
//            threadpool.execute(new Transaction(user1, users, RandomUltil.randomBalance()));

        }
        threadpool.shutdown();
        while (!threadpool.isTerminated()) {

        }

        logger.info("================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>. done");
        logger.info("balance user1: " + user1.getBalance());
        logger.info("balance user2: " + user2.getBalance());
        logger.info("balance user3: " + user3.getBalance());
        logger.info("total balance: " + (user1.getBalance() + user2.getBalance() + user3.getBalance()));
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        logger.info("totalTime: " + totalTime);
    }

}
