package tw.brad.tutor;

import java.util.LinkedList;
import java.util.List;

public class Brad31 {

	public static void main(String[] args) {
		List<String> times  = new LinkedList<String>();
		times.add(0,"10:20:30");
		times.add(0,"10:20:34");
		times.add(0,"10:20:37");
		times.add(0,"10:20:47");
		times.add(0,"10:20:51");
		times.add(0,"10:20:59");
		System.out.println("----");
		for (String time : times) {
			System.out.println(time);
		}
		
		
	}

}
