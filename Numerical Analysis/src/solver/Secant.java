package solver;

public abstract class Secant extends Newton {

	// temp
	private double xk, xk1, xk2;

	@Override @Deprecated
	public double df(double x) {
		return 0;
	}

	@Override @Deprecated
	public double iterFunc(double xk) {
		return 0;
	}

	@Override
	public double iterFunc(double xk, double xk1) {
		++cnt;
		return xk1 - f(xk1) * (xk1 - xk) / (f(xk1) - f(xk));
	}

	@Override
	public boolean stop() {
		return (Math.abs(f(xk2)) < 1.0E-12);
	}

	@Override @Deprecated
	public void solve(double x0) {
		return;
	}

	@Override
	public void solve(double x0, double x1) {
		xk = x0; xk1 = x1; xk2 = x0;
		while(!stop()) {
			xk2 = iterFunc(xk, xk1);
			System.out.printf("N = %03d, x = %.16f%n", cnt, xk2);
			xk = xk1; xk1 = xk2;
		}
		apx = xk2;
	}
}
