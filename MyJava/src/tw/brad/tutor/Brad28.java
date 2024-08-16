package tw.brad.tutor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class Brad28 {

	public static void main(String[] args) {
		TreeSet<Integer> power = new TreeSet<Integer>();
		while (power.size()<6) {
			power.add(new Random().nextInt(1, 39));
		}
		
		System.out.println(power);
		System.out.println("---");
		
		Iterator<Integer> it = power.iterator();
		while (it.hasNext()) {
			Integer num = it.next();
			System.out.println(num);
		}
		
		System.out.println("---");
		
		for (Integer v : power) {
			System.out.println(v);
		}
		
		
		
	}

}
