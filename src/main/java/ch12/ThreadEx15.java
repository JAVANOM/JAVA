package ch12;

public class ThreadEx15 {
    public static void main(String[] args)  {

        ThreadEx15_1 th1 = new ThreadEx15_1();
        ThreadEx15_2 th2 = new ThreadEx15_2();

        th1.start();
        th2.start();

        try {
            // sleep()는 항상 현재 실행 중인 쓰레드에 대해 작동하기 때문에, 호출하여도 main쓰레드에 영향을 줌
            // static으로 선언 -> Thread.sleep();
            //Thread.sleep(5000);
            th1.sleep(5000); //잘못된 사용
        }catch (Exception e){}


        System.out.print("<<메인 종료>>");

    }
}


class ThreadEx15_1 extends Thread {
    public void run(){
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
        System.out.print("<<th1 종료 >>");
    }
}

class ThreadEx15_2 extends Thread {
    public void run(){
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
        }
        System.out.print("<<th2 종료>>");
    }
}


