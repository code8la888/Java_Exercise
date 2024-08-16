package tw.brad.tutor;

public class Brad19 {
	public static void main(String[] args) {
		Brad191 obj1 = new Brad191();
		obj1.m1(); obj1.m2();
		
		Brad192 obj2 = new Brad192();
		obj2.m1(); obj2.m2();obj2.m3();
		
		Brad191 obj3 = new Brad192();
		obj3.m1(); obj3.m2();
		
		Brad192 obj4 = (Brad192)obj3;
		obj4.m1();obj4.m2();obj4.m3();
		
//		Brad192 obj5 = new Brad193();
//		Brad193 obj6 = new Brad192();
		
		Brad191 obj7 = new Brad192();
//		Brad193 obj8 = (Brad193)obj7;
		
		if (obj7 instanceof Object) {
			System.out.println("Yes1");
		}else {
			System.out.println("No1");
		}
		
		if (obj7 instanceof Brad191) {
			System.out.println("Yes2");
		}else {
			System.out.println("No2");
		}

		if (obj7 instanceof Brad192) {
			System.out.println("Yes3");
		}else {
			System.out.println("No3");
		}

		if (obj7 instanceof Brad193) {
			System.out.println("Yes4");
		}else {
			System.out.println("No4");
		}

//		if (obj7 instanceof String) {
//			System.out.println("Yes4");
//		}else {
//			System.out.println("No4");
//		}
		
		
	}
}
class Brad191 {
	void m1() {
		System.out.println("Brad191:m1()");
	}
	void m2() {
		System.out.println("Brad191:m2()");
	}
}
class Brad192 extends Brad191 {
	void m2() {
		System.out.println("Brad192:m2()");
	}
	void m3() {
		System.out.println("Brad192:m3()");
	}
}
class Brad193 extends Brad191 {
	void m2() {
		System.out.println("Brad193:m2()");
	}
	void m3() {
		System.out.println("Brad193:m3()");
	}
	
}
