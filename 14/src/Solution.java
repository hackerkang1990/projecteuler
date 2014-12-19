package net.projecteuler.kang;

import java.io.*;
import java.util.*;


public class Solution{
	static final int num = 1000000;
	public static void main(String[] args){
		int[] f = new int[num];
		Arrays.fill(f, Integer.MAX_VALUE);

		//dfs(f, 1, 1);
		
		int ret = 1;
		f[1] = 1;
		for(int i = 2; i < num; i++){
			int j = i;
			int len = 0;
			while(true){
				while((j & 1) == 0){
					j = j >> 1;
					len++;
				}	
				if(j < i)
					break;
				if(j < 0)
					System.out.println("bad");
				j = j * 3 + 1;
				len++;
			}
			if(j < 0 || j > num)
				System.out.println("j is " + j);

			f[i] = f[j] + len;
			ret = Math.max(ret, f[i]);
		}

		System.out.println(ret);
	}

	private static void find(int f[], int n){
		int len = 0;
		int i = n;
		while(true){
			while((i & 1) == 0){
				i = i >> 1;
				len++;
			}
			if(i < num && f[i] != Integer.MAX_VALUE){
				len += f[i];
				break;
			}
			//odd
			i = i * 3 + 1;
			len++;
		}

		f[n] = len;
	}
	private static void dfs(int f[], int n, int len){
		if(n <= 0 || n >= num || f[n] != Integer.MAX_VALUE)
			return ;
		f[n] = len;
		dfs(f, n*2, len+1);
		n--;
		if(n > 0 && n % 3 == 0)
			dfs(f, n/3, len+1);	
	}
}
