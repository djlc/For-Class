package solver;

public class Secant {

	public static void main(String[] args) {
		solve(6.0, 7.0, 1.0E-10, 300, true);
		solve(-6.0, -5.0, 1.0E-10, 300, true);
		solve(6.0, 7.0, 1.0E-10, 300, false);
		solve(-6.0, -5.0, 1.0E-10, 300, false);
	}
	
	public static double solve(double x0, double x1, double eps, int n, boolean flag) {
		double xk = x0, xk1 = x1, xk2 = 0.0, error = 0.0;
		int it = 0;
		for (it = 0; it < n; it++) {
			xk2 = xk1 - Solve.f(xk1) * (xk1 - xk) / (Solve.f(xk1) - Solve.f(xk));
			error = (flag) ? Solve.relativeError(xk1, xk2) : Solve.residualError(xk2);
			if (error < eps) {
				break;
			} else {
				xk = xk1;
				xk1 = xk2;
			}
		}
		System.out.printf("it = %03d, x = %.16f, e = %.2e%n", it, xk2, Math.min(Math.abs(3.0-xk2), Math.abs(0.5-xk2)));
		return xk2;
	}
}
