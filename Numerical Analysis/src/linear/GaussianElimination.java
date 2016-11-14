package linear;

public class GaussianElimination {
	
	public static double[] solve(double A[][], double b[]) {
		double[][] matA = new double[A.length][A[0].length];
		for (int i = 0; i < matA.length; i++) {
			matA[i] = A[i].clone();
		}
		double[] vecb = b.clone();
		double alpha = 0.0;
		
		// 前進消去
		for (int k = 0; k < A.length - 1; k++) {
			for (int i = k + 1; i < A.length; i++) {
				alpha = matA[i][k] / matA[k][k];
				for (int j = k + 1; j < A[0].length; j++) {
					matA[i][j] -= alpha * matA[k][j];
				}
				vecb[i] -= alpha * vecb[k];
			}
		}

		// 後退代入
		for (int k = vecb.length - 1; k >= 0; k--) {
			for (int j = k + 1; j < vecb.length; j++) {
				vecb[k] -= matA[k][j] * vecb[j];
			}
			vecb[k] /= matA[k][k];
		}

		return vecb;
	}
}
