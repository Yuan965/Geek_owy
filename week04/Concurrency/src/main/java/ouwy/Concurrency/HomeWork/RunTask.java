package ouwy.Concurrency.HomeWork;

public class RunTask {
	
	public void taskRst(int a) {
		int res = this.sum(a);
		System.out.println("异步计算结果为：" + res);
	}
	
	public int sum(int a) {
        return fibo(a);
    }
    
    public int fibo(int a) {
        if ( a < 2) 
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
