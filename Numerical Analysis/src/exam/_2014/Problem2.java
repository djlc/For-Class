package exam._2014;

import linear.Calc;
import linear.GaussianElimination;
import linear.GaussianEliminationPivot;

public class Problem2 {

	public static void main(String[] args) {
		double[][] A = {
				{0.0001, 1, 1, 1, 1},
				{1, 2, 1, 1, 1},
				{1, 1, 3, 1, 1},
				{1, 1, 1, 4, 1},
				{1, 1, 1, 1, 5},
		};
		double[] b = {4.0001, 6, 7, 8, 9};
		double[] tx = {1, 1, 1, 1, 1};
		System.out.printf("%.2e\n", Calc.vecNorm2(Calc.subVec(GaussianElimination.solve(A, b), tx)));
		System.out.printf("%.2e\n", Calc.vecNorm2(Calc.subVec(GaussianEliminationPivot.solve(A, b), tx)));
	}

}
