package task02;

public class RadixConvertion {

	public static void main(String[] args) {
		double z = 2016.0418;
		radix(z, 2);
		radix(z, 8);
	}

	// 10進数 -> n進数
	public static void radix(double z, int n) {
		// 整数部分
		int x = (int)z;
		
		// 小数部分
		double y = z - x;
		
		// 配列
		int[] a = new int[100];
		int[] b = new int[100];
		
		// 整数部分
		int i = 0;
		while(x != 0) {
			a[i] = x % n;
			x /= n;
			i++;
		}
		
		// 小数部分
		int j = 0;
		while(Math.abs(y) > 0.0000000001) {
			b[j] = (int)(n*y);
			y = n*y - b[j];
			j++;
		}
		
		// 整数部分の書き出し
		for (int i_2 = i-1; i_2 >= 0; i_2--) {
			System.out.print(a[i_2]);
		}
		
		// .
		System.out.print(".");
		
		// 小数部分の書き出し
		for (int j_2 = 0; j_2 < j; j_2++) {
			System.out.print(b[j_2]);
		}
		System.out.println("");
	}
}