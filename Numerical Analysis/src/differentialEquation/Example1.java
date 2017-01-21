package differentialEquation;

import linear.GaussianEliminationPivot;
import util.Calc;
import util.MODE;
import util.Matrix;
import util.NORM;

public class Example1 {

	public static void main(String[] args) {
		// -u'' + 16u = x
		final int N = 3000;
		double h = 1.0/N;
		double a = -1.0/(h*h);
		double b = 16.0 + 2.0 / (h*h);

		double[][] A = Matrix.TripleDiagonalMatrix(a, b, a, N-1);
		double[] x = new double[N-1];

		for (int i = 0; i < x.length; i++) {
			x[i] = (i + 1.0) / N;
		}

		double[] u = GaussianEliminationPivot.solve(A, x);
		double[] tu = new double[N-1];
		for ( int i = 0; i < x.length; i++) {
			tu[i] = tu(x[i]);
		}
		
		Calc.printE(Calc.getVecNorm(u, tu, null, null, MODE.REL_ERR, NORM.INF));
	}
	
	private static double tu(double x) {
		return (x - (Math.exp(4.0 * x) - Math.exp(-4.0 * x)) / (Math.exp(4) - Math.exp(-4))) / 16.0;
	}

}
