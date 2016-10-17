package calc;

public class Example {

	public static void main(String[] args) {
		double[][] A = {
				{1, -2, 3},
				{3, 1, -5},
				{-2, 6, -9},
		};
		
		double[] b = { 1, -4, -2 };
		
		Calc.printVec(GaussianElimination.solve(A, b));
		Calc.printVec(GaussianEliminationPivot.solve(A, b));;
	}

}
