package LeetCode;

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
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
    }
}