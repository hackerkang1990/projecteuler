package com.hackerkang1990.projecteuler;

import java.io.*;
import java.util.*;

class Solution{
	
	private final int len = 6;
	private final int pow = 5;

	public static void main(String[] args){
		Solution solution = new Solution();
		System.out.println(solution.digitFifthPowers());
	}

	public int digitFifthPowers(){
		int[] f = new int[10];
		for(int i = 0; i < 10; i++){
			int product = i;
			for(int j = 0; j < pow - 1; j++)
				product *=i;
			f[i] = product;
		}

		int ret = 0;
		for(int i = 1; i < 10; i++){
			int left = i;
			int right = f[i];
			
			ret += dfs(left, right, 0, f);
		}

		return ret - 1;
	}

	private int dfs(int left, int right, int pos, final int[] f){
		if(pos == len - 1)
			return left == right ? left : 0;

		int sum = 0;

		if(left == right)
			sum += left;

		left *= 10;
		for(int i = 0; i < 10; i++)
			sum += dfs(left + i, right + f[i], pos + 1, f);		

		return sum;
	}
}
