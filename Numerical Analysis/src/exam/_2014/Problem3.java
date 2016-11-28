package exam._2014;

import linear.Calc;
import linear.GaussianEliminationPivot;
import linear.Matrix;

public class Problem3 {

	public static void main(String[] args) {
		final int N = 12;
		double[][] A = Matrix.HilbertMatrix(N);
		double[] b = new double[N];
		double[] tx = new double[N];
		
		for (int i = 0; i < N; i++) {
			b[i] = 0.0;
			tx[i] = 1.0;
			for (int j = 0; j < N; j++) {
				b[i] += A[i][j];
			}
		}
		
		// (1)
		System.out.printf("%.2e%n", Calc.cond(A));

		// (2)
		double[] x = GaussianEliminationPivot.solve(A, b);
		System.out.printf("%.2e%n", Calc.vecNormInf(Calc.residual(A, x, b)) / Calc.vecNormInf(b));
		
		// (3)
		System.out.printf("%.2e%n", Calc.vecNormInf(Calc.subVec(tx, x)) / Calc.vecNormInf(tx));

	}

}
