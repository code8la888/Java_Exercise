package tw.brad.tutor;

import java.util.LinkedHashSet;

public class Brad29 {

	public static void main(String[] args) {
		LinkedHashSet<String> names = new LinkedHashSet<>();
		System.out.println(names.add("Brad"));
		System.out.println(names.add("Eric"));
		System.out.println(names.add("Andy"));
		System.out.println(names.add("Mark"));
		System.out.println(names.add("Eric"));
		System.out.println(names.add("Tony"));
		System.out.println(names.add("Eric"));
		System.out.println("----");
		
		for( String name : names) {
			System.out.println(name);
		}
	}

}
