package LeetCode;

import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] arr) {
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
        
    }
}