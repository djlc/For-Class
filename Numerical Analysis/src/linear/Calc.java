package linear;

public class Calc {

	// ベクトルのコンソール出力
	public static void printVec(double x[]) {
		if (x == null)
			return;
		for (int i = 0; i < x.length; i++) {
			System.out.print("|");
			System.out.printf("%23.16e", x[i]);
			System.out.println("|");
		}
	}

	// 行列のコンソール出力
	public static void printMat(double A[][]) {
		if (A == null)
			return;
		for (int i = 0; i < A.length; i++) {
			System.out.print("|");
			for (int j = 0; j < A[i].length; j++) {
				System.out.printf("%10.3e", A[i][j]);
				if (j != A[i].length - 1)
					System.out.print(" ");
			}
			System.out.println("|");
		}
	}
	
	// 有効桁数3桁での指数表示出力
	public static void printE(double x) {
		System.out.printf("%.2e%n", x);
	}

	// クロネッカーのデルタ
	public static int kDelta(int i, int j) {
		return (i == j) ? 1 : 0;
	}

	// ベクトルxをスカラーc倍する
	public static double[] scalarMultiple(double c, double x[]) {
		for (int i = 0; i < x.length; i++)
			x[i] *= c;
		return x;
	}

	// ベクトルの足し算(x+y)
	public static double[] addVec(double x[], double y[]) {
		if (x.length != y.length)
			return null;
		double[] z = x.clone();
		for (int i = 0; i < x.length; i++)
			z[i] += y[i];
		return z;
	}

	// ベクトルの引き算(x-y)
	public static double[] subVec(double x[], double y[]) {
		if (x.length != y.length)
			return null;
		double[] z = x.clone();
		for (int i = 0; i < x.length; i++)
			z[i] -= y[i];
		return z;
	}

	// ベクトルの内積(x・y)
	public static double innVec(double[] x, double[] y) {
		if (x.length != y.length) {
			System.out.println("[Error] ベクトルの要素数が一致しません.");
			return 0;
		}
		double p = 0.0;
		for (int i = 0; i < x.length; i++)
			p += x[i] * y[i];
		return p;
	}

	// 行列とベクトルの掛け算(Ax)
	public static double[] matVec(double A[][], double x[]) {
		if (A[0].length != x.length)
			return null;
		double[] v = new double[x.length];
		for (int i = 0; i < x.length; i++) {
			v[i] = innVec(A[i], x);
		}
		return v;
	}

	// 残差Ax-bの計算
	public static double[] residual(double A[][], double x[], double b[]) {
		return subVec(matVec(A, x), b);
	}

	// 行列の足し算
	public static double[][] addMat(double A[][], double B[][]) {
		if (A.length != B.length || A[0].length != B[0].length)
			return null;
		double[][] C = A.clone();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				C[i][j] += B[i][j];
			}
		}

		return C;
	}

	// 行列の掛け算
	public static double[][] multipleMat(double A[][], double B[][]) {
		if (A[0].length != B.length)
			return null;
		double[][] C = new double[A.length][B[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				C[i][j] = 0.0;
				for (int k = 0; k < B.length; k++)
					C[i][j] += A[i][k] * B[k][j];
			}
		}

		return C;
	}

	// ベクトルの1ノルム
	public static double vecNorm1(double[] x) {
		double c = 0.0;
		for (int i = 0; i < x.length; i++)
			c += Math.abs(x[i]);
		return c;
	}

	// ベクトルの2ノルム
	public static double vecNorm2(double[] x) {
		double c = 0.0;
		for (int i = 0; i < x.length; i++)
			c += x[i] * x[i];
		return Math.sqrt(c);
	}

	// ベクトルの∞ノルム
	public static double vecNormInf(double[] x) {
		double c = 0.0;
		for (int i = 0; i < x.length; i++) {
			if (c < Math.abs(x[i]))
				c = Math.abs(x[i]);
		}
		return c;
	}
	
	// ベクトルのpノルム
	public static double vecNorm(double[] x, double p) {
		double c = 0.0;
		for (int i = 0; i < x.length; i++) {
			c += Math.pow(Math.abs(x[i]), p);
		}
		return Math.pow(c, 1/p);
	}

	// 行列の1ノルム(列和)
	public static double matNorm1(double[][] A) {
		double c = 0.0;
		for (int i = 0; i < A[0].length; i++) {
			double d = 0.0;
			for (int j = 0; j < A.length; j++)
				d += Math.abs(A[j][i]);
			if (c < d)
				c = d;
		}
		return c;
	}

	// 行列の∞ノルム(行和)
	public static double matNormInf(double[][] A) {
		double c = 0.0;
		for (int i = 0; i < A.length; i++) {
			double d = 0.0;
			for (int j = 0; j < A[0].length; j++)
				d += Math.abs(A[i][j]);
			if (c < d)
				c = d;
		}
		return c;
	}
	
	// 行列のトレース
	public static double trace(double[][] A) {
		double t = 0.0;
		for (int i = 0; i < A.length; i++) {
			t += A[i][i];
		}
		return t;
	}

	// 残差, 誤差に関するベクトルノルムの取得(引数雑すぎるけど)
	public static double getVecNorm(double[] x0, double[] x1, double[][] A, double[] b, MODE mode, NORM norm) {
		if (mode == MODE.ABS_ERR && norm == NORM.ONE) {
			return Calc.vecNorm1(Calc.subVec(x0, x1));
		}
		if (mode == MODE.ABS_ERR && norm == NORM.TWO) {
			return Calc.vecNorm2(Calc.subVec(x0, x1));
		}
		if (mode == MODE.ABS_ERR && norm == NORM.INF) {
			return Calc.vecNormInf(Calc.subVec(x0, x1));
		}
		if (mode == MODE.REL_ERR && norm == NORM.ONE) {
			return Calc.vecNorm1(Calc.subVec(x0, x1)) / Calc.vecNorm1(x1);
		}
		if (mode == MODE.REL_ERR && norm == NORM.TWO) {
			return Calc.vecNorm2(Calc.subVec(x0, x1)) / Calc.vecNorm2(x1);
		}
		if (mode == MODE.REL_ERR && norm == NORM.INF) {
			return Calc.vecNormInf(Calc.subVec(x0, x1)) / Calc.vecNormInf(x1);
		}
		if (mode == MODE.ABS_RES && norm == NORM.ONE) {
			return Calc.vecNorm1(Calc.residual(A, x1, b));
		}
		if (mode == MODE.ABS_RES && norm == NORM.TWO) {
			return Calc.vecNorm2(Calc.residual(A, x1, b));
		}
		if (mode == MODE.ABS_RES && norm == NORM.INF) {
			return Calc.vecNormInf(Calc.residual(A, x1, b));
		}
		if (mode == MODE.REL_RES && norm == NORM.ONE) {
			return Calc.vecNorm1(Calc.residual(A, x1, b)) / Calc.vecNorm1(b);
		}
		if (mode == MODE.REL_RES && norm == NORM.TWO) {
			return Calc.vecNorm2(Calc.residual(A, x1, b)) / Calc.vecNorm2(b);
		}
		if (mode == MODE.REL_RES && norm == NORM.INF) {
			return Calc.vecNormInf(Calc.residual(A, x1, b)) / Calc.vecNormInf(b);
		}
		return 0;
	}

	// 条件数
	public static double cond(double[][] A) {
		return matNormInf(A) * matNormInf(LU.inverse(A));
	}
}
