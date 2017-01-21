package task;

import util.Calc;
import util.Matrix;

public class SizeTest {

	public static void main(String[] args) {
		final int N = 1000;
		double[][] A = Matrix.RandomMatrix(N, N);
		double[][] B = Matrix.RandomMatrix(N, N);
		long start = System.nanoTime();
		Calc.multipleMat(A, B);
		long end = System.nanoTime();
		System.out.println((end - start) / 1000000 + "ms");
		
	}

}
