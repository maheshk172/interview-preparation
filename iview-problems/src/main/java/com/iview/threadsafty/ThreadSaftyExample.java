package com.iview.threadsafty;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSaftyExample {
    public static void main(String[] args) {

        Account account = new Account("Jones", "12345");
        AccountsManager manager = new AccountsManager(account);
        account.setBalance(10000);

        UserRequestHandler andysHandler = new UserRequestHandler(manager);
//        Thread t1 = new Thread(andysHandler);
//        t1.setName("Andy");
//        t1.start();

        UserRequestHandler janesHandler = new UserRequestHandler(manager);
//        Thread t2 = new Thread(janesHandler);
//        t2.setName("Jane");
//        t2.start();

        PrintHandler printHandler = new PrintHandler(manager);
//        Thread t3 = new Thread(printHandler);
//        t3.start();

        DoublerHandler doublerHandler = new DoublerHandler(manager);
//        Thread t4 = new Thread(doublerHandler);
//        t4.start();

        ExecutorService executor = Executors.newScheduledThreadPool(4);
        executor.execute(andysHandler);
        executor.execute(andysHandler);
        executor.execute(andysHandler);
        executor.execute(janesHandler);
        executor.execute(janesHandler);
        executor.execute(janesHandler);
        executor.execute(printHandler);
        executor.execute(doublerHandler);


    }
}

class PrintHandler implements Runnable {
    AccountsManager manager;

    public PrintHandler(AccountsManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                manager.print("Test Message from : " + Thread.currentThread().getName(), 10);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}

class DoublerHandler implements Runnable {
    AccountsManager manager;

    public DoublerHandler(AccountsManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ": doubled " + i + " to " + manager.getDouble(i));
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}

class UserRequestHandler implements Runnable {
    AccountsManager manager;

    public UserRequestHandler(AccountsManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {

        while (true) {
            try {
                this.manager.widthraw(Thread.currentThread().getName(), 1000);
                Thread.sleep(6000);

            } catch (LowBalanceException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + " => No more money left in account, cant widthraw");
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}


class AccountsManager {

    Account account;

    public AccountsManager(Account account) {
        this.account = account;
    }

    public synchronized void  widthraw(String user, double amount) throws LowBalanceException, InterruptedException {
        //synchronized (this) {
        System.out.println("User: " + user + " => requesting widrawable of " + amount);
        System.out.println("User: " + user + " => Current Available balance : " + account.getBalance());
        if (account.getBalance() > amount) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("User: " + user + " => Widrawing : " + amount);
            System.out.println("User: " + user + " => New Balance : " + account.getBalance());

            Thread.sleep(10000);

        } else {
            throw new LowBalanceException("User: " + user + " => No Sufficient Balance for account: " + account.toString() + ", is ");
        }

        System.out.println("User: " + user + " => Amount: " + amount + ", widthrawn");
        //}
    }

    public synchronized int getDouble(int number) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
        }
        return number * 2;
    }

    public synchronized void print(String message, int n) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            System.out.println(i + ": " + message);
            Thread.sleep(1000);
        }
    }

}

class Account {
    private final String custName;
    private final String custId;
    private double balance = 0;

    Account(String custName, String custId) {
        this.custName = custName;
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public String getCustId() {
        return custId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class LowBalanceException extends Exception {

    public LowBalanceException(String s) {
        super(s);
    }
}

class User {
    final String name;

    User(String name) {
        this.name = name;
    }
}