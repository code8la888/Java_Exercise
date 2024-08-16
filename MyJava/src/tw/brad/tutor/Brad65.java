package tw.brad.tutor;

public class Brad65 {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
		
		try {
			t2.join();
			//join()方法的作用是讓目前執行緒中等待被調用join()方法的執行緒執行結束
			//所以主執行緒會暫停，直到t2執行緒完成執行後才會繼續執行主執行緒剩下的程式碼
			//join()方法的作用範圍只會影響到使用他的執行緒，在這個例子中是主執行緒使用的
			//所以只有主執行緒會等待t2完成
		} catch (InterruptedException e) {
		}
		
		System.out.println("Main Finish");
	}
}
class Thread1 extends Thread { //thread1繼承了Thread
	@Override
	public void run() {
		System.out.println("Thread1 start working...");
		
		try {
			Thread.sleep(3*1000);
		} catch (InterruptedException e) {
		}
		
		System.out.println("Thread1 FINSIH!");
	}
}

class Thread2 extends Thread { //thread2繼承了Thread
	@Override
	public void run() {
		System.out.println("Thread2 start working...");
		
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
		}
		
		System.out.println("Thread2 FINSIH!");
	}
}
