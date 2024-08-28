package ch12;

public class ThreadEx13 {
    static long startTime = 0;
    public static void main(String[] args) throws InterruptedException {
         ThreadEx13_1 th1 = new ThreadEx13_1();
         ThreadEx13_2 th2 = new ThreadEx13_2();

         Thread th3 = new Thread(() -> {
             for (int i = 0; i < 300; i++) {
                 System.out.print(">");
             }
         });
         //세 개의 스레드가 비동기적으로 실행 -> 이 때 메인 스레드는 두 스레드의 작업이 끝나기를 기다리지 않고 다음코드를 진행
         th1.start();
         th2.start();
         th3.start();
         startTime = System.currentTimeMillis();

         // join()을 사용하지 않으면 메인 스레드가 자식 스레드의 작업이 완료되기를 기다리지 않고 바로 종료 될 수 있음
         th1.join(); // th1의 작업이 끝날 때까지 기다린다.
         th2.join(); // th2의 작업이 끝날 때까지 기다린다.
         th3.join(); // th3의 작업이 끝날 때까지 기다린다.

        System.out.println("소요시간 : " + (System.currentTimeMillis() - ThreadEx13.startTime));

    }
}

class ThreadEx13_1 extends Thread {
    public void run(){
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
    }
}

class ThreadEx13_2 extends Thread {
    public void run(){
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
        }
    }
}