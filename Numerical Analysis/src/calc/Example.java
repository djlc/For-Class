package calc;

public class Example {

	public static void main(String[] args) {
		double[][] A = {
				{2, -1, 2},
				{-4, 4, -5},
				{6, -7, 10},
		};
			
		// A^-1
		Calc.printMat(LU.inverse(A));
		// A^-1 * A = E の確認
		Calc.printMat(Calc.multipleMat(LU.inverse(A), A));
		
	}

}
