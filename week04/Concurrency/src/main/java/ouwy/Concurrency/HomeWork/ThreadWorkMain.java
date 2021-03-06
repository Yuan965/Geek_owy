
package ouwy.Concurrency.HomeWork;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 使用CountDownLatch异步执行
 * @author 75240
 *
 */
public class ThreadWorkMain {

	//flag用来标志子线程执行结束
    static boolean flag=false;
    
    public static void main(String[] args) throws Exception{
    	System.out.println("主线程begin>>>>>");
    	long start=System.currentTimeMillis();
//    	joinMethod(); // 使用join方式异步执行
//    	countDownLatchMethod(); // 使用CountDownLatch异步执行
//    	cyclicBarrierMethod(); // 使用CyclicBarrier异步执行
//    	flagSleep(); // 使用标志位实现
    	semaphoreMethd(); // 使用semaphore执行
//    	excutorServiceMethod(); // 使用线程池方式执行
    	
    	System.out.println("<<<<<主线程end");
    	System.out.println("一共使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
    
    /**
     * 使用CountDownLatch异步执行
     */
    public static void countDownLatchMethod(){
    	try {
	    	CountDownLatch latch = new CountDownLatch(1);//任务数目
	    	CompletableFuture.runAsync(new CountDownLatchTask(latch ,30));
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * 使用CyclicBarrier异步执行
     */
    public static void cyclicBarrierMethod(){
    	CyclicBarrier barrier = new CyclicBarrier(2);//任务数目
    	CompletableFuture.runAsync(new CyclicBarrierTask(barrier,5));
    	try {
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	barrier.reset();
    }
    
    /**
     * 使用Semaphore异步执行
     */
    public static void semaphoreMethd(){
    	Semaphore sem = new Semaphore(1); //任务数目
    	new SemaphoreTask(sem, 10).run();
    }
    
    /**
     * 使用标志位异步执行
     */
    public static void flagSleep(){
    	SleepFlag ss = new SleepFlag(10);
    	Thread taskThread = new Thread(ss);
    	taskThread.start();
    	while(!flag)
			try {
				taskThread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    
    static class SleepFlag implements Runnable {
    	
    	private int count;
    	
    	public SleepFlag(int count) {
    		this.count = count;
    	}
    	
    	@Override
    	public void run() {
    		// TODO Auto-generated method stub
    		try {
    			System.out.println("子任务begin>>>>");
    			TimeUnit.SECONDS.sleep(5); // 等待5秒
    			// 执行方法
    			RunTask task = new RunTask();
    			task.taskRst(count);
    			flag = true;
    			// 结束
    			System.out.println("<<<<子任务结束！");
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    }
    
    /**
     * 使用join方式
     */
    private static void joinMethod() {
    	JoinTask jt = new JoinTask();
    	Thread thread = new Thread(jt);
    	thread.start();
    	try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * 线程池方式
     */
    private static void excutorServiceMethod() {
    	ExcutorServiceTask es = new ExcutorServiceTask();
    	es.run();
    }
}
