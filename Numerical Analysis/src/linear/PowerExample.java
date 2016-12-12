package linear;

public class PowerExample {

	public static void main(String[] args) {
		double[][] A = {
				{8, 1},
				{4, 5},
		};
		double[] x0 = { 1, 1 };
		double eps = 1.0e-10;
		int maxN = 100;
		Power p = new Power(A, x0, eps, maxN);
	}

}
