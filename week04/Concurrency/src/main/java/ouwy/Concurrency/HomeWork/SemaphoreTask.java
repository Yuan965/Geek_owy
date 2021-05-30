package ouwy.Concurrency.HomeWork;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTask extends Thread {
	
	private Semaphore semaphore;
	private int count;
	
	public SemaphoreTask(Semaphore semaphore ,int count) {
		this.semaphore = semaphore;
		this.count = count;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			semaphore.acquire();
			System.out.println("sem任务begin>>>>");
			TimeUnit.SECONDS.sleep(5); // 等待5秒
			// 执行方法
			RunTask task = new RunTask();
			task.taskRst(count);
			// 结束
			System.out.println("<<<<sem任务结束！");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
}
