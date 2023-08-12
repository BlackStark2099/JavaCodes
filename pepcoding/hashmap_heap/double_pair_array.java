package pepcoding.hashmap_heap;
import java.util.*;

public class double_pair_array {
    public static boolean solution(int[] arr) {
        // write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                continue;
            }
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);        
            }
        }


        for(Integer m : arr){
            if(map.containsKey(m*2) && map.containsKey(m)){
                map.put(m,map.get(m) - 1);
                map.put(m*2,map.get(m*2) - 1);
                if(map.get(m*2) == 0){
                    map.remove(m*2);
                }               
                if(map.get(m) == 0){
                    map.remove(m);
                }               
            }
        }


        if(map.size() == 0){
            return true;
        }else{
            return false;
        }

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
