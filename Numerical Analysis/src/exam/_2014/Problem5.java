package exam._2014;

import linear.Jacobi;
import linear.SOR;
import util.Calc;
import util.MODE;
import util.Matrix;
import util.NORM;

public class Problem5 {

	public static void main(String[] args) {
		final int N = 200;
		double[][] A = Matrix.TripleDiagonalMatrix(1, -1, -2, N);
		double[] b = new double[N];
		double[] x0 = new double[N];
		double eps = 1.0E-8;
		int Nmax = 500;
		
		for (int i = 0; i < N; i++) {
			b[i] = 1.0;
			x0[i] = 0.0;
		}
		
		SOR sor = new SOR(A, b);
		for (int i = 0; i < 20; i++) {
			sor.solve(x0, i*0.1, eps, Nmax, MODE.REL_ERR, NORM.INF);
		}
		
		double[][] B = Matrix.TripleDiagonalMatrix(1, -1, -2, 3);
		Calc.printMat(B);
		Jacobi j = new Jacobi(B, b);
		j.solve(new double[]{0, 0, 0}, eps, Nmax, MODE.REL_ERR, NORM.INF);
	}

}
