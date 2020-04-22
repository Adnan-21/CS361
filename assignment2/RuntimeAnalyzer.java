package adnan;

import java.util.Random;

public class RuntimeAnalyzer {
	public static int algo1(int []arr) {
		int sum = 0, max_sum = 0, i = 0, count = 0;
		for (i = 0; i < arr.length; i++) {
			
			for (int j = i; j<arr.length; j++) {
				sum = 0;
				for (int k=i; k<=j; k++) {
					sum += arr[k];
					count++;
					if (sum > max_sum) {
						max_sum = sum;
					}
				}
			}
		}
		return count;
	}
	
	public static int algo2(int []arr) {
		int sum = 0, max_sum = 0, count = 0;
		for (int i = 0; i<arr.length; i++) {
			sum = 0;
			for (int j = i; j<arr.length; j++) {
				sum += arr[j];
				count++;
				if (sum > max_sum) {
					max_sum = sum;
				}
			}
		}
		return count;
	}
	
	public static int algo3(int []arr) {
		int sum = 0, max_sum = 0, count = 0;
		for (int i = 0; i<arr.length; i++) {
			sum += arr[i];
			count++;
			if (sum > max_sum) {
				max_sum = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
			
		}
		return count;
	}
	
	public static void main(String [] args) {
		
		System.out.println("AVERAGE NUMBER OF ASSIGNMENT STATEMENTS EXECUTED OVER 2000 TRIALS: ");
		System.out.println("Size\tAlgo1\tAlgo2\tAlgo3");
		for (int i = 5; i<=50; i=i+5) {
			
			int sum1 = 0, sum2 = 0, sum3 = 0;
			int av1 = 0, av2 = 0, av3 = 0;
			int []a = new int[i];
			for (int k = 0; k<2000; k++) {
				for (int j = 0; j<i; j++) {
					a[j] = (int)(Math.random()*(99-(-10)+1));
				}
				sum1 += algo1(a);
				sum2 += algo2(a);
				sum3 += algo3(a);
			}
			av1 = sum1/2000;
			av2 = sum2/2000;
			av3 = sum3/2000;
			System.out.println(i+"\t"+av1+"\t"+av2+"\t"+av3);
		}
	}
}
