package task01;

public class p1 {

	public static void main(String[] args) {
		double a = 0.0, b = 0.0;
		a = Math.sqrt(Math.pow(4.0, 7.0) / Math.pow(7.0, 9.0));
		b = Math.abs(Math.cos(3.0 * Math.PI / 4.0) - Math.pow(Math.E, 6) * Math.sqrt(Math.log(5.0)));
		System.out.printf("a = %f, b = %f", a, b);
	}

}
