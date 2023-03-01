package JavaCodes.hashmap_heap;

import java.util.HashMap;
import java.util.Scanner;

public class longest_subarray_with_equal_number_of_zeroes_and_ones {
    
    public static int solution(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum =0;
        int res = 0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                sum = sum - 1;
            }else{
                sum = sum + 1;
            }
            if(map.get(sum) == null){
                map.put(sum,i);
            }else{
                max = Math.max(i-map.get(sum),max);
            }
        }
        // System.out.println(map);
        // for(Integer m : map.keySet()){
        //     res = res + map.get(m)-1;
        // }
        return max;
        // write your code here

        // return 0;
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
