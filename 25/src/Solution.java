package com.hackerkang1990.projecteuler;

import java.io.*;
import java.util.*;
import java.math.*;

class Solution{

	final static int len = 1000;

	public static void main(String[] args){
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		BigInteger c;
		int term = 2;
		while(b.toString().length() < len){
			c = a.add(b);
			a = b;
			b = c;
			term++;
		}

		System.out.println(term);
	}
}
