package tw.brad.tutor;

public class Brad64 {
	public static void main(String[] args) {
		Store store = new Store();
		Producer p = new Producer(store);
		Consumer c1 = new Consumer(store, "Brad");
		Consumer c2 = new Consumer(store, "Amy");
		Consumer c3 = new Consumer(store, "Tony");
		p.start();
		c1.start();
		c2.start();
		c3.start();
		
		/*
		程式碼啟動了一個生產者的執行緒和三個消費者的執行緒，這些執行緒會同時運行，
		但消費者的購買順序並不是固定或事先決定的，
		當多個消費者同時想要購買東西時，他們會相爭進入buy()方法
		*/
	}
}
class Store {
	private int qty; //定義目前庫存數量
	private int max; //定義最大庫存數量
	Store(){ //建構式
		max = 10; //設定最大庫存數量為10
	}
	
	synchronized void add(int add) throws InterruptedException {
		//synchronized 關鍵字會確保在同一時間只有一個執行緒可以執行這個方法
		System.out.printf("準備進貨，欲進貨數量: %d\n", add);
		while (qty + add > max) {//若目前數量+欲進貨數量大於最大數量，進行等待
			wait(); //當購買數量大於庫存數量，執行緒會進入等待
		}
		qty += add; //qty=qty+add;
		System.out.printf("完成進貨，進貨數量: %d, 目前庫存: %d\n", add, qty);
		notify();//當生產者新曾庫存，他會通知等待的執行緒
	}
	
	synchronized void buy(int buy, String name) throws InterruptedException{
		System.out.printf("%s想買: %d\n", name, buy);
		while (qty < buy) {//當目前庫存<購買數量，進行等待
			wait();
		}
		qty -= buy; //qty=qty-buy
		System.out.printf("完成訂單，購買數量: %d(%s), 目前剩餘庫存: %d\n", buy, name, qty);
		notify();
	}
}

class Producer extends Thread {
	private Store store;
	public Producer(Store store) {
		this.store = store;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			try {
				store.add(5);//每次添加五個商品
				Thread.sleep(200);//間隔兩百毫秒
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}

class Consumer extends Thread {
	private Store store;
	private String name;
	public Consumer(Store store, String name) {
		this.store = store;
		this.name = name;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			try {
				store.buy((int)(Math.random()*3)+1, name);//每次隨機購買1~3個商品，循環十次
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}












