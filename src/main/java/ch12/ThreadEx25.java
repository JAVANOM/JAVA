package ch12;

import javax.xml.namespace.QName;

//동기화
public class ThreadEx25 {
    public static void main(String[] args) {
        RunnableEx101 r = new RunnableEx101();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

    }
}

class Account{
    int balance = 10000;

    public synchronized void withdraw(int money) {
        if(balance >= money) {
            try {
                 Thread.sleep(1000);
            }catch (Exception e) {}

            balance -= money;
        }
    }// withdraw
}

class RunnableEx101 implements Runnable{
    Account acc =  new Account();

    @Override
    public void run() {
        while(acc.balance > 0) {
            int rMoney = (int)(Math.random() * 3 + 1) * 100;
            acc.withdraw(rMoney);
            System.out.println(Thread.currentThread().getName()+" balance : " + acc.balance);
        }
    }
}
