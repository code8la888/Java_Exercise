package tw.brad.tutor;

public class Brad62 {
	public static void main(String[] args) {
		//執行緒
		MyThread mt1 = new MyThread("A");
		MyThread mt2 = new MyThread("B");
		MyRunnable mr1 = new MyRunnable("C");
		Thread t1 = new Thread(mr1);
		
		mt1.start();
		mt2.start();
		t1.start();
		
		System.out.println("OK");

	}
}

class MyThread extends Thread { //Mythread繼承自Thread，表示MyThread也是一個執行緒
	private String name;
	
	//建構式，當建立一個物件時，參數會被傳遞近來並放name變數中
	public MyThread(String name) {
		this.name = name;
	}
	
	@Override
	public void run() { //run()方法是定義執行緒啟動後所要執行的程式碼
		for (int i=0; i<20; i++) {
			System.out.printf("%s : %d\n", name, i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}


class MyRunnable implements Runnable {
	private String name;
	
	public MyRunnable(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for (int i=0; i<20; i++) {
			System.out.printf("%s : %d\n", name, i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}

