package exam._2014;

import linear.LU;
import util.Matrix;

public class Problem6 {

	public static void main(String[] args) {
		final int N = 100;
		double[][] A = Matrix.TripleDiagonalMatrix(1, 2, 1, N);
		System.out.printf("%.2e", LU.det(A));
	}

}
