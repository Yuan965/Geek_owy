package ouwy.Concurrency.HomeWork;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTask implements Runnable{
	
	private CountDownLatch latch;
	private int count;
	
	public CountDownLatchTask(CountDownLatch latch,int count) {
		this.latch = latch;
		this.count = count;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("cdl任务开始>>>>");
			TimeUnit.SECONDS.sleep(10); // 十秒后执行
			// 执行方法
			RunTask task = new RunTask();
			task.taskRst(count);
			// 结束
			this.latch.countDown();
			System.out.println("<<<<<cdl任务结束!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
