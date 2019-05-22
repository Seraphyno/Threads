package curs;

public class Core1 extends Thread {

    @Override
    public void run() {
        System.out.println("Thread started from Core1");
        for (int i = 5; i >= 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
