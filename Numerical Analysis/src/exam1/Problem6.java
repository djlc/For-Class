package exam1;

import solver.Solve;

public class Problem6 {

	public static void main(String[] args) {
		newton(-25.0, 1.0e-8, 200, true);
		secant(20.0, 15.0, 1.0e-12, 200, false);
	}

	private static double f(double x) {
		return x*x*x - 3*x + 2;
	}

	private static double df(double x) {
		return 3*x*x - 3;
	}
	
	private static double newton(double x0, double eps, int n, boolean flag) {
		double xk = x0, xk1 = 0.0, error = 0.0;
		int it = 0;
		for (it = 1; it < n; it++) {
			xk1 = xk - f(xk) / df(xk);
			error = (flag) ? Solve.relativeError(xk, xk1) : Solve.residualError(xk1);
			if (error < eps) {
				break;
			} else {
				xk = xk1;
			}
		}
		System.out.printf("it = %03d, x = %.16f%n", it, xk1);
		return xk1;
	}
	
	private static double secant(double x0, double x1, double eps, int n, boolean flag) {
		double xk = x0, xk1 = x1, xk2 = 0.0, error = 0.0;
		int it = 0;
		
		for (it = 0; it < n; it++) {
			xk2 = xk1 - f(xk1) * (xk1 - xk) / (f(xk1) - f(xk));
			error = (flag) ? Solve.relativeError(xk1, xk2) : f(xk2);
			System.out.printf("e_%d = %.2e%n", it, error);
			if (error < eps) {
				break;
			} else {
				xk = xk1;
				xk1 = xk2;
			}
			System.out.printf("it = %03d, x = %.16f, e_%d = %.2e%n", it, xk2, it, Math.min(Math.abs(-2-xk2), Math.abs(1-xk2)));
		}
		return xk2;
	}
}
