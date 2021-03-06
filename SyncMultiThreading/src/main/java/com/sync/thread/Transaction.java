package com.sync.thread;

import org.apache.commons.logging.Log;


import java.util.List;

public class Transaction implements Runnable {
    User sender;
    User target;
    Integer amountToTransfer;
    private final Log logger = LoggerHelperUtils.getLog(Transaction.class);

    public Transaction() {
    }

    public Transaction(User sender, User target) {

        this.sender = sender;
        this.target = target;
    }

    public Transaction(User sender, List<User> users, Integer amountToTransfer) {

        this.sender = sender;
        this.amountToTransfer = amountToTransfer;
        User temp;

        do {
            temp = RandomUtil.randomAccount(users);
            if (temp.getId() != sender.getId()) {
                this.target = temp;
            }

        } while (temp.getId() == sender.getId());
    }

    @Override
    public void run() {
        logger.info(Thread.currentThread().getName() + " Starting process " + sender.getName() + " to "
                + target.getName() + ": " + amountToTransfer);
        transferMoney();
        logger.info(Thread.currentThread().getName() + " Finished process " + sender.getName() + " to "
                + target.getName() + ": " + amountToTransfer);
    }

    public void transferMoney() {
        sender.transfer(amountToTransfer, target);
    }

}
