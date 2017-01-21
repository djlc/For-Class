package task;

import util.Calc;

public class Problem9 {

	public static void main(String[] args) {

		// 行列の次数
		final int N1 = 5;
		final int N2 = 10;
		final int N3 = 15;

		// Hilbert行列
		double[][] A1 = new double[N1][N1];
		double[][] A2 = new double[N2][N2];
		double[][] A3 = new double[N3][N3];

		// x
		double[] x1 = null;
		double[] x2 = null;
		double[] x3 = null;

		// y
		double[] y1 = null;
		double[] y2 = null;
		double[] y3 = null;

		// b
		double[] b1 = new double[N1];
		double[] b2 = new double[N2];
		double[] b3 = new double[N3];

		// Delta-b
		double[] db1 = new double[N1];
		double[] db2 = new double[N2];
		double[] db3 = new double[N3];

		// 真解
		double[] tx1 = new double[N1];
		double[] tx2 = new double[N2];
		double[] tx3 = new double[N3];

		// N1
		for (int i = 0; i < N1; i++) {
			for (int j = 0; j < N1; j++) {
				A1[i][j] = 1.0 / (i + j + 1);
				b1[i] += A1[i][j];
			}
			tx1[i] = 1.0;
		}
		db1[0] = 0.001 * b1[0];

		System.out.printf("cond(A1) = %23.16e%n", Calc.cond(A1));
		System.out.printf("max(A1) = %23.16e%n", Calc.cond(A1) * Calc.vecNormInf(db1) / Calc.vecNormInf(b1));
		x1 = linear.GaussianEliminationPivot.solve(A1, b1);
		System.out.println("x1 =");
		Calc.printVec(x1);
		System.out.printf("res(x1) = %23.16e%n", Calc.vecNormInf(Calc.residual(A1, x1, b1)));
		System.out.printf("err(x1) = %23.16e%n", Calc.vecNormInf(Calc.subVec(tx1, x1)));
		y1 = linear.GaussianEliminationPivot.solve(A1, Calc.addVec(b1, db1));
		System.out.printf("err(y1) = %23.16e%n%n", Calc.vecNormInf(Calc.subVec(tx1, y1)));

		// N2
		for (int i = 0; i < N2; i++) {
			for (int j = 0; j < N2; j++) {
				A2[i][j] = 1.0 / (i + j + 1);
				b2[i] += A2[i][j];
			}
			tx2[i] = 1.0;
		}
		db2[0] = 0.001 * b2[0];

		System.out.printf("cond(A2) = %23.16e%n", Calc.cond(A2));
		System.out.printf("max(A2) = %23.16e%n", Calc.cond(A2) * Calc.vecNormInf(db2) / Calc.vecNormInf(b2));
		x2 = linear.GaussianEliminationPivot.solve(A2, b2);
		System.out.println("x2 =");
		Calc.printVec(x2);
		System.out.printf("res(x2) = %23.16e%n", Calc.vecNormInf(Calc.residual(A2, x2, b2)));
		System.out.printf("err(x2) = %23.16e%n", Calc.vecNormInf(Calc.subVec(tx2, x2)));
		y2 = linear.GaussianEliminationPivot.solve(A2, Calc.addVec(b2, db2));
		System.out.printf("err(y2) = %23.16e%n%n", Calc.vecNormInf(Calc.subVec(tx2, y2)));

		// N3
		for (int i = 0; i < N3; i++) {
			for (int j = 0; j < N3; j++) {
				A3[i][j] = 1.0 / (i + j + 1);
				b3[i] += A3[i][j];
			}
			tx3[i] = 1.0;
		}
		db3[0] = 0.001 * b3[0];

		System.out.printf("cond(A3) = %23.16e%n", Calc.cond(A3));
		System.out.printf("max(A3) = %23.16e%n", Calc.cond(A3) * Calc.vecNormInf(db3) / Calc.vecNormInf(b3));
		x3 = linear.GaussianEliminationPivot.solve(A3, b3);
		System.out.println("x3 =");
		Calc.printVec(x3);
		System.out.printf("res(x3) = %23.16e%n", Calc.vecNormInf(Calc.residual(A3, x3, b3)));
		System.out.printf("err(x3) = %23.16e%n", Calc.vecNormInf(Calc.subVec(tx3, x3)));
		y3 = linear.GaussianEliminationPivot.solve(A3, Calc.addVec(b3, db3));
		System.out.printf("err(y3) = %23.16e%n%n", Calc.vecNormInf(Calc.subVec(tx3, y3)));
	}

}
