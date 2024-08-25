package ch12;

public class ThreadEx9 {
    public static void main(String[] args) {

        ThreadEx9_1 th1 = new ThreadEx9_1();
        ThreadEx9_2 th2 = new ThreadEx9_2();
        //main 메서드를 수행하는 쓰레드는 우선순위가 5이므로 main메서드 내에서 생성하는 쓰레드의 우선순위는 자동으로 5
        //우선순위가 1정도 차이는 다른게 없음
        th2.setPriority(8);

        System.out.println("Priority of th1(-) : " + th1.getPriority() );
        System.out.println("Priority of th1(|) : " + th2.getPriority() );

        th1.start();
        th2.start();
    }
}

class ThreadEx9_1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
    }
}

class ThreadEx9_2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
        }
    }
}
