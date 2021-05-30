package ouwy.Concurrency.ThreadRunnable;

public class Runner1 implements Runnable {
   
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("进入Runner1运行状态——————————" + i);
        }
    }
}
