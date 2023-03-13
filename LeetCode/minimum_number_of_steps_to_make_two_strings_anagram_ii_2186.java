package LeetCode;
import java.util.*;


class Solution {
    public int minSteps(String s, String p) {
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
                res = res + map1.get(ch);
                map2.put(ch,map1.get(ch));
            }
        }

        for(char ch : map2.keySet()){
            if(!map1.containsKey(ch)){
                res = res + map2.get(ch);
                map1.put(ch,map2.get(ch));
            }
        }


        for(char ch : map1.keySet()){
            res =  res + Math.abs(map1.get(ch) - map2.get(ch));
        }

        return res;
        
    }
}