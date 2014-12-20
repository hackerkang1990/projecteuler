package com.hackerkang1990.projecteuler;

import java.io.*;
import java.util.*;

class Solution{
	private static enum State{
		HighCard, OnePair, TwoPair, ThreeOfAKind, Straight, Flush, FullHoush, FourOfAKind, StraightFlush, RoyalFlush
	}
	private static class Card{
		int num;		// the card' number
		int count;		// how much kinds of card
		Card(int num, int count){
			this.num = num;
			this.count = count;
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int ret = 0;
		while(sc.hasNext()){
			int[] a = new int[13];
			int[] b = new int[13];
			boolean flushA = true;
			boolean flushB = true;
			char color = 'A';
			Arrays.fill(a, 0);
			for(int i = 0; i < 5; i++){
				String str = sc.next();
				a[changeToNum(str.charAt(0))]++;
				if(i == 0)
					color = str.charAt(1);
				else if(str.charAt(1) != color)
					flushA = false;
			}
			for(int i = 0; i < 5; i++){
				String str = sc.next();
				b[changeToNum(str.charAt(0))]++;
				if(i == 0)
					color = str.charAt(1);
				else if(str.charAt(1) != color)
					flushB = false;
			}

			if(cmp(a, flushA, b, flushB) == true)
				ret++;
		}

		System.out.println(ret);
	}
	private static boolean cmp(int[] a, boolean flushA, int[] b, boolean flushB){
		List<Card> listA = new ArrayList<Card>();
		for(int cnt = 5; cnt >= 1; cnt--){
			for(int i = 12; i >= 0; i--){
				if(a[i] == cnt)
					listA.add(new Card(i, cnt));
			}
		}
		List<Card> listB = new ArrayList<Card>();
		for(int cnt = 5; cnt >= 1; cnt--){
			for(int i = 12; i >= 0; i--){
				if(b[i] == cnt)
					listB.add(new Card(i, cnt));
			}
		}

		//check state
		State stateA = checkState(listA, flushA);
		State stateB = checkState(listB, flushB);

		if(stateA.ordinal() > stateB.ordinal())
			return true;
		else if(stateA == stateB){
			for(int i = 0; i < listA.size(); i++)
				if(listA.get(i).num > listB.get(i).num)
					return true;
				else if(listA.get(i).num < listB.get(i).num)
					return false;
			return false;
		}

		return false;
	}

	private static State checkState(List<Card> list, boolean flush){
		boolean straight = false;
		if(list.size() == 5 && list.get(0).num - list.get(4).num == 4)
			straight = true;
		if(straight == true && flush == true){
			if(list.get(0).num == 12)
				return State.RoyalFlush;
			return State.StraightFlush;
		}
		if(list.get(0).count >= 4)
			return State.FourOfAKind;
		if(list.get(0).count == 3 && list.get(1).count == 2)
			return State.FullHoush;
		if(flush == true)
			return State.Flush;
		if(straight == true)
			return State.Straight;
		if(list.get(0).count == 3)
			return State.ThreeOfAKind;
		if(list.get(0).count == 2 && list.get(1).count == 2)
			return State.TwoPair;
		if(list.get(0).count == 2)
			return State.OnePair;

		return State.HighCard;
	}

	private static int changeToNum(char ch){
		if(ch >= '2' && ch <= '9')
			return ch - '2';
		if(ch == 'T')
			return 8;
		if(ch == 'J')
			return 9;
		if(ch == 'Q')
			return 10;
		if(ch == 'K')
			return 11;
		if(ch == 'A')
			return 12;

		return -1;
	}
}
