package linear;

import util.Calc;
import util.MODE;
import util.NORM;

public class JacobiExample {
	public static void main(String[] args) {
		double[][] A = {
				{6, 1, 1, 1, 0},
				{1, 7, 1, 1, 1},
				{0, 1, 8, 1, 1},
				{0, 0, 1, 9, 1},
				{0, 0, 0, 1, 10},
		};
		double[] b = { 9, 11, 11, 11, 11 };
		double[] x0 = { 0, 0, 0, 0, 0};
		double eps = 1.0E-10;
		int N = 100;
		
		Jacobi j = new Jacobi(A, b);
		Calc.printVec(j.solve(x0, eps, N, MODE.REL_ERR, NORM.INF));
		Calc.printVec(GaussianEliminationPivot.solve(A, b));
	}
}
