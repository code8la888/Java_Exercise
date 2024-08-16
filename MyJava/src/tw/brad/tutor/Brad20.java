package tw.brad.tutor;

public class Brad20 {
	public static void main(String[] args) {
		Brad201 obj1 = new Brad201();
		Brad202 obj2 = new Brad202();
		Brad203 obj3 = new Brad203();
		att(obj1);
		att(obj2);
		att(obj3);
	}
	
	static void att(Brad201 obj) {
		obj.m1();
	}
	
}
class Brad201 {
	void m1() {System.out.println("Brad201:m1()");}
}
class Brad202 extends Brad201 {
	void m1() {System.out.println("Brad202:m1()");}
}
class Brad203 extends Brad201 {
	void m1() {System.out.println("Brad203:m1()");}
}

