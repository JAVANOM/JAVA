package ch12;

import javax.swing.*;

public class ThreadEx7 {
    public static void main(String[] args) throws Exception {
        ThreadEx7_1 th1 = new ThreadEx7_1();

        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");

    }
}

// 멀티 쓰레드 : Thread 클래스를 상속하거나, Runnable 인터페이스를 구현
class ThreadEx7_1 extends Thread {
    public void run(){
        for (int i = 10; i > 0; i--) {
            System.out.print(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
