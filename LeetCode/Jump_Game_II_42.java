package LeetCode;

public class Jump_Game_II_42 {
    public static void main(String[] args) {
        int [] arr = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};
        jump(arr);
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        int [] tab = new int[n];
        boolean[] isComp = new boolean[n];
        tab[n-1] = 0;
        for(int i=n-2;i>=0 ;i--){
            if(nums[i] == 0){
                tab[i] = 0;
                isComp[i] =true;
                continue;
            } 
            int res = 100001; 
            for(int j=1;j<=nums[i];j++){
                if((i+j)<nums.length){
                    if(res > tab[i+j] && !isComp[i+j]){
                        res = tab[i+j];
                    }
                }
            }
            tab[i] = res+1;
            System.out.println("i = "+i+" res = "+tab[i]);
        }
        System.out.println(tab[0]);
        return tab[0];
    }
    
}
