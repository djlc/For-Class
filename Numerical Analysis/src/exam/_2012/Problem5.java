package exam._2012;

import linear.GaussSeidel;
import linear.Jacobi;
import util.MODE;
import util.NORM;

public class Problem5 {

	public static void main(String[] args) {
		double[][] A = {
				{3, -2, 0},
				{-2, 3, -2},
				{0, -2, 3},
		};
		double[] b = {1,1,1};
		double[] x0 = {1, -1, 1};
		double eps = 1.0E-7;
		int N = 200;
		
		GaussSeidel g = new GaussSeidel(A, b);
		Jacobi j = new Jacobi(A, b);
		
		g.solve(x0, eps, N, MODE.ABS_RES, NORM.ONE);
		j.solve(x0, eps, N, MODE.ABS_RES, NORM.ONE);
	}

}
