package task01;

public class p4 {
	public static void main(String[] args) {
		double e = 0.0;
		for (int i = 0; i <= 9; i++) {
			e += 1.0 / fact(i);
		}
		System.out.println(e);
	}

	private static long fact(int n) {
		if (n == 0 || n == 1) return 1;
		
		long temp = 1;
		
		for (int i = 2; i <= n; i++) {
			temp *= i;
		}
		
		return temp;
	}
}
