package exam._2016;

import linear.Calc;

public class Problem6 {

	public static void main(String[] args) {
		Calc.printE(cond(0.2, Math.sqrt(1.0 - 0.2*0.2), 10));
		Calc.printE(cond(0.2, Math.sqrt(1.0 - 0.2*0.2), 100));
		Calc.printE(cond(0.2, Math.sqrt(1.0 - 0.2*0.2), 200));
	}
	
	public static double cond(double c, double s, int n) {
		double[][] C = new double[n][n];
		double[][] S = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					C[i][j] = 1.0;
					S[i][j] = Math.pow(s, i);
				}
				if (i > j) {
					C[i][j] = -c;
				}
			}
		}
		
		return Calc.cond(Calc.multipleMat(C, S));
	}
}
