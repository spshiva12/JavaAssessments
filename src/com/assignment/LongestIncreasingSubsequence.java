package com.assignment.DS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

	public static void findLIS(int arr[]) {
		if (arr == null || arr.length == 0) {
			return;
		}

		int L[] = new int[arr.length];
		int[] prev = new int[arr.length];
		Arrays.fill(prev, -1);
		L[0] = 1;

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && L[j] > L[i]) {
					L[i] = L[j];
					prev[i] = j;
				}

			}
			L[i]++;
		}
		int maxIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (L[i] > L[maxIndex]) {
				maxIndex = i;
			}
		}

		System.out.println("Longest increasing subsequence length: " + L[maxIndex]);

		List<Integer> lis = new ArrayList<>();
		int currIndex = maxIndex;
		while (currIndex != -1) {
			lis.add(arr[currIndex]);
			currIndex = prev[currIndex];
		}
		Collections.reverse(lis);
		System.out.println("Longest increasing subsequence elements: " + lis);
	}

	public static void main(String[] args) {
		int arr[] = { 3, 4, -1, 0, 6, 2, 3 };
		findLIS(arr);
	}

}
