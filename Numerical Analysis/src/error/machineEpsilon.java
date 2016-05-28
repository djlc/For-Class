package error;

public class machineEpsilon {

	public static void main(String[] args) {
		double e_1 = 1.0, temp_1 = 0.0;
		float e_2 = 1.0f, temp_2 = 0.0f;
		
		// 倍精度
		while(1.0 + e_1 > 1.0) {
			temp_1 = e_1;
			e_1 /= 2.0;
		}
		System.out.println("double : " + temp_1);
		
		// 単精度
		while(1.0f + e_2 > 1.0f) {
			temp_2 = e_2;
			e_2 /= 2.0f;
		}
		System.out.println("float : " + temp_2);
	}

}
