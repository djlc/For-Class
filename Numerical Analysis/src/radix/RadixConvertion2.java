package radix;

public class RadixConvertion2 {

	public static void main(String[] args) {
		int[] a = {1,4,5};
		int[] b = {4,0,1};
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.print(".");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]);
		}
		System.out.print(" -> ");
		System.out.println(radix(a,b,8));
	}
	
	public static double radix(int[] a, int[] b, int index) {
		double temp1 = 0, temp2 = 0;
		// 整数部分
		for (int i = 0; i < a.length; i++) {
			temp1 = temp1 * index + a[i];
		}
		// 小数部分
		for (int j = b.length - 1; j >= 0 ; j--) {
			temp2 = temp2 / index + b[j];
		}
		return (temp1 + temp2 / index);
	}
}
