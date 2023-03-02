package JavaCodes.hashmap_heap;

import java.util.HashMap;
import java.util.Scanner;

public class count_of_subarrays_having_sum_equals_to_k {
    public static int solution(int[] nums, int k){
		// write your code here
		  HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0; 
        int res = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            if(map.get(sum-k) != null){
                res = res + map.get(sum-k);
            }
            if(map.get(sum) == null){
                map.put(sum,1);
            }else{
                map.put(sum,map.get(sum)+1);
            }
        }
        return res;
		// return 0;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        System.out.println(solution(arr,target));
	}
    
}
