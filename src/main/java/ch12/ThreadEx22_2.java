package ch12;

public class ThreadEx22_2 {
    public static void main(String[] args) {
        Data1 d = new Data1();
        // 두 쓰레드는 동일한 Data1 인스턴스를 공유
        MyThreadEx22_2 t1 = new MyThreadEx22_2(d);
        MyThreadEx22_2 t2 = new MyThreadEx22_2(d);

        t1.start();
        t2.start();
    }
}

// d.iv변수는 두 스레드 간에 공유, 두 스레드가 이 변수를 동기화없이 증가시키기 때문에 경쟁 조건이 발생
// 이로 인해 iv의 최종 값이 예상과 다를 가능성이 있음
// 스레드 간섭 : 출력 문장의 순서는 각 실행마다 달라 질 수 있음, 이는 스레드 스케줄링의 비결정적 특성으로 인해 발생 -> 실행 흐름 이해 혼란
class Data1{
    // 해당 변수는 두 쓰레드 간에 공유
    int iv = 0;

    synchronized void increment(){
        iv++;
    }
}

class MyThreadEx22_2 extends Thread{

    Data1 d;

    MyThreadEx22_2(Data1 d) {
        this.d = d;
    }

    // 순서는 쓰레드 스케쥴링의 특성에 따라 달라질 수 있다.
    public void run() {
        int lv = 0;

        while(lv < 3){
            System.out.println(getName() + " Local Var : " + ++lv);
            d.increment(); // 동기화된 메서드를 사용하여 iv 증가
            System.out.println(getName() + " Instance Var : " +d.iv);
            System.out.println();
        }
    }// run()
}
