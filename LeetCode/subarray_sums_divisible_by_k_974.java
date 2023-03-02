package LeetCode;

import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0; 
        int res = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            int temp  = sum % k;
            if(temp < 0){
                temp  = temp + k;
            }
            if(map.get(temp) != null){
                res = res + map.get(temp);
            }
            if(map.get(temp) == null){
                map.put(temp,1);    
            }
            else{
                map.put(temp,map.get(temp)+1);
            }

        }
        return res;
    }
}