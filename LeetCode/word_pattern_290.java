package LeetCode;
import java.util.*;

class Solution {
    public boolean wordPattern(String s, String t) {
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        String [] stArr = t.split(" ");
        if(s.length() != stArr.length) return false;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(!map.get(s.charAt(i)).equals(stArr[i])){
                    // System.out.println(map+" "+s.charAt(i)+" "+stArr[i]+" "+map.get(s.charAt(i)).equals(stArr[i]));
                    // System.out.println("hel");
                    return false;
                }
            }else{
                if(set.contains(stArr[i])) {
                    return false;
                }map.put(s.charAt(i),stArr[i]);
                set.add(stArr[i]);
            }
            
        }
        return true;
    }
}