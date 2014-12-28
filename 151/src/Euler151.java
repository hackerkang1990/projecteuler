package com.hackerkang1990.projecteuler;

import java.io.*;
import java.util.*;

class Euler151{
	double theSumOfProbility;

	void nextBatch(double probility, int numOnes, int a2, int a3, int a4, int a5){
		int sum = a2 + a3 + a4 + a5;
		if(sum == 1 && a5 == 1){
			theSumOfProbility += probility * numOnes;
			return;
		}
		
		if(sum == 1)
			numOnes++;

		if(a2 > 0) nextBatch(probility * a2 / sum, numOnes, a2 - 1, a3 + 1, a4 + 1, a5 + 1);
		if(a3 > 0) nextBatch(probility * a3 / sum, numOnes, a2, a3 - 1, a4 + 1, a5 + 1);
		if(a4 > 0) nextBatch(probility * a4 / sum, numOnes, a2, a3, a4 - 1, a5 + 1);
		if(a5 > 0) nextBatch(probility * a5 / sum, numOnes, a2, a3, a4, a5 - 1);
	}
	double findExpectedProbility(){
		theSumOfProbility = 0.0;
		nextBatch(1.0, 0, 1, 1, 1, 1);
		return theSumOfProbility;
	}

	public static void main(String[] args){
		Euler151 euler151 = new Euler151();
		System.out.println(euler151.findExpectedProbility());
	}
}
