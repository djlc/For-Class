package exam1;

public class Problem3 {

	public static void main(String[] args) {
		double e = 0;
		int temp = 1;
		for (int i=1; i<=12; i++) {
			e += 1.0 / temp;
			temp *= i;
		}
		System.out.printf("%.16f%n", e);
		System.out.printf("%.2e%n", Math.abs(e-Math.E));
	}

}
