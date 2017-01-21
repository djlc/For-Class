package eigen;

public class JacobiExample {

	public static void main(String[] args) {
		double[][] A = {
			{ 2,-1, 0, 0},
			{-1, 2, 0, 0},
			{ 0, 0, 4, 1},
			{ 0, 0, 1, 4},
		};
		Jacobi j = new Jacobi(A, 1.0e-10, 10);
	}

}
