package linear;

public class GaussSeidelExample {
	public static void main(String[] args) {
		double[][] A = {
				{6, 1, 1, 1, 0},
				{1, 7, 1, 1, 1},
				{0, 1, 8, 1, 1},
				{0, 0, 1, 9, 1},
				{0, 0, 0, 1, 10},
		};
		double[] b = { 9, 11, 11, 11, 11 };
		double[] x0 = { 0, 0, 0, 0, 0};
		double eps = 1.0E-10;
		int N = 100;
		
		GaussSeidel g = new GaussSeidel(A, b);
		Calc.printVec(g.solve(x0, eps, N, MODE.REL_ERR, NORM.INF));
	}
}
