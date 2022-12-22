package ineuron.dsa.arrays.assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Problem2 {
/*
 Given an array of strings words and an integer k, return the k most frequent words.
Your output should be in lexicographical order.

Words = [‘priya’, ‘bhatia’, ‘akshay’, ‘arpit’, ‘priya’, ‘arpit’]
K = 3

Output = [‘arpit’, ‘akshay’, ‘priya’]

 */
	
	public static void main(String[] args) {
	
		String[] words= {"priya","bhatia","akshay","arpit","priya","arpit"};
		int k=3;
		ArrayList<String> reslt=kthMostFrequent(words,k);
		
		System.out.println(Arrays.asList(reslt));
	}
	
	//Time Complexity= O(n*log(n))
	//Space Complexity=O(n)
	static ArrayList<String> kthMostFrequent(String[] str,int k) {
		Map<String,Integer> map=new HashMap<String, Integer>();
		
		for(String s: str) {
			
			if(map.get(s)==null) {
				map.put(s, 1);
			}else {
				map.put(s, map.get(s)+1);
			}
				
			
		}
		
		
		PriorityQueue< Map.Entry<String, Integer>> minHeap= new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				
				if(o1.getValue()==o2.getValue()) {
					return o2.getKey().compareTo(o1.getKey());
				}else {
					return o1.getValue().compareTo(o2.getValue());
				}
				
			}
		});
		ArrayList<String> kthMostFrequentArrayList= new ArrayList<String>();
		
		for(Map.Entry<String,Integer> m: map.entrySet()) {
			
			minHeap.offer(m);
			
			if(minHeap.size()>k)
				minHeap.poll();
		}
		
		for(int i=0;i<k;i++) {
			kthMostFrequentArrayList.add(minHeap.poll().getKey());
		}
		
		Collections.reverse(kthMostFrequentArrayList);
		
		return kthMostFrequentArrayList;
	}
	
	
}
