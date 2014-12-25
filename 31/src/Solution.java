package com.hackerkang1990.projecteuler;

import java.io.*;
import java.util.*;

class Solution{

	private final int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};

	public static void main(String[] args){
		Solution solution = new Solution();
		System.out.println(solution.coinSums(200));
	}

	public int coinSums(int n){
		int[] f = new int[n+1];
		Arrays.fill(f, 0);
		f[0] = 1;
		for(int coin : coins){
			for(int i = n; i > 0; i--){
				for(int j = i - coin; j >= 0; j -= coin)
					f[i] += f[j];
			}
		}

		return f[n];
	}
}
