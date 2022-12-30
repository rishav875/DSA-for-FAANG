package ineuron.dsa.arrays.assignment7;

import java.util.Arrays;

public class Problem1 {
	/*
	 1. Given an integer array nums of length n and an integer target, find three integers in nums
such that the sum is closest to the target.[Amazon]
You need to return the sum of three integers.
For example:arr = [-1, 2, 1, -4], target = 1
Output: 2
Explanation: [-1+2+1] = 2 (The sum that is closest to the target is 2)
url:https://leetcode.com/problems/3sum-closest/description/
	 */
	
	public static void main(String[] args) {
		int[] arr= {-1, 2, 1, -4};
		int target=1;
		
		int ans= sumClosestToTarget(arr,target);
		System.out.println(ans);
	}
//Time Complexity= O(n*log(n))
	private static int sumClosestToTarget(int[] arr, int target) {
		Arrays.sort(arr);
		
		int closestSum=0;
		
		int differece= Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length-2;i++) {
			int j=i+1;
			int k=arr.length-1;
			
			while(j<k) {
				int sum=arr[i]+arr[j]+arr[k];
				if(sum==target)
					return sum;
				else if(sum>target)
					k-=1;
				else
					j+=1;
				
				int differeceInEachIteration=Math.abs(target-sum);
				//System.out.println(differeceInEachIteration);
				//System.out.println("SUM: "+sum);
				if(differeceInEachIteration<differece) {
					differece=differeceInEachIteration;
					closestSum=sum;
				}
				
			}
			
		}
		
		return closestSum;
	}

}
