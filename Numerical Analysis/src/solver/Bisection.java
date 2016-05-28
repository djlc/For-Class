package solver;

public class Bisection {
	public static void main(String[] args) {
		System.out.println("x1 = " + solve(1.5, 3.0, 1.0E-12, 300));
		System.out.println("x2 = " + solve(-2.0, -0.5, 1.0E-12, 300));
		System.out.println("x3 = " + solve(0.0, 1.5, 1.0E-12, 300));
		System.out.println(f(2));
	}
	
	static double f(double x) {
		return x*x*x - 2.0*x*x - x + 2.0;
	}
	
	static double solve(double a, double b, double eps, int Nmax) {
		double c = (a + b) / 2.0;
		int it = 0;
		while (it < Nmax && Math.abs(b-a) / 2.0 >= eps) {
			c = (a + b) / 2.0;
			if (f(a)*f(c) > 0) a = c;
			if (f(a)*f(c) == 0) break;
			if (f(a)*f(c) < 0) b = c;
			it++;
		}
		System.out.println("反復回数 : " + it);
		System.out.println("残差 : " + Math.abs(f(c)));
		return c;
	}
}
