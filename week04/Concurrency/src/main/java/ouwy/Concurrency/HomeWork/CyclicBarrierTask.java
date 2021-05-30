package ouwy.Concurrency.HomeWork;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTask implements Runnable{
	
	private CyclicBarrier barrier;
	private int count;
	
	public CyclicBarrierTask(CyclicBarrier barrier,int count) {
		this.barrier = barrier;
		this.count = count;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("cyc任务begin>>>>");
			TimeUnit.SECONDS.sleep(5); // 等待5秒
			// 执行方法
			RunTask task = new RunTask();
			task.taskRst(count);
			// 结束
			this.barrier.await();
			System.out.println("<<<<cyc任务结束！");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
