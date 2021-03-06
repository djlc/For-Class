package linear;

import util.Calc;
import util.MODE;
import util.NORM;

public class SOR {
	// 係数行列
	public double[][] A;
	// 係数ベクトル
	public double[] b;
	
	// 近似解を求めるためのベクトル列
	public double[] x0, x1;
	
	// コンストラクタ
	public SOR(double[][] A, double[] b) {
		this.A = new double[A.length][A.length];
		this.b = new double[A.length];
		this.x0 = new double[A.length];
		this.x1 = new double[A.length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				this.A[i][j] = A[i][j];
			}
			this.b[i] = b[i];
			this.x0[i] = 0;
			this.x1[i] = 0;
		}
	}

	// Ax = bの解を求める
	public double[] solve(double[] x0, double omega, double eps, int N, MODE mode, NORM norm) {
		this.x0 = x0.clone();
		for (int m = 1; m <= N; m++) {
			for (int i = 0; i < A.length; i++) {
				x1[i] = b[i];
				for (int j = 0; j < A.length; j++) {
					if (j < i) {
						x1[i] -= A[i][j] * x1[j];
					} else if (j > i) {
						x1[i] -= A[i][j] * this.x0[j]; 
					}
				}
				x1[i] /= A[i][i];
				x1[i] = this.x0[i] + omega * (x1[i] - this.x0[i]);
			}
			
			if (Calc.getVecNorm(this.x0, x1, A, b, mode, norm) < eps) {
				System.out.printf("omega = %.2f, N = %d%n", omega, m);
				break;
			}
			if (m == N) System.out.printf("omega = %.2f, 収束しない%n", omega);
			
			this.x0 = x1.clone();
		}
		return x1;
	}
}
