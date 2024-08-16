package tw.brad.tutor;

public class Brad25 {
	public static void main(String[] args) {

	}
}
class Brad251 {
	void m1() {}
	void m1(int a) {}
	public int m1(double a) {return 1;}
	protected Object m2() {return new Object();}
}
class Brad252 extends Brad251 {
	public String m2() {
		return "";
	}
}
