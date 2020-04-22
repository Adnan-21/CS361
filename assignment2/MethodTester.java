package adnan;

public class MethodTester {
	public static int algo1(int []arr) {
		int sum = 0, max_sum = 0, i = 0;
		for (i = 0; i < arr.length; i++) {
			
			for (int j = i; j<arr.length; j++) {
				sum = 0;
				for (int k=i; k<=j; k++) {
					sum += arr[k];
					if (sum > max_sum) {
						max_sum = sum;
					}
				}
			}
		}
		return max_sum;
	}
	
	public static int algo2(int []arr) {
		int sum = 0, max_sum = 0;
		for (int i = 0; i<arr.length; i++) {
			sum = 0;
			for (int j = i; j<arr.length; j++) {
				sum += arr[j];
				if (sum > max_sum) {
					max_sum = sum;
				}
			}
		}
		return max_sum;
	}
	
	public static int algo3(int []arr) {
		int sum = 0, max_sum = 0;
		for (int i = 0; i<arr.length; i++) {
			sum += arr[i];
			if (sum > max_sum) {
				max_sum = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
			
		}
		return max_sum;
	}
	
	public static void main(String [] args) {
		int []a = {-1, 12, -3, 14, -4, 3};
		
		System.out.println(algo1(a));
		System.out.println(algo2(a));
		System.out.println(algo3(a));
	}
	
}
