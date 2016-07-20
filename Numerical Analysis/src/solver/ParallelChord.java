package solver;

public abstract class ParallelChord extends Newton {

	@Override
	public double iterFunc(double xk) {
		return xk - f(xk)/df(x0);
	}

	@Override @Deprecated
	public double iterFunc(double xk, double xk1) {
		return 0;
	}
}
