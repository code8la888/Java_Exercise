package tw.brad.tutor;

import tw.brad.apis.Bike;

public class Brad16 {

	public static void main(String[] args) {
		String s1 = new String();
		System.out.println(s1.length());
		
		byte[] b1 = {97, 98, 99 ,100};
		String s2 = new String(b1);
		System.out.println(s2.length());
		System.out.println(s2);
		
		Bike b2 = new Bike();
		System.out.println(b2);
		
		int c = 12;
		System.out.println(c);
		
		Object obj1 = new Object();
		System.out.println(obj1);
		
		String s3 = "Brad";
		System.out.println(s3);
		String s4 = "Brad";
		String s5 = new String("Brad");
		String s6 = new String("Brad");
		System.out.println(s3 == s4);
		System.out.println(s3 == s5);
		
		System.out.println("Brad".charAt(0));
		
		System.out.println(s3.concat("Chao"));
		System.out.println(s3);
		
		
		
	}

}
