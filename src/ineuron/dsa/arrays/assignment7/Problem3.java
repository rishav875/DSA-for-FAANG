package ineuron.dsa.arrays.assignment7;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem3 {
	/*
	 3. An e-commerce site tracks the purchases made each day. The product that is purchased
the most one day is the featured product for the following day. If there is a tie for the product
purchased most frequently, those product names are ordered alphabetically ascending and
the last name in the list is chosen.[Amazon]
['yellowShirt', 'redHat', 'blackShirt', 'bluePants', 'redHat','pinkHat', 'blackShirt', 'yellowShirt',
'greenPants', 'greenPants', 'greenPants']
'yellowShirt' - 2
'redHat' - 2
'blackShirt' - 2
'bluePants' - 1
'greenPants' - 3
'pinkHat' - 1
Output - greenPants
	 */
	
	public static void main(String[] args) {
		String[] arr= {"yellowShirt", "redHat", "blackShirt", "bluePants", "redHat","pinkHat", "blackShirt", "yellowShirt",
				"greenPants", "greenPants", "greenPants"};
		
		String ans= productPurchasedMostFrequently(arr);
		System.out.println(ans);
	}
//Time Complexity= n*log(n)
//Space Complexity=n
	private static String productPurchasedMostFrequently(String[] arr) {
		
		Map<String,Integer> map= new HashMap<String, Integer>();
		
		for(String str: arr) {
			
			if(map.containsKey(str)) {
				map.put(str,map.get(str)+1);
			}else {
				map.put(str,1);
			}
		}
		
		
		
		PriorityQueue<Map.Entry<String, Integer>> heap= new PriorityQueue<Map.Entry<String,Integer>>(new Comparator<Map.Entry<String,Integer>>() {

			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				if(o1.getValue().equals(o2.getValue())) {
					return o1.getKey().compareTo(o2.getKey());
				}else
					return o2.getValue().compareTo(o1.getValue());
				
			}
		});
		
		
		
		for(Map.Entry<String, Integer> m : map.entrySet()) {
			heap.add(m);
			
		}
		
		
		
		
		
		String ans=heap.poll().getKey();
		
		return ans;
	}


}
