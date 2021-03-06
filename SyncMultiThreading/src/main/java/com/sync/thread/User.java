package com.sync.thread;

import org.apache.commons.logging.Log;

public class User {
    private int id;
    private String name;
    private Integer balance;
    private final Log logger = LoggerHelperUtils.getLog(User.class);

    public User() {
        this.balance = 1000;
    }

    public User(int id, String name, Integer balance) {

        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public synchronized void transfer(int amountToTransfer, User target) {
        if (this.balance == 0 || this.balance < amountToTransfer) {
            logger.info("Số tiền trong tài khoản " + this.name + " không đủ!(" + this.balance + ")");

        } else {
            logger.info("Giao dịch rút tiền từ " + this.name + " sang " + target.getName()
                    + " đang được thực hiện với" + " số tiền = " + amountToTransfer + "...");
            this.balance -= amountToTransfer;
            logger.info("Rút tiền thành công. Số tiền hiện có trong tài khoản " + this.name + " = " + balance);
            target.deposit(amountToTransfer);
        }

    }

    public void deposit(int amountToTransfer) {

        logger.info("Giao dịch nộp tiền " + this.name + " đang được thực hiện với" + " số tiền nộp = "
                + amountToTransfer + "...");
        balance += amountToTransfer;
        logger.info("Nộp tiền " + amountToTransfer + " thành công. \nSố tiền hiện có trong tài khoản " + this.name
                + " = " + balance);
    }
}
