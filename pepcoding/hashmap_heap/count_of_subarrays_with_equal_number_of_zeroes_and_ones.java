package pepcoding.hashmap_heap;
import java.util.*;

public class count_of_subarrays_with_equal_number_of_zeroes_and_ones {
    public static int solution(int[] arr) {
        // write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum =0;
        int res = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                sum = sum - 1;
            }else{
                sum = sum + 1;
            }
            if(map.get(sum) == null){
                map.put(sum,1);
            }else{
                res = res + map.get(sum);
                map.put(sum,map.get(sum)+1);
            }
        }
        System.out.println(map);
        // for(Integer m : map.keySet()){
        //     res = res + map.get(m)-1;
        // }
        return res;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
    
}
