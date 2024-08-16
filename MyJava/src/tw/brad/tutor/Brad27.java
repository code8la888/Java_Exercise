package tw.brad.tutor;

import java.util.HashSet;

import tw.brad.apis.Bike;

public class Brad27 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		
		set.add("Brad");
		set.add(12);	// 12 => new Integer(12) auto-boxing
		set.add(12.3);
		set.add("Brad");
		set.add(new Bike());
		set.add(12);
		System.out.println(set.size());
		System.out.println(set);
		
		
	}

}
