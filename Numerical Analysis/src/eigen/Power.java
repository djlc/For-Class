package eigen;

import util.Calc;

public class Power {

	// 行列
	double[][] A;
	// 初期値ベクトル
	double[] x0, x1;
	// 許容誤差
	double eps;
	// 最大反復回数
	int maxN;

	// 固有値
	double eigenValue0, eigenValue1;
	// 固有ベクトル
	double[] eigenVector;

	public Power(double[][] A, double[] x0, double eps, int maxN) {
		this.A = new double[A.length][A[0].length];
		this.x0 = new double[x0.length];
		this.x1 = new double[x0.length];
		this.eigenValue0 = 0.0;
		this.eigenValue1 = 0.0;
		this.eigenVector = new double[A.length];

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				this.A[i][j] = A[i][j];
			}
			this.x0[i] = x0[i];
		}
		this.eps = eps;
		this.maxN = maxN;

		solve();
	}

	private void solve() {
		for (int k = 0; k < maxN; k++) {
			// ベクトルの正規化
			double norm = Calc.vecNorm2(x0);
			for (int i = 0; i < x0.length; i++) {
				x0[i] /= norm;
			}

			// べき乗の計算
			x1 = Calc.matVec(A, x0);
			
			// 固有値の計算
			eigenValue1 = Calc.vecNormInf(x1) / Calc.vecNormInf(x0);
			
			// 収束判定
			if (Math.abs(eigenValue1 - eigenValue0) / Math.abs(eigenValue1) < eps) {
				System.out.println("収束回数 : " + (k+1));
				System.out.println("絶対値最大固有値");
				Calc.printE(eigenValue1);
				System.out.println("その固有ベクトル");
				Calc.printVec(x1);
				break;
			} else {
				eigenValue0 = eigenValue1;
				for (int i = 0; i < x0.length; i++) {
					x0[i] = x1[i];
				}
			}
		}
	}

}
