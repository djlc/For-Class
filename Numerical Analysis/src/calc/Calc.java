package calc;

public class Calc {
	
	// ベクトルのコンソール出力
	public static void printVec(double x[]) {
		if (x == null) return;
		System.out.print("[");
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i]);
			if (i != x.length) System.out.print(",");
		}
		System.out.println("]");
	}
	
	// 行列のコンソール出力
	public static void printMat(double A[][]) {
		if (A == null) return;
		for (int i=0; i<A.length; i++) {
			System.out.print("[");
			for (int j=0; j<A[i].length; j++) {
				System.out.printf("%.2f ", A[i][j]);
			}
			System.out.println("]");
		}
	}
	
	// ベクトルxをスカラーc倍する
	public static double[] scalarMultiple(double c, double x[]) {
		for (int i=0; i< x.length; i++) x[i] *= c;
		return x;
	}
	
	// ベクトルの足し算(x+y)
	public static double[] addVec(double x[], double y[]) {
		if (x.length != y.length) return null;
		double[] z = x.clone();
		for (int i=0; i<x.length; i++) z[i] += y[i];
		return z;
	}
	
	// ベクトルの引き算(x-y)
	public static double[] subVec(double x[], double y[]) {
		if (x.length != y.length) return null;
		double[] z = x.clone();
		for (int i=0; i<x.length; i++) z[i] -= y[i];
		return z;		
	}
	
	// ベクトルの内積(x・y)
	public static double innVec(double[] x, double[] y) {
		if (x.length != y.length) {
			System.out.println("[Error] ベクトルの要素数が一致しません.");
			return 0;
		}
		double p = 0.0;
		for (int i=0; i < x.length; i++) p += x[i] * y[i];
		return p;
	}
	
	// 行列とベクトルの掛け算(Ax)
	public static double[] matVec(double A[][], double x[]) {
		if (A[0].length != x.length) return null;
		double[] v = new double[x.length];
		for (int i=0; i<x.length; i++) {
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
		if (A.length != B.length || A[0].length != B[0].length) return null;
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
		if (A[0].length != B.length) return null;
		double[][] C = new double[A.length][B[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				C[i][j] = 0.0;
				for (int k = 0; k < B.length; k++) C[i][j] += A[i][k] * B[k][j];
			}
		}
		
		return C;
	}
	
	// ベクトルの1ノルム
	public static double vecNorm1(double[] x) {
		double c = 0.0;
		for (int i=0; i<x.length; i++) c += Math.abs(x[i]);
		return c;
	}
	
	// ベクトルの2ノルム
	public double vecNorm2(double[] x) {
		double c = 0.0;
		for (int i=0; i<x.length; i++) c += x[i]*x[i];
		return Math.sqrt(c);
	}
	
	// ベクトルの∞ノルム
	public static double vecNormInf(double[] x) {
		double c = 0.0;
		for (int i=0; i<x.length; i++) {
			if (c < Math.abs(x[i])) c = Math.abs(x[i]);
		}
		return c;
	}
	
	// 行列の1ノルム
	public static double matNorm1(double[][] A) {
		double c = 0.0;
		for (int i=0; i<A[0].length; i++) {
			double d = 0.0;
			for (int j=0; j<A.length; j++) d += Math.abs(A[j][i]);
			if (c < d) c = d;
		}
		return c;		
	}
	
	// 行列の∞ノルム
	public static double matNormInf(double[][] A) {
		double c = 0.0;
		for (int i=0; i<A.length; i++) {
			double d = 0.0;
			for (int j=0; j<A[0].length; j++) d += Math.abs(A[i][j]);
			if (c < d) c = d;
		}
		return c;		
	}
}
