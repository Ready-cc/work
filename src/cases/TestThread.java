package cases;

import org.apache.xmlrpc.util.ThreadPool;

public class TestThread extends Thread{
	static private ThreadPool threadFixedPool = new ThreadPool(2, null); 
	public void run(){
		System.out.println("aa");
	}
	public static void main(String[] args) {
		TestThread aa = new TestThread();
		aa.run();
		
	}
}
