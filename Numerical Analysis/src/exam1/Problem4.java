package exam1;

public class Problem4 {

	public static void main(String[] args) {
		double x = 4.0e+6, y = 4.0e-6;
		System.out.printf("%.16f%n", h(x,y));
		System.out.printf("%.16e%n", f(x,y));
		System.out.printf("%.16e%n", g(x,y));
		System.out.println((1+Math.sqrt(5))/2);
	}

	private static double f(double x, double y) {
		return 1.0 / (Math.sqrt(x+y) - Math.sqrt(x));
	}
	
	private static double g(double x, double y) {
		return (Math.sqrt(x+y) + Math.sqrt(x)) / y;
	}
	
	private static double h(double x, double y) {
		return Math.sqrt(x+y) - Math.sqrt(x);
	}
}
