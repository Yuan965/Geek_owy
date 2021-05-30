package ouwy.Concurrency.HomeWork;

public class JoinTask implements Runnable {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("子线程开始>>>>");
			Thread.sleep(10000);
			RunTask task = new RunTask();
			task.taskRst(10);
			System.out.println("子线程结束>>>>");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
