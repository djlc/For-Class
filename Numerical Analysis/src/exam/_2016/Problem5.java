package exam._2016;

import linear.Calc;
import linear.GaussSeidel;
import linear.Jacobi;
import linear.LU;
import linear.MODE;
import linear.NORM;
import linear.SOR;

public class Problem5 {

	public static void main(String[] args) {
		final int iter = 1000;
		final int N1 = 100;
		final int N2 = 500;
		
		// 行列
		double[][] A = new double[N1][N1];
		// 対角行列
		double[][] D = new double[N1][N1];
		// 下三角行列
		double[][] E = new double[N1][N1];
		// 上三角行列
		double[][] F = new double[N1][N1];
		
		// ベクトル
		double[] b = new double[N1];
		double[] x0 = new double[N1];
		
		for (int i = 0; i < N1; i++) {
			b[i] = 1.0;
			x0[i] = 0.0;
			for (int j = 0; j < N1; j++) {
				if (i == j) {
					A[i][j] = N1;
					D[i][j] = N1;
				}
				if (i > j) {
					A[i][j] = -1;
					E[i][j] = -1;
				}
				if (i < j) {
					A[i][j] = 1;
					F[i][j] = 1;
				}
			}
		}
		
		// 反復行列
		double[][] T = Calc.multipleMat(LU.inverse(D), Calc.addMat(E, F));
		double tn = Calc.matNormInf(T);
		Calc.printE(tn);
		
		// Jacobi
		double eps = 1.0e-10;
		Jacobi j = new Jacobi(A, b);
		j.solve(x0, eps, iter, MODE.REL_ERR, NORM.INF);

		double[][] B = new double[N2][N2];
		double[] c = new double[N2];
		double[] y0 = new double[N2];
		
		for (int i = 0; i < N2; i++) {
			c[i] = 1.0;
			y0[i] = 0.0;
			for (int j1 = 0; j1 < N2; j1++) {
				if (i == j1) {
					B[i][j1] = N2;
				}
				if (i > j1) {
					B[i][j1] = -1;
				}
				if (i < j1) {
					B[i][j1] = 1;
				}
			}
		}
		
		Jacobi j0 = new Jacobi(B, c);
		System.out.println("Jacobi法");
		j0.solve(y0, eps, iter, MODE.REL_ERR, NORM.INF);

		GaussSeidel g = new GaussSeidel(B, c);
		System.out.println("Gauss-Seidel法");
		g.solve(y0, eps, iter, MODE.REL_ERR, NORM.INF);

		SOR s = new SOR(B, c);
		System.out.println("SOR法");
		for (double k = 0.2; k < 1.0; k += 0.1) {
			double[] xx = s.solve(y0, k, eps, iter, MODE.REL_ERR, NORM.INF);
			Calc.printE(Calc.vecNorm2(Calc.residual(B, xx, c)) / Calc.vecNorm2(c));
		}

	}
	

}
