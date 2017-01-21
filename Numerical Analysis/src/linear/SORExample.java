package linear;

import util.Calc;
import util.MODE;
import util.NORM;

public class SORExample {
	public static void main(String[] args) {
		double[][] A = { 
				{ 6, 1, 1, 1, 0 },
				{ 1, 7, 1, 1, 1 },
				{ 0, 1, 8, 1, 1 },
				{ 0, 0, 1, 9, 1 },
				{ 0, 0, 0, 1, 10 }
		};
		double[] b = { 9, 11, 11, 11, 11 };
		double[] x0 = { 0, 0, 0, 0, 0 };
		double eps = 1.0E-10;
		int N = 100;

		SOR s = new SOR(A, b);
		for (int i = 0; i < 20; i++) {
			System.out.printf("ω=%.1f%n", i * 0.1);
			Calc.printVec(s.solve(x0, i * 0.1, eps, N, MODE.REL_ERR, NORM.INF));
		}
	}
}
