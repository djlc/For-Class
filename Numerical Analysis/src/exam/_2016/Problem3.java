package exam._2016;

import linear.Calc;
import linear.GaussianElimination;
import linear.LU;

public class Problem3 {

	public static void main(String[] args) {
		double[][] A = {
			{1.0e-15, 2.0, 0.0},
			{2.0, 2.0, 2.0},
			{0.0, 2.0, 1.0e+15},
		};
		double[] b = new double[3];
		double[] tx = {1, 1, 1};
		
		for (int i = 0; i < 3; i++) {
			b[i] = 0.0;
			for (int j = 0; j < 3; j++) {
				b[i] += A[i][j];
			}
		}

		double kai1 = Calc.matNorm1(A) * Calc.matNorm1(LU.inverse(A));
		Calc.printE(kai1);
		
		// Gaussの消去法(Pivot選択無し)
		double[] x = GaussianElimination.solve(A, b);
		
		// 相対残差1ノルム
		double r = Calc.vecNorm1(Calc.residual(A, x, b)) / Calc.vecNorm1(b);
		Calc.printE(r);
		
		// 相対誤差1ノルム
		double e = Calc.vecNorm1(Calc.subVec(tx, x)) / Calc.vecNorm1(tx);
		Calc.printE(e);

	}

}
