package ineuron.dsa.arrays.assignment6;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Problem3 {
	/*
	 Find the k closest points to the origin.
Points = [[1, 3], [-2, 2]]
K = 1
Output = [-2,2]

	 */
	
	public static void main(String[] args) {
		
		int[][] points= {{1,3},{-2,2}};
		int	k=1;
		
		for(int[] ans: kClosestPoints(points,k))
		System.out.println("["+ans[0]+","+ans[1]+"]");
		
		
	}
	
	//Time Complexity= O(n*log(n))
	//Space Complexity=O(n)
	static int[][] kClosestPoints(int[][] points, int k){
		int[][] ans= new int[k][2];
		
		Map<int[], Integer> map= new HashMap<int[], Integer>();
		
		for(int[] point: points) {
			
			int x=point[0];
			int y=point[1];
		
			
			map.put(point,x*x+y*y );
		}
		
		PriorityQueue<Map.Entry<int[], Integer>> heap= new PriorityQueue<Map.Entry<int[], Integer>>(new Comparator<Map.Entry<int[], Integer>>() {

			@Override
			public int compare(Entry<int[], Integer> o1, Entry<int[], Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		
		for(Map.Entry<int[], Integer> m: map.entrySet()) {
			
			heap.add(m);
			
			if(heap.size()>k) {
				heap.poll();
			}
		}
			for(int i=0;i<k;i++) {
				int[] temp=heap.poll().getKey();
//				for(int t: temp)
//				System.out.println(t);
				ans[i][0]=temp[0];
				ans[i][1]=temp[1];
			}
			
		
		
		return ans;
	}

}
