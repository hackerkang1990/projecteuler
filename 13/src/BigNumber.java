package net.projecteuler.kang;

import java.math.BigInteger;
import java.io.*;

import java.util.*;

public class BigNumber{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		BigInteger sum = sc.nextBigInteger();
		final int num = 100;
		for(int i = 1; i < num; i++){
			BigInteger tmp = sc.nextBigInteger();
			sum = sum.add(tmp);
		}

		System.out.println(sum);
	}
}

