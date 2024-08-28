package ch12;

import javax.crypto.spec.PSource;

public class ThreadEx23 {
    public static void main(String[] args) {

        MyThreadEx23 th1 = new MyThreadEx23();
        MyThreadEx23 th2 = new MyThreadEx23();

        th1.start();
        th2.start();

    }
}

class MyThreadEx23 extends Thread {
    // iv는 각 쓰레드 인스턴스에 속하기 때문에, th1 쓰레드의 iv와 th2 쓰레드의 iv는 서로 다른 메모리 공간에 저장
    // 두 쓰레드는 서로의 상태에 영향을 주지 않고 독립적으로 실행
    int iv = 0;

    @Override
    public void run() {
        int lv = 0;

        while(lv < 3){
            System.out.println(getName() + " Local Var : " + ++lv);
            System.out.println(getName() + " Instance Var : " + ++iv);
            System.out.println();
        }
    }
}
