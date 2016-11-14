package linear;

public class GaussianEliminationPivot {
	
	public static double[] solve(double A[][], double b[]) {
		double[][] matA = new double[A.length][A[0].length];
		for (int i = 0; i < matA.length; i++) {
			matA[i] = A[i].clone();
		}
		double[] vecb = b.clone();
		
		// 前進消去
		for (int k = 0; k < A.length - 1; k++) {
			for (int i = k + 1; i < A.length; i++) {

				// pivot選択
				int l = k + 1;
				for (int t = k; t < A.length; t++) {
					if (Math.abs(matA[t][k]) > Math.abs(matA[l][k])) {
						l = t;
					}
				}

				// 行の入れ替え
				double temp = 0;
				for (int s = k; s < A.length; s++) {
					temp = matA[l][s];
					matA[l][s] = matA[k][s];
					matA[k][s] = temp;
				}
				temp = vecb[l];
				vecb[l] = vecb[k];
				vecb[k] = temp;
				
				for (int j = k + 1; j < A[0].length; j++) {
					matA[i][j] -= matA[i][k] / matA[k][k] * matA[k][j];
				}
				vecb[i] -= matA[i][k] / matA[k][k] * vecb[k];
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
