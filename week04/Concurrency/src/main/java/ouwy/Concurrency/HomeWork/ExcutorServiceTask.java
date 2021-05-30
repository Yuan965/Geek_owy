package ouwy.Concurrency.HomeWork;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcutorServiceTask implements Runnable {
	
	@Override
	public void run() {
		ExecutorService executorService = Executors.newCachedThreadPool(); 
		Runnable runnable = new Runnable() {
	         @Override
	         public void run() {
	             try {
	                 System.out.println("线程池start>>>>>");
	                 Thread.sleep(10000);
	                 RunTask task = new RunTask();
	     			 task.taskRst(10);
	                 System.out.println("线程池end>>>>>");
	             } catch (InterruptedException e) {
	                 e.printStackTrace();
	             }
	         }
	    };
	    executorService.execute(runnable);
	    executorService.shutdown();
	    while (true) {//等待所有任务都执行结束
	    	if (executorService.isTerminated()) {//所有的子线程都结束了
			  break;
	    	}
	    }
	}
}
