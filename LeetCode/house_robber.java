package LeetCode;
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length == 1)  return nums[0];
        int n = nums.length;
        int [] dp_0 = new int [n];
        int [] dp_1 = new int [n];
        dp_1[0] = nums[0];
        dp_0[0] = 0;
        for(int i = 1;i<n;i++){
            //include 
            dp_1[i] = dp_0[i-1]+nums[i];
            dp_0[i] = Math.max(dp_1[i-1],dp_0[i-1]);
            System.out.println(dp_0[i]+ "  "+dp_1[i]);
        }

        return Math.max(dp_0[n-1],dp_1[n-1]);
    }
}