package LeetCode;

public class house_robber_II_213 {
    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,1};
        rob(arr);
    }

    public static int rob(int[] nums) {
        int n = nums.length; 
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        int [] dp_1 = new int[n-1];
        int [] dp_0 = new int[n-1];
        dp_0 [0] = 0;
        dp_1 [0] = nums[0];

        for(int i=1;i<n-1;i++){
            dp_1[i] = dp_0[i-1] + nums[i];
            dp_0[i] = Math.max(dp_1[i-1],dp_0[i-1]);
        }

        int res = Math.max(dp_1[n-2], dp_0[n-2]);

        dp_1 = new int[n-1];
        dp_0 = new int[n-1];

        dp_0 [0] = 0;
        dp_1 [0] = nums[1];

        for(int i=1;i<n-1;i++){
            dp_1[i] = dp_0[i-1] + nums[i+1];
            dp_0[i] = Math.max(dp_1[i-1],dp_0[i-1]);
        }

        return Math.max(Math.max(dp_1[n-2], dp_0[n-2]), res);
    }
}
