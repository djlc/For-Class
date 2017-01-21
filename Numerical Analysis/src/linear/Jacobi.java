package linear;

import util.Calc;
import util.MODE;
import util.NORM;

public class Jacobi {
	// 係数行列
	double[][] A;
	// 係数ベクトル
	double[] b;
	
	// 近似解を求めるためのベクトル列
	double[] x0, x1;

	// コンストラクタ
	public Jacobi(double[][] A, double[] b) {
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
	public double[] solve(double[] x0, double eps, int N, MODE mode, NORM norm) {
		this.x0 = x0.clone();
		for (int m = 1; m <= N; m++) {
			for (int i = 0; i < A.length; i++) {
				x1[i] = b[i];
				for (int j = 0; j < A.length; j++) {
					if (i != j) {
						x1[i] -= A[i][j] * this.x0[j];
					}
				}
				x1[i] /= A[i][i];
			}
			
			if (Calc.getVecNorm(this.x0, x1, A, b, mode, norm) < eps) {
				System.out.println(m);
				break;
			}
			if (m == N) System.out.println("収束しない");
			
			this.x0 = x1.clone();
		}
		return x1;
	}
}
