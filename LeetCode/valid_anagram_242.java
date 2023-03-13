package LeetCode;
import java.util.*;


class Solution {
    public boolean isAnagram(String s, String p) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        int res = 0;

        for(int i = 0;i<s.length();i++){
            if(map1.containsKey(s.charAt(i))) map1.put(s.charAt(i),map1.get(s.charAt(i))+1);
            else map1.put(s.charAt(i),1);
        }      

        for(int i=0;i<p.length();i++){
            if(map2.containsKey(p.charAt(i))) map2.put(p.charAt(i),map2.get(p.charAt(i))+1);
            else map2.put(p.charAt(i),1);
        }
         
        for(char ch : map1.keySet()){
            if(!map2.containsKey(ch)){
                return false;
            }else {
                int r = map1.get(ch);
                int q = map2.get(ch);
                if(r!=q){
                    return false;
                }
            }
        }

        for(char ch : map2.keySet()){
            if(!map1.containsKey(ch)){
                return false;
            }else {
                int r = map1.get(ch);
                int q = map2.get(ch);
                if(r!=q){
                    return false;
                }
            }
        }

        return true;
    }
}

