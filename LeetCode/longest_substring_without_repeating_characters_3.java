package LeetCode;
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;  
        int start = 0;
        int end = 0;

        // s = s.replace(" ","_");
        // System.out.println(s);
        HashMap<Integer,Integer> map = new HashMap<>(); 
        for(int i=0;i<s.length();i++){
            end = i;
            if(map.containsKey((int)s.charAt(i))){
                if(res < i-start) res = i-start;
                while(start<i){
                    map.remove((int)s.charAt(start));
                    if((int)s.charAt(start) == (int)s.charAt(i)){
                        start ++;
                        break;
                    }
                    start++;
                }
                map.put((int)s.charAt(i),1);
            }else{
                map.put((int)s.charAt(i),1);
            }
        }   
        // System.out.println(end+ "  "+s.length());
        if(res < s.length()-start) res = s.length()-start;

        return res;
    }
}