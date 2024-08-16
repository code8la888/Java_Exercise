package tw.brad.tutor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import tw.brad.apis.Student;

public class Brad49 {
	public static void main(String[] args) {
		Student s1 = new Student("Brad", 40, 72, 53);
		System.out.println(s1);
		System.out.println(s1.sum());
		System.out.println(s1.avg());
		s1.getBike().upSpeed();s1.getBike().upSpeed();s1.getBike().upSpeed();s1.getBike().upSpeed();
		System.out.println(s1.getBike().getSpeed());
		
		try {
			FileOutputStream fout = new FileOutputStream("dir1/brad.score");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			
			oout.writeObject(s1);
			
			oout.flush();
			oout.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
}
