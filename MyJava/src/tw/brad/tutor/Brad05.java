package tw.brad.tutor;

public class Brad05 {

	public static void main(String[] args) {
		int year = 2004;
		boolean isLeap;
		
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					isLeap = true;
				}else {
					isLeap = false;
				}
			}else {
				isLeap = true;
			}
		}else {
			isLeap = false;
		}
		
		System.out.printf("%d年為%s年", year, isLeap?"閏":"平");
		
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			// 29
		}else {
			// 28
		}
		
		
		
	}

}
