package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Brad46 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/ns1hosp.csv");
			InputStreamReader reader = new InputStreamReader(fin);
			BufferedReader br = new BufferedReader(reader);
			
			String line;
			while ( (line = br.readLine()) != null) {
				//System.out.println(line);
				String[] data = line.split(",");
				System.out.printf("%s:%s:%s:%s\n", data[1], data[2], data[4], data[7]);
			}
			
			br.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
