package exam._2014;

import util.Calc;

public class Problem1 {

	public static void main(String[] args) {
		double[] y = new double[100];
		for (int i = 0; i < 100; i++) {
			y[i] = i+1;
		}
		System.out.printf("||y||_3 = %.2e", Calc.vecNorm(y, 3));
	}

}
