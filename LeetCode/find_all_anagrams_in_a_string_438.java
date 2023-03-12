package LeetCode;
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> temp = new HashMap<>();
        int k = p.length();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<p.length();i++){
            if(map.containsKey(p.charAt(i))) map.put(p.charAt(i),map.get(p.charAt(i))+1);
            else map.put(p.charAt(i),1);
        }
        for(int i=0;i<k && i < s.length();i++){
            if(temp.containsKey(s.charAt(i))) temp.put(s.charAt(i),temp.get(s.charAt(i))+1);
            else temp.put(s.charAt(i),1);
        }

        for(int i=k;i<s.length();i++){
            int flag = 0;
            for(char ch : map.keySet()){
                if(temp.containsKey(ch)){
                    int r = map.get(ch);
                    int q = temp.get(ch);
                    if(r != q){
                        flag = 1;
                        break;
                    }
                }else{
                    flag = 1;
                    break;
                }
            }

            if(flag == 0){
                res.add(i-k);
            }

            if(temp.get(s.charAt(i-k)) == 1){
                temp.remove(s.charAt(i-k));
            }else{
                temp.put(s.charAt(i-k),temp.get(s.charAt(i-k))-1);
            }

            if(temp.containsKey(s.charAt(i))) temp.put(s.charAt(i),temp.get(s.charAt(i))+1);
            else temp.put(s.charAt(i),1);

        }

        int i = s.length();
        int flag = 0;
         for(char ch : map.keySet()){
                if(temp.containsKey(ch)){
                    int r = map.get(ch);
                    int q = temp.get(ch);
                    if(r != q){
                        flag = 1;
                        break;
                    }
                }else{
                    flag = 1;
                    break;
                }
            }

        if(flag == 0){
            res.add(i-k);
        }


        
        

        return res;
    }
}
