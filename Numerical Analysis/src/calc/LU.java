package calc;

public class LU {

	// LU分解
	private static void LUDiv(double[][] A) {
		for (int k = 0; k < A.length - 1; k++) {
			for (int i = k + 1; i < A.length; i++) {
				A[i][k] /= A[k][k];
				for (int j = k + 1; j < A[0].length; j++) {
					A[i][j] -= A[i][k] * A[k][j];
				}
			}
		}
	}

	// 前進代入
	private static void step(double[][] A, double[] b) {
		for (int k = 0; k < A[0].length; k++) {
			for (int j = 0; j < k; j++) {
				b[k] -= A[k][j] * b[j];
			}
		}
	}

	// 後退代入
	private static void back(double[][] A, double[] b) {
		for (int k = b.length - 1; k >= 0; k--) {
			for (int j = k + 1; j < b.length; j++) {
				b[k] -= A[k][j] * b[j];
			}
			b[k] /= A[k][k];
		}
	}

	// LU分解によって連立方程式を解く
	public static double[] solve(double[][] A, double[] b) {
		double[][] matA = new double[A.length][A[0].length];
		for (int i = 0; i < matA.length; i++) {
			matA[i] = A[i].clone();
		}
		double[] vecb = b.clone();

		// LU分解
		LUDiv(matA);
		// 前進代入
		step(matA, vecb);
		// 後退代入
		back(matA, vecb);

		return vecb;
	}
}
