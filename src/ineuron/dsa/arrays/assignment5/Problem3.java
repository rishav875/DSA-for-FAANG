package ineuron.dsa.arrays.assignment5;

public class Problem3 {
/*
 Given a positive integer num, write a program that returns True if num is a perfect
square else return False. Do not use built-in functions like sqrt. Also, talk about the time
complexity of your code.
Test Cases:
Input: 16
Output: True
Input: 14
Output: False
 */
	
	public static void main(String[] args) {
		
		int x=16;
		System.out.println(checkPerfectSqareUsingBinarySearch(x));
		
	}
	
	//Time Complexity=O(logn) 
	static boolean checkPerfectSqareUsingBinarySearch(int x) {
		boolean status= false;
		int start=0;
		int end=x;
		
		while(start<=end) {
			
			int mid=start+(end-start)/2;
			
			if(mid*mid==x) {
				status= true;
				break;
			}
			
			if(mid*mid<x)
				start=mid+1;
			else
				end=mid-1;
		}
		
		return status;
	}
}
