package ch12;

public class ThreadEx11 implements Runnable {

    static boolean autoSave = false;
    public static void main(String[] args) {
        Thread t = new Thread(new ThreadEx11());
        t.setDaemon(true);
        t.start();

        for (int i = 0; i <= 20; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            System.out.println(i);

            if (i == 5)
                autoSave = true;

        }
        System.out.println("프로그램을 종료 합니다.");
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000 * 3);
            } catch (InterruptedException e) {}

            //autoSave의 값이 true이면 autoSave()를 호출
            if(autoSave){
                autoSave();
            }
        }
    }
    public void autoSave(){
        System.out.println("작업파일이 자동으로 저장되었습니다.");
    }
}
