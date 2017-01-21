package exam._2016;

import util.Calc;

public class Problem1 {

	public static void main(String[] args) {
		final int N = 100;
		double[][] A = new double[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = i + j + 2;
			}
		}
		double t = Math.sqrt(Calc.trace(Calc.multipleMat(A, A)));
		Calc.printE(t);
	}

}
