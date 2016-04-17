package task01;

public class p3 {
	public static void main(String[] args) {
		int n = 1;
		double a = 0.0, s = 0.0;
		while(true) {
			a = 1.0 / Math.pow(3, n);
			s += a;
			if (a < 1.0e-5) {
				break;
			} else {
				n++;
			}
		}
		System.out.printf("n = %d, s = %f", n , s);
	}
}
