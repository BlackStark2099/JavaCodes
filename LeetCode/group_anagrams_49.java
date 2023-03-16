package LeetCode;
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,List<String>> main = new HashMap<>();
         List<List<String>> res = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            HashMap<Character,Integer> map = new HashMap<>();
            String p = strs[i]; 
            
            for(int j=0;j<p.length();j++){
                if(map.containsKey(p.charAt(j))) map.put(p.charAt(j),map.get(p.charAt(j))+1);
                else map.put(p.charAt(j),1);
            }   

            if(main.containsKey(map)){
                List<String> temp = main.get(map);
                temp.add(p);
                main.put(map,temp);
            }else{
                List<String> temp = new ArrayList<String>();
                temp.add(p);
                main.put(map,temp);
            }
        }   


        for(HashMap<Character,Integer> key : main.keySet()){
            res.add(main.get(key));
        }

        return res;    
        
    }
}
