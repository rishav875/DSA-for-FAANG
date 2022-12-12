package ineuron.dsa.assignment5;

public class Problem1 {
/*
 Compute and return the square root of x, where x is guaranteed to be a non-negative
integer. And since the return type is an integer, the decimal digits are truncated and only
the integer part of the result is returned. Also, talk about the time complexity of your
code.
Test Cases:
Input: 4
Output: 2
Input: 8
Output: 2
Explanation: The square root of 8 is 2.8284...., the decimal part is truncated and 2 is
returned.
Hint: Try to use a modified binary search approach for an optimized solution
 */
	
	public static void main(String[] args) {
		
		int x=8;
	
		System.out.println(square_root(x));
		
		
	}
	
	//Time Complexity= O(logn)
	private static int square_root(int x) {
		double result=1;
		double decimalValue=0.1;
		int start=1;
		int end=x/2;
		if(x==1 || x==0)
			return x;
		while(start<=end) {
			
			int mid=start+(end-start)/2;
			
			if(mid*mid==x)
				return mid;
			
			if(mid*mid>x) {
				end=mid-1;
				result=end;
			}
			else {
				start=mid+1;
				result=start;
			}
			
		}
		
		//Taking precision upto 2 places
		for(int i=0;i<2;i++) {
			
			while(result*result<x) {
				result+=decimalValue;
			}
			
			result-=decimalValue;
			
			decimalValue/=10;
		}
		
		
		
		return (int)Math.floor(result);
	}
}
