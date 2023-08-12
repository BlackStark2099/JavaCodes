package pepcoding.hashmap_heap;
import java.util.*;

public class check_airthematic_progression {




    public static boolean solution(int[] arr) {
		if(arr.length < 3) return true;

		// write your code here
		Set<Integer> set = new HashSet<Integer>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			if(max < arr[i]){
				max = arr[i];
			}
			if(min > arr[i]){
				min = arr[i];
			}
			set.add(arr[i]);
		}

		int d = (max-min)/(arr.length-1);
		// System.out.println(d);
		// System.out.println(max);
		// System.out.println(min);
		
		int ele = min;
		for(int i=1;i<arr.length;i++){
			if(set.contains(ele+d)){
				ele = ele + d;
			}else{
				return false;
			}
		}
        
        return true;
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
