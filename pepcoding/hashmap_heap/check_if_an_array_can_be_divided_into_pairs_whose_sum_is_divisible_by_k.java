package pepcoding.hashmap_heap;

import java.util.*;

public class check_if_an_array_can_be_divided_into_pairs_whose_sum_is_divisible_by_k {
	
	public static boolean solution(int[] arr, int k){
		 HashMap<Integer,Integer> map  = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int rem = arr[i]%k;
            // if(rem == 0) continue;
            if(rem < 0){
                rem = rem + k;
            }
            if(map.containsKey(rem)){
                map.put(rem,map.get(rem)+1);
            }else{
                map.put(rem,1);
            }
        }

        

        // for(int e: map.keySet()){
        //    int x=k-e;
        //     if(e==0){
        //         if(map.get(e)%2!=0) return false;
        //     }
        //     else{
        //         if(!map.containsKey(x)) return false;
        //         else{
        //             int p= map.get(x);
        //             int q= map.get(e);
        //             if(p!=q) return false;
        //         }
        //     }
        // }
        for(int m : map.keySet()){
            if(m == 0) {
                if(map.get(m) % 2 != 0 ) return false;
            }
            else if(map.containsKey(k-m)){
                if(m == m-k && map.get(m)%2 != 0) return false;
                else {
                    int p = map.get(m);
                    int q = map.get(k-m);
                 if(p!=q){
                    return false;
                }   
                }
            }else {
                return false;
            }
        }
        return true;
		//write your code here

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		
		System.out.println(solution(arr,k));
	}

}
