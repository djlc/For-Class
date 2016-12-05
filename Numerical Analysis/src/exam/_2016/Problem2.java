package exam._2016;

import linear.Calc;
import linear.LU;

public class Problem2 {

	public static void main(String[] args) {
		double[][] A = {
			{0.5,  0.5,  0.5,  0.5},
			{0.5, -0.5,  0.5, -0.5},
			{0.5,  0.5, -0.5, -0.5},
			{0.5, -0.5, -0.5,  0.5},
		};
		double[][] B = LU.inverse(A);

		System.out.println("A = ");
		Calc.printMat(A);
		System.out.println("A^-1 = ");
		Calc.printMat(B);
		System.out.println("A A^-1 = ");
		Calc.printMat(Calc.multipleMat(A, B));

	}

}
