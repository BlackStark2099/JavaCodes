package LeetCode;

import java.util.HashMap;

class Solution {
    public boolean canArrange(int[] arr, int k) {
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

        System.out.println(map);
        

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
    }
}