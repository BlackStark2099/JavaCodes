package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class a_2855 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        
    }
    public static int minimumRightShifts(List<Integer> nums) {
        if(nums.size() == 1) return 0;
        if(nums.size() == 2){
            if(nums.get(0)>nums.get(1)) return 1;
            else return 0;
        }
        int dip = 0;
        int count = 0;
        int prev = nums.get(1)-nums.get(0);
        for(int i=2;i<nums.size();i++){
            if(dip > 0){
                count+=1;
            }
            if(prev>nums.get(i)-nums.get(i-1)){
                dip = dip+1;
            }
            prev = nums.get(i)-nums.get(i-1);
        }
        if (prev > nums.get(0) - nums.get(nums.size()-1)) dip++;
        if(dip == 0) return 0;
        if(dip == 1) return count;
        if(dip > 1) return -1;
        else return -1;
    }
}
