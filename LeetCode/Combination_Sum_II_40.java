package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combination_Sum_II_40 {
    public static void main(String[] args) {
        int [] arr = new int[]{10,1,2,7,6,1,5};
        
        // int [] arr = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println( combine(arr,8));
    }

    public static List<List<Integer>> combine(int [] arr, int k) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        res = solution(new ArrayList<Integer>(),arr,0,k,0);
        return res ;
    }

    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    } 

    public static List<List<Integer>> solution(List<Integer> list,int [] rList,int idx, int target,int achivedtarget){
        List<List<Integer>> res = new ArrayList<>();
        if(achivedtarget == target){
            System.out.println(list);
            res.add(new ArrayList<>(list));
            return res;
        }
        if(achivedtarget > target) return res;
        if(idx >= rList.length) return res;
        list.add(rList[idx]);
        int currElement = rList[idx];
        


        List<List<Integer>> temp = solution(list, rList, idx+1,target,achivedtarget+rList[idx]);
        if(temp.size() != 0) res.addAll(temp);
        list.remove(list.size()-1);
        System.out.println("current element = "+currElement);
        while(idx < rList.length){
            if(idx < rList.length && rList[idx] == currElement){
                idx++;
            }else{
                break;
            }
        }
        temp = solution(list, rList, idx, target,achivedtarget);
        if(temp.size() != 0) res.addAll(temp);
        return res;
    }
}
