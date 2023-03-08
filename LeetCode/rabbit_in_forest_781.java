package LeetCode;

import java.util.HashMap;

class Solution {
    public int numRabbits(int[] arr) {
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
    }
}