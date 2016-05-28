package solver;

import function.*;
import var.*;

public class newton {

	public static void main(String[] args) {
		double a = solve(-6.0, 1.0E-7, 500);
		double b = solve(6.0, 1.0E-7, 500);
		double c = solve( new Polynomial( new Monomial[]{
					new Monomial(1, new Power("x", 3) ),
					new Monomial(4, new Power("x", 2) ),
					new Monomial(13.0/4.0, new Power("x", 1) ),
					new Monomial(3.0/4.0, new ConstFunction(1.0))
				}), "x", -6.0, 1.0E-7, 500);
		System.out.println(c);
		System.out.printf("x = %.16f, %.18f%n", a, b);
		System.out.printf("f(%.16f) = %.16f%nf(%.16f) = %.16f%n", a, f(a), b, f(b));
	}
	
	public static double solve(double x0, double eps, int n) {
		double xk = x0, xk1 = 1;
		for (int i = 0; i < n; i++) {
			xk1 = xk - f(xk) / df(xk);
			if (relativeError(xk, xk1) < eps) {
				break;
			} else {
				xk = xk1;
			}
		}
		return xk1;
	}	

	public static double solve(Polynomial f, String var, double x0, double eps, int n) {
		Polynomial fp = f.D(var); fp.print();
		R xk = new R(x0), xk1 = new R(1);
		for (int i = 0; i < n; i++) {
			xk1 = (R)(xk.sub(f.set(var,xk).getValue().sub(fp.set(var,xk).getValue())));
			if (relativeError(xk.num, xk1.num) < eps) {
				break;
			} else {
				xk = xk1;
			}
		}
		return xk1.num;
	}

	public static double f(double x) {
		return x*x*x - 4.0*x*x + 13.0/4.0*x - 3.0/4.0;
	}
	
	public static double df(double x) {
		return 3.0*x*x - 8.0*x + 13.0/4.0;
	}
	
	public static double relativeError(double x, double y) {
		return Math.abs(x-y) / Math.abs(y);
	}
}
