package LeetCode;
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int tempRes = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                res = Math.max(res,tempRes);
                tempRes = 0;
            }else { 
                tempRes++;
            }
        }   
        res = Math.max(res,tempRes);
        return res;
    }
}