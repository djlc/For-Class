package linear;

import util.Calc;

public class LUExample {

	public static void main(String[] args) {
		double[][] A = {
				{ 2, 1, 1, 0 },
				{ 0, 2, 1, 1 },
				{ 2, 0, 2, 1 },
				{ 0, 2, 0, 2 }
		};

		LU.LUDiv(A);
		Calc.printMat(A);

	}

}
