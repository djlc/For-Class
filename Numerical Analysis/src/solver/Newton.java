package solver;

public abstract class Newton implements Solver {

	// 初期値
	protected double x0;

	// 近似解
	protected double apx;

	// 真解
	protected double trx;

	// 反復回数
	protected int cnt = 0;

	@Override
	public double iterFunc(double xk) {
		return xk - f(xk)/df(xk);
	}

	@Override @Deprecated
	public double iterFunc(double xk1, double xk2) {
		return 0;
	}

	@Override
	public boolean stop() {
		return (Math.abs(f(apx)) < 1.0E-12);
	}

	@Override
	public void solve(double x0) {
		this.x0 = x0;
		apx = x0;
		while(!stop()) {
			++cnt;
			apx = iterFunc(apx);
			System.out.printf("N = %03d, x = %.16f%n", cnt, apx);
		}
	}

	@Override @Deprecated
	public void solve(double x0, double x1) {
		return;
	}

}
