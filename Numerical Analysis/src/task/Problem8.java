package task;

import linear.GaussianElimination;
import linear.GaussianEliminationPivot;
import util.Calc;

public class Problem8 {
	public static void main(String[] args) {
		final int N = 500;
		double[][] A = new double[N][N];
		double[] b = new double[N];
		double[] res = new double[N];
		double[] resPivot = new double[N];

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					A[j][k] = Math.random();
				}
				b[j] = Math.random();
			}
			res[i] = Calc.vecNorm2(Calc.residual(A, GaussianElimination.solve(A, b), b));
			resPivot[i] = Calc.vecNorm2(Calc.residual(A, GaussianEliminationPivot.solve(A, b), b));
			System.out.printf("%23.16e, %23.16e%n", res[i], resPivot[i]);
		}
		
	}
}
