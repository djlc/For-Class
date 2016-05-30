package solver;

public class ParallelChord {

	public static void main(String[] args) {
		solve(6.0, 1.0E-10, 300, true);
		solve(-6.0, 1.0E-10, 300, true);
		solve(6.0, 1.0E-10, 300, false);
		solve(-6.0, 1.0E-10, 300, false);
	}
	
	public static double solve(double x0, double eps, int n, boolean flag) {
		double xk = x0, xk1 = 1.0, error = 0.0;
		int it = 0;
		for (it = 1; it < n; it++) {
			xk1 = xk - Solve.f(xk) / Solve.df(x0);
			error = (flag) ? Solve.relativeError(xk, xk1) : Solve.residualError(xk1);
			if (error < eps) {
				break;
			} else {
				xk = xk1;
			}
		}
		System.out.printf("it = %03d, x = %.16f, e = %.2e%n", it, xk1, Math.min(Math.abs(3.0-xk1), Math.abs(0.5-xk1)));
		return xk1;
	}

}
