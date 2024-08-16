package tw.brad.tutor;

import java.util.Timer;
import java.util.TimerTask;

public class Brad63 {
	public static void main(String[] args) {
		Timer timer = new Timer();
//		建立一個Timer物件，用來安排任務
		timer.schedule(new MyTask(), 0, 1*1000);
//		安排MyTask任務，延遲0秒後開始執行，並每隔一秒重複執行
		timer.schedule(new StopTask(timer), 10*1000);
//		安排StopTask任務，延遲10秒後開始執行
		System.out.println("Main");
	}
}
class MyTask extends TimerTask {
	//繼承了Timertask建立了MyTask任務
	private int i;
	@Override
	public void run() {
		System.out.println(i++);//任務內容
	}
}
class StopTask extends TimerTask {
	//繼承了Timertask建立了STTask任務
	private Timer timer;
	//建構式
	public StopTask(Timer timer) {
		this.timer = timer;
	}
	@Override
	public void run() {
		timer.purge();//從任務列表中移除所有取消的任務
		timer.cancel();//終止計時器，移除所有安排的任務
		timer = null;
		
	}
}
