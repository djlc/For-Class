package solver;

import solver.Solve;

public class Newton {

	public static void main(String[] args) {
		solve(-5.0, 1.0e-10, 50, true);
		solve(5.0, 1.0e-10, 50, true);
	}
	
	public static double solve(double x0, double eps, int n, boolean flag) {
		double xk = x0, xk1 = 0.0, error = 0.0;
		int it = 0;
		for (it = 1; it < n; it++) {
			xk1 = xk - Solve.f(xk) / Solve.df(xk);
			error = (flag) ? Solve.relativeError(xk, xk1) : Solve.residualError(xk1);
			System.out.printf("e_%d = %.2e%n", it, Math.min(Math.abs(-2.0*Math.PI-xk1), Math.abs(2.0*Math.PI-xk1)));
			if (error < eps) {
				break;
			} else {
				xk = xk1;
			}
		}
		System.out.printf("it = %03d, x = %.16f, e = %.2e%n", it, xk1, Math.min(Math.abs(-2.0*Math.PI-xk1), Math.abs(2.0*Math.PI-xk1)));
		return xk1;
	}
}
