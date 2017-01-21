package differentialEquation;

import linear.GaussianElimination;
import util.Calc;
import util.Matrix;

public class Example2 {

	public static void main(String[] args) {
		final int N = 10000;
		final double h = 1.0 / N;
		double a = 2.0 - 2.0 * h;
		double b = 2.0 * h * h - 4.0;
		double c = 2.0 + 2.0 * h;
		
		// 係数行列
		double[][] M = Matrix.TripleDiagonalMatrix(a, b, c, N-1);
		
		// 係数ベクトル
		double[] v = new double[N-1];
		double[] tx = new double[N-1];
		for (int i = 0; i < N-1; i++) {
			v[i] = 2.0 * h * h * Math.exp(h * (i+1));
			tx[i] = (Math.exp(h*(i+1.0)) - Math.exp(-h*(i+1.0)) + (1.0-Math.exp(2.0)) * h*(i+1.0) * Math.exp(-h*(i+1.0))) / 4.0;
		}
		
		// Gaussの消去法
		double[] x = GaussianElimination.solve(M, v);
		Calc.printE(Calc.vecNormInf(Calc.subVec(tx, x)));
	}

}
