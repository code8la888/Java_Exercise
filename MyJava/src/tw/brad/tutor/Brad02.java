package tw.brad.tutor;

import java.util.Scanner;

public class Brad02 {

	public static void main(String[] args) {
		// input
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("X = ");
		int x = scanner.nextInt();
		
		System.out.print("Y = ");
		int y = scanner.nextInt();
		
		// op..
		int r1 = x + y;
		int r2 = x - y;
		int r3 = x * y;
		int r4 = x / y;
		int r5 = x % y;
		
		// output
		System.out.printf("%d + %d = %d\n", x, y, r1);
		System.out.printf("%d - %d = %d\n", x, y, r2);
		System.out.printf("%d x %d = %d\n", x, y, r3);
		System.out.printf("%d / %d = %d ...... %d\n", x, y, r4, r5);
	}

}
