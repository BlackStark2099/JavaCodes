package pepcoding.hashmap_heap;

import java.util.*;

public class find_anagram_mapping {
	public static int[] anagramMappings(int[] arr1, int[] arr2) {
		HashMap<Integer,Integer> map1 = new HashMap<>();
		HashMap<Integer,List<Integer>> map2 = new HashMap<>();
		int [] res = new int[arr1.length];

		
		
		for(int i=0;i<arr2.length;i++){
 			if(map2.containsKey(arr2[i])){
				 List<Integer> temp = map2.get(arr2[i]);
				 temp.add(i);
				map2.put(arr2[i],temp);
			 } else{
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				map2.put(arr2[i],temp);
			} 
		}

		
		for(int i=0;i<arr1.length;i++){
 			if(map1.containsKey(arr1[i])){
				res[i] = map2.get(arr1[i]).get(map1.get(arr1[i]));
				map1.put(arr1[i],map1.get(arr1[i])+1);
			 } 
            else {
				res[i] = map2.get(arr1[i]).get(0);
				map1.put(arr1[i],1);
			}
		}

		

		

		return res;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		for (int j = 0; j < b.length; j++) {
			b[j] = s.nextInt();
		}
		int[] res = anagramMappings(a, b);
		for (int j = 0; j < res.length; j++) {
			System.out.print(res[j] + " ");
		}
	}

}
