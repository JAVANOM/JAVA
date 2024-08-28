package ch12;

public class ThreadEx22 {
    public static void main(String[] args) {
        Data d = new Data();
        // 두 쓰레드는 동일한 Data 인스턴스를 공유
        MyThreadEx22 t1 = new MyThreadEx22(d);
        MyThreadEx22 t2 = new MyThreadEx22(d);

        t1.start();
        t2.start();
    }
}

class Data{
    // 해당 변수는 두 쓰레드 간에 공유
    int iv = 0;
}

class MyThreadEx22 extends Thread{

    Data d;

    MyThreadEx22(Data d) {
        this.d = d;
    }

    // 순서는 쓰레드 스케쥴링의 특성에 따라 달라질 수 있다.
    public void run() {
        int lv = 0;

        while(lv < 3){
            System.out.println(getName() + " Local Var : " + ++lv);
            System.out.println(getName() + " Instance Var : " + ++d.iv);
            System.out.println();
        }
    }// run()
}
