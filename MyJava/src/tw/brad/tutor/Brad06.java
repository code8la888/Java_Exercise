package tw.brad.tutor;

public class Brad06 {

	public static void main(String[] args) {
		int i = 0;
		for ( printBrad() ; i<10 ; printLine() ) {
			System.out.println(i++);
		}
		//System.out.println("----");
		System.out.println(i);
	}

	static void printBrad() {
		System.out.println("Brad");
		printLine();
	}
	static void printLine() {
		System.out.println("---");
	}
	
}
