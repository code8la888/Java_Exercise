package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Brad43 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileOutputStream fout = new FileOutputStream("dir2/test2.pdf");
			FileInputStream fin = new FileInputStream("dir1/test1.pdf");
			
			int b; 
			while ((b = fin.read()) != -1) {
				fout.write(b);
			}
			
			fin.close();
			fout.flush();
			fout.close();
			System.out.println("Finish");
			System.out.println(System.currentTimeMillis() - start);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
