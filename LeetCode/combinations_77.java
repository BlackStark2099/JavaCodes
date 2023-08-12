package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class combinations_77 {
    public static void main(String[] args) {
        System.out.println(combine(1, 1));
    }
    
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<n+1;i++){
            list.add(i);
        }
         List<List<Integer>> res = new ArrayList<>();
        return solution(new ArrayList<Integer>(),list,res,k);
    }
    public static List<List<Integer>> solution(List<Integer> list,List<Integer> rList, List<List<Integer>> res, int k){
        res = new ArrayList<>();
        if(rList.size() == 0){
            if(list.size() == k){
                res.add(list);
            }
            return res;
        }
        ArrayList<Integer> trList = new ArrayList<>(rList);
        ArrayList<Integer>tNlist = new ArrayList<>(list);
        ArrayList<Integer>tlist = new ArrayList<>(list);
        tlist.add(rList.get(0));
        trList.remove(0);
        res.addAll(solution(tlist, trList, res, k));
        res.addAll(solution(tNlist, trList, res, k));
        return res;
    }
}
