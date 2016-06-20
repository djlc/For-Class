package solver;

public class Solve {
	public static double f(double x) {
		return Math.sin(x) / (x - 1.0);
	}
	
	public static double df(double x) {
		return ((x - 1.0) * Math.cos(x) - Math.sin(x)) / ((x-1.0) * (x-1.0));
	}

	public static double g(double x) {
		return (x-1.0) * (x-1.0) * (x-1.0) * (x-1.0);
	}
	
	public static double dg(double x) {
		return 4.0 * (x-1.0) * (x-1.0) * (x-1.0);
	}
	
	public static double relativeError(double x, double y) {
		return Math.abs(x-y) / Math.abs(y);
	}
	
	public static double residualError(double xk) {
		return Math.abs(f(xk));
	}
}
