package solver;

public class NewtonExample {

	public static void main(String[] args) {
		Newton n = new Newton() {
			public double f(double x) {
				return Math.sin(x) / (x - 1.0);
			}

			public double df(double x) {
				return ((x - 1.0) * Math.cos(x) - Math.sin(x)) / ((x-1.0) * (x-1.0));
			}
		};
		n.solve(-5.0);

		Secant s = new Secant() {
			public double f(double x) {
				return Math.sin(x) / (x - 1.0);
			}
		};
		s.solve(-5.0, -4.0);

		Newton p = new Newton() {
			@Override
			public double f(double x) {
				return (x-1.0) * (x-1.0) * (x-1.0) * (x-1.0);
			}

			@Override
			public double df(double x) {
				return 4.0 * (x-1.0) * (x-1.0) * (x-1.0);
			}

			@Override
			public boolean stop() {
				return Math.abs((apx - iterFunc(apx))/apx) < 1.0E-16;
			}
		};
		p.solve(1.01);
	}

}
