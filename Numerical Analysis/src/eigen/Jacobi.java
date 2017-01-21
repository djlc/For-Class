package eigen;

import util.Calc;
import util.Matrix;

public class Jacobi {
	// 行列
	private double[][] A, P;
	// 行列のサイズ
	private final int N;
	// 反復回数
	private int iter = 1;

	// akm
	private double akm = 0.0;
	// k, m
	private int k = 0;
	private int m = 0;
	// s
	private double s = 0.0;
	// cos
	private double cos = 0.0;
	// sin
	private double sin = 0.0;

	public Jacobi(double[][] A, double eps, int maxIter) {
		this.N = A.length;
		this.A = new double[N][N];
		this.P = new double[N][N];

		// 行列の初期化
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				this.A[i][j] = A[i][j];
				this.P[i][j] = 0.0;
			}
		}

		// 非対角要素が全てeps未満 or 最大反復回数に達したなら終了
		while (true) {
			// 非対角要素の絶対値最大成分a_{km}を求める
			double t = 0.0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != j && t < Math.abs(A[i][j])) {
						t = Math.abs(A[i][j]);
						k = i;
						m = j;
					}
				}
			}
			if (t < eps) break;
			akm = t;

			// s
			s = A[k][k] - A[m][m];
			s /= 2.0;

			// cosφ
			t = Math.sqrt(s * s + akm * akm);
			cos = 1.0 + sgn(s) * s / t;
			cos = Math.sqrt(cos / 2.0);
			// sinφ
			sin = sgn(s) * akm / 2.0 / t / cos;

			// 直交行列P
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					P[i][j] = (i == j) ? 1.0 : 0.0;
				}
			}
			P[k][k] = cos;
			P[m][k] = sin;
			P[k][m] = -sin;
			P[m][m] = cos;

			// A_k+1 = P^T A_k P
			A = Calc.multipleMat(Calc.multipleMat(Matrix.transpose(P), A), P);

			// iter
			System.out.println("iter : " + iter);
			Calc.printMat(A);
			if (iter == maxIter) {
				break;
			}
			iter++;

		}

	}

	// 符号
	private int sgn(double s) {
		return (s < 0) ? -1 : 1;
	}

	// 非対角要素の絶対値が全てeps未満ならtrue
	private boolean check(double eps) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j && Math.abs(A[i][j]) >= eps) {
					return false;
				}
			}
		}
		return true;
	}

	public int getIter() {
		return iter;
	}
}
