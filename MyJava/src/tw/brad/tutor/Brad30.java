package tw.brad.tutor;

import java.util.LinkedList;
import java.util.List;

public class Brad30 {

	public static void main(String[] args) {
		List list = new LinkedList();
		list.add("Brad");	// 0
		list.add(123);		// 1
		list.add(12.3);		// 2
		list.add(true);		// 3
		list.add(123);		// 4
		list.add("Brad");	// 5
		
		list.add(list.remove(3));
		
		System.out.println(list.size());
		System.out.println("---");
		for (Object obj : list ) {
			System.out.println(obj);
		}
		
		
	}

}
