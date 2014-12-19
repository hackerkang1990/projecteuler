package com.hackerkang1990.projecteuler;

import java.io.*;
import java.util.*;

class Solution{

	final static int len = 10000;

	public static void main(String[] args){
		int[] f = new int[len];
		
		System.out.println(sumOfProperDivisors(16));
		System.out.println(sumOfProperDivisors(220));
		System.out.println(sumOfProperDivisors(284));

		for(int i = 2; i < len; i++){
			f[i] = sumOfProperDivisors(i);
		}	
		int sum = 0;
		for(int i = 2; i < len; i++){
			if(f[i] != i && f[i] < len && f[f[i]] == i)
				sum += i;
		}

		System.out.println(sum);
	}
	public static int sumOfProperDivisors(int n){
		int ret = 1;
		int sqrt = (int)Math.sqrt(n);
		if(sqrt * sqrt == n){
			ret += sqrt;
			sqrt--;
		}
		for(int i = 2; i <= sqrt; i++){
			if(n % i == 0){
				ret += i;
				ret += n / i;
			}
		}

		return ret;
	}
}
