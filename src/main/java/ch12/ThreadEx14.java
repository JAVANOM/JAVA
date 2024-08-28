package ch12;

public class ThreadEx14 {
    public static void main(String[] args) {
        ThreadEx14_1 th1 = new ThreadEx14_1();
        ThreadEx14_2 th2 = new ThreadEx14_2();

        th1.start();

        try {
            // th1 쓰레드가 종료 될 때까지 메인 쓰레드 대기
            th1.join();
        }catch (Exception e) {}

        // th1 쓰레드가 종료 후 실행
        th2.start();
    }
}

class ThreadEx14_1 extends Thread {
    public void run(){
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
    }
}

class ThreadEx14_2 extends Thread {
    public void run(){
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
        }
    }
}
