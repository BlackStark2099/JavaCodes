package pepcoding.hashmap_heap;
import java.util.*;

public class rabbit_in_forest {
    public static int solution(int[] arr) {
        // write your code here
		HashMap<Integer,Integer> map =  new HashMap<>();
        int res =0 ;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                res = res + 1 ;
                continue;
            }
            if(!map.containsKey(arr[i])){
                map.put(arr[i],arr[i]);
            }else{
                map.put(arr[i],map.get(arr[i])-1);
                if(map.get(arr[i]) == 0) {
                    res = res + arr[i] + 1;
                    map.remove(arr[i]);
                }
            }
            // System.out.println(map);
        }   
        for(Integer m : map.keySet()){
            res = res + m + 1;
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
		System.out.println(solution(arr));
	}
    
}
