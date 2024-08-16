package tw.brad.tutor;

public class Brad18 {

	public static void main(String[] args) {
		Brad183 obj = new Brad183();
	}

}

class Brad181 {
	Brad181(){
		System.out.println("Brad181()");
	}
}
class Brad182 extends Brad181 {
	Brad182(){
		System.out.println("Brad182()");
	}
}
class Brad183 extends Brad182 {
	Brad183(){
		this(2);
		System.out.println("Brad183()");
	}
	Brad183(int a){
		this("");
		System.out.println("Brad183(int)");
	}
	Brad183(String a){
		//this();
		System.out.println("Brad183(String)");
	}
	
}
