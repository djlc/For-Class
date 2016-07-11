package calc;

public class Example {

	public static void main(String[] args) {
		double[][] A = {
				{1,5,3},
				{0,6,3},
				{4,6,2}
		};
		double[][] B = {
				{1,0,0},
				{0,1,0},
				{0,0,2}
		};
		
		Calc.printMat(Calc.multipleMat(A, B));
		System.out.printf("||A||_1 = %f, ||A||_inf = %f", Calc.matNorm1(A), Calc.matNormInf(A));
	}

}
