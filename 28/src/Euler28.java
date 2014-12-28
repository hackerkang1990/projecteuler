package com.hackerkang1990.projecteuler;

import java.io.*;

class Euler28{
	public int sumOfDiagonals(int len){
		if(len < 1)
			return -1;
		if(len == 1)
			return 1;
		int sum = 1;
		for(int i = 3, num = 1, base = 2; i <= len; i += 2, base += 2){
			//down
			num += base;
			sum += num;
			//left
			num += base;
			sum += num;
			//up
			num += base;
			sum += num;
			//right
			num += base;
			sum += num;
		}

		return sum;
	}

	public static void main(String[] args){
		Euler28 instance = new Euler28();
		System.out.println(instance.sumOfDiagonals(1001));
	}
}
