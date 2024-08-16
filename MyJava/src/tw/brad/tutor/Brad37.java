package tw.brad.tutor;

public class Brad37 {
	public static void main(String[] args) {
		Brad371 obj = new Brad371();
		try {
			obj.m1();
		} catch (Exception e) {
		}
	}
}

class Brad371 {
	void m1() throws Exception{
		System.out.println("Brad371:m1()");
		m2();
	}
	void m2() throws Exception{
		System.out.println("Brad371:m2()");
		m3();
	}
	void m3() throws Exception{
		System.out.println("Brad371:m3()");
		throw new Exception();
	}
}
