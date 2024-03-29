package pepcoding.hashmap_heap;
import java.util.*;

public class count_distinct_elements_in_every_window_of_size_k {
    
	public static ArrayList<Integer> solution(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<k;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        System.out.println(map);
        for(int i=k;i<arr.length;i++){
            list.add(map.size());
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
            if(map.get(arr[i-k]) == 1){
                map.remove(arr[i-k]);
            }else{
                 map.put(arr[i-k],map.get(arr[i-k])-1);
            }
        }
        list.add(map.size());
        
		return list;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
	}
    
}
