package ouwy.Concurrency.ThreadRunnable;

import java.util.concurrent.Callable;

public class ThreadC implements Callable<String> {

    public String call() throws Exception {
        Thread.sleep(500);
        System.out.println("这是线程C");
        return "线程C";
    }



}
