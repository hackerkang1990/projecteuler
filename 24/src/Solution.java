package com.hackerkang1990.projecteuler;

/*
 * Solve problem 24: Lexicographic permutations
 * Problem site: projecteuler.net
 *
 */

import java.io.*;
import java.util.*;

class Solution{

	private static final int count = 1000000;
	private static final int len = 10;

	public static void main(String[] args){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < len; i++)
			list.add(i);

		int[] f = new int[len];
		f[0] = 1;
		for(int i = 1; i < len; i++){
			f[i] = f[i-1] * i;
		}

		Solution solution = new Solution();
		solution.calculate(list, f, count - 1, 0);

		System.out.println();
	}

	private void calculate(List<Integer> list, final int[] f, int c, int start){
		if(start == len)
			return;
		int pos = c / f[len - start - 1];
		c = c % f[len - start - 1];

		//get number
		System.out.print(list.get(pos));
		//construct new list
		List<Integer> newList = new ArrayList<Integer>();
		int i = 0;
		for(; i < pos; i++)
			newList.add(list.get(i));
		i++;
		for(; i < list.size(); i++)
			newList.add(list.get(i));

		calculate(newList, f, c, start + 1);
	}
}
