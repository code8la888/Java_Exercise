package tw.brad.tutor;

public class Brad07 {

	public static void main(String[] args) {
		int[] ary1;
		ary1 = new int[3];
		System.out.println(ary1[0]);
		System.out.println(ary1[1]);
		System.out.println(ary1[2]);
		System.out.println(ary1.length);
		System.out.println("----");
		ary1[1] = 100;
		ary1[2] = 123;
		//ary1[3214] = 44;
		for (int i=0; i<ary1.length; i++) {
			System.out.println(ary1[i]);
		}
		System.out.println("----");
		for (int v : ary1) {
			System.out.println(v);
		}
	}

}
