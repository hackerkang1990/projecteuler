package net.projecteuler.kang;

import java.math.BigInteger;
import java.io.*;

class Solution{

	static final int num = 1000;
	public static void main(String[] args){
		BigInteger sum = new BigInteger("1");
		for(int i = 0; i < num; i++)
			sum = sum.add(sum);

		int ret = 0;
		while(sum.compareTo(BigInteger.ZERO) > 0){
			ret += sum.mod(BigInteger.TEN).intValue();
			sum = sum.divide(BigInteger.TEN);
		}


		System.out.println(ret);
	}
}
