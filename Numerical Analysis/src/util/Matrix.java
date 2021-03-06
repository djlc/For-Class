package util;

public class Matrix {
	// ゼロ行列の作成
	public static double[][] ZeroMatrix(int m, int n) {
		double[][] O = new double[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				O[i][j] = 0;
			}
		}
		return O;
	}

	// 単位行列の作成
	public static double[][] IdenticalMatrix(int n) {
		double[][] I = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				I[i][j] = (i == j) ? 1 : 0;
			}
		}
		return I;
	}
	
	// 対角行列diag(x1, x2, ..., xn)の作成
	public static double[][] DiagonalMatrix(double[] x) {
		double[][] D = new double[x.length][x.length];
		for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < D.length; j++) {
				D[i][j] = (i == j) ? x[i] : 0;
			}
		}
		return D;
	}
	
	// 乱数行列の作成(各成分の値の範囲は[0,1])
	public static double[][] RandomMatrix(int n, int m) {
		double[][] R = new double[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				R[i][j] = Math.random();
			}
		}
		return R;
	}
	
	// 三重対角行列の作成
	public static double[][] TripleDiagonalMatrix(double a, double b, double c, int n) {
		double[][] D = new double[n][n];
		for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < D.length; j++) {
				if (i == j + 1) {
					D[i][j] = a;
				}
				if (i == j) {
					D[i][j] = b;
				}
				if (i + 1 == j) {
					D[i][j] = c;
				}
			}
		}
		return D;
	}

	// Hilbert行列の作成
	public static double[][] HilbertMatrix(int n) {
		double[][] H = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				H[i][j] = 1.0 / (i+j+1.0);
			}
		}
		return H;
	}

	public static double[][] transpose(double[][] A) {
		double[][] M = new double[A[0].length][A.length];
		for (int i = 0; i < A[0].length; i++) {
			for (int j = 0; j < A.length; j++) {
				M[i][j] = A[j][i];
			}
		}
		return M;
	}
}
