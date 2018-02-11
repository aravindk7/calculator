package com.app.calculator;

public class Test {

	public static int maxDiff(int arr[]) {
		int n = arr.length-1;
		int maxDiff = -1; // Initialize Result

		int maxRight = arr[n - 1]; // Initialize max element from right side

		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] > maxRight)
				maxRight = arr[i];
			else {
				int diff = maxRight - arr[i];
				if (diff > maxDiff) {
					maxDiff = diff;
				}
			}
		}
		return maxDiff;
	}

	public static void main(String[] args) {
		System.out.println(maxDiff(new int[] {5, 10, 8, 7 ,6, 5}));
	}
}
