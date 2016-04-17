package task01;

public class p2 {
	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) System.out.printf("%d\n", fibo(i));
	}
	
	public static long fibo(int index) {
		if (index <= -1) return 0;
		if (index >= 0) {
			if (index == 0) return 0;
			if (index == 1) return 1;
			
			long temp1 = 0, temp2 = 1, temp3 = 0;
			for (int i = 0; i < index - 1; i++) {
				temp3 = temp2 + temp1;
				temp1 = temp2;
				temp2 = temp3;
			}
			return temp3;
		}
		return 0;
	}
}
