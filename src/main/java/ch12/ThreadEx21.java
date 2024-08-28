package ch12;

public class ThreadEx21 {
    public static void main(String[] args) {
        RunnableImpl r = new RunnableImpl();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }
}

class RunnableImpl implements Runnable {
    //인스턴스 변수, 하나의 객체(RunnableImpl 인스턴스)를 두 개의 쓰레드가 공유하기 때문에
    //인스턴스 변수 iv 값은 두 쓰레드 모두 접근이 가능하다.
    //인스턴스 변수는 iv는 참조변수 this, super가 숨겨진 채로 존재
    int iv = 0;

    public void run(){
        // lv는 지역변수이기 때문에 각 쓰레드의 스택 내에서 생성 -> 같은 프로세스 내의 쓰레드 일지라도 공유X
        int lv = 0;
        String name = Thread.currentThread().getName();

        while(lv < 3){
            System.out.println(name + " Local Var : " + ++lv);
            System.out.println(name + " Instance Var : " + ++ iv);
            System.out.println();
        }
    }//run
}
