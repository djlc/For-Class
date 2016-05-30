package solver;

public class Solve {
	public static double f(double x) {
		return x*x*x - 4.0*x*x + 13.0/4.0*x - 3.0/4.0;
	}
	
	public static double df(double x) {
		return 3.0*x*x - 8.0*x + 13.0/4.0;
	}

	public static double relativeError(double x, double y) {
		return Math.abs(x-y) / Math.abs(y);
	}
	
	public static double residualError(double xk) {
		return Math.abs(f(xk));
	}
}
