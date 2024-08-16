package tw.brad.tutor;

public class Brad11 {

	public static void main(String[] args) {
		int a = 10, b = 3;
		a = a ^ b;	// a = 13
		b = a ^ b;	// b = 10
		a = a ^ b;
		System.out.printf("a = %d, b = %d\n", a, b);
		
		int c = 3, d= 2;
		System.out.println(c ^ d);
	}

}
