package ch12;

// 멀티 쓰레드
// OS 프로세스 스케줄러의 영향을 받기 때문, JVM의 쓰레드 스케줄에 의해서 어떤 쓰레드가 얼마동안 실행 될인지 결정 되는것과
// 같이 프로세스도 프로세스 스케줄러에 의해서 어떤 실행순서와 실행 시간이 결정되기 때문에 매 순간 상황에 따라 프로세스에 할당되는
// 실행 시간과 쓰레드에게 할당되는 시간이 일정하지 않음
public class ThreadEx5 {
    static long startTime = 0;
    public static void main(String[] args) { // 프로세스 진입점, 쓰레드 생성 및 시작
         ThreadEx5_1 th1 = new ThreadEx5_1();
         th1.start();
         startTime = System.currentTimeMillis();

        for (int i = 0; i < 300; i++) { // 메인쓰레드 300개 '-' 문자를 출력
            System.out.print("-");
        }
        System.out.print("소요시간1 : "+ (System.currentTimeMillis() - ThreadEx5.startTime ));

    }
}

class ThreadEx5_1 extends Thread {
    public void run(){
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
        }

        System.out.print("소요시간 2 : " + (System.currentTimeMillis() - ThreadEx5.startTime));

    }

}
