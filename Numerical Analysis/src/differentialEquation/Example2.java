package differentialEquation;

import linear.Calc;
import linear.LU;
import linear.MODE;
import linear.Matrix;
import linear.NORM;
import linear.SOR;

public class Example2 {

	public static void main(String[] args) {
		final int N = 1000;
		final double h = 1.0 / N;
		double a = 2.0 - 2.0 * h;
		double b = 2.0 * h * h - 4.0;
		double c = 2.0 + 2.0 * h;
		double[][] M = Matrix.TripleDiagonalMatrix(a, b, c, N-1);
		double[] v = new double[N-1];
		double[] v0 = new double[N-1];
		double[] tx = new double[N-1];
		for (int i = 0; i < N-1; i++) {
			v[i] = 2.0 * h * h * Math.exp(h * (i+1));
			v0[i] = 0.0;
			tx[i] = (Math.exp(h*(i+1.0)) - Math.exp(-h*(i+1.0)) + (1.0-Math.exp(2.0)) * h*(i+1.0) * Math.exp(-h*(i+1.0))) / 4.0;
		}
		
		SOR s = new SOR(M, v);
		double[] x = new double[N-1];
		for (int i = 0; i < 20; i++) {
			x = s.solve(v0, i*0.1, 1.0e-6, 2000, MODE.REL_ERR, NORM.INF);
		}
		Calc.printE(Calc.vecNormInf(Calc.subVec(tx, x)));

	}

}
