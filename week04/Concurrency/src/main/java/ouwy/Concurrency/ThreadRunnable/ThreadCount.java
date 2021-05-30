package ouwy.Concurrency.ThreadRunnable;

public class ThreadCount {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().getThreadGroup().getParent().list();
    }
}
