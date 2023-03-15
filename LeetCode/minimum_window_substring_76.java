package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
 public static String minWindow(String s, String p) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        if(s.length() < p.length()){
            return "";
        }
        String res = null;
        // ArrayList<String> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        int k = p.length();
        
        for(int i=0;i<p.length();i++){
            if(map2.containsKey(p.charAt(i))) map2.put(p.charAt(i),map2.get(p.charAt(i))+1);
            else map2.put(p.charAt(i),1);
        }
         

        for(int i = 0;i<s.length();i++){
            if(map1.containsKey(s.charAt(i))) map1.put(s.charAt(i),map1.get(s.charAt(i))+1);
            else map1.put(s.charAt(i),1);
            boolean flag = true;

            for(char ch : map2.keySet()){
                if(map1.containsKey(ch) && map1.get(ch) >= map2.get(ch)) {

                }else{
                    flag = false;
                    break;
                }
            }
            start = i;
            if(flag){
                // System.out.println(map1 + " "+i+" "+end);
                while(end<=i){
                    if(map1.containsKey(s.charAt(end))){
                        if(!map2.containsKey(s.charAt(end))){
                            if(map1.get(s.charAt(end)) == 1){
                                map1.remove(s.charAt(end));
                            }else{
                                map1.put(s.charAt(end),map1.get(s.charAt(end))-1);
                            }
                            end++;
                        }
                        else if(map2.get(s.charAt(end)) < map1.get(s.charAt(end))){
                            // boolean tempFlag = false;

                             if(res == null) res = s.substring(end,start+1);
                            if(res != null && res.length() > s.substring(end,start+1).length()) res = s.substring(end,start+1);
                            if(map1.get(s.charAt(end)) == 1){
                                map1.remove(s.charAt(end));
                            }else{
                                map1.put(s.charAt(end),map1.get(s.charAt(end))-1);
                            }
                            end++;
                        }else{
                             // boolean tempFlag = false;
                             if(res == null) res = s.substring(end,start+1);
                             if(res != null && res.length() > s.substring(end,start+1).length()) res = s.substring(end,start+1);
                            //  res.add(s.substring(end,start+1));
                             if(map1.get(s.charAt(end)) == 1){
                                 map1.remove(s.charAt(end));
                             }else{
                                 map1.put(s.charAt(end),map1.get(s.charAt(end))-1);
                             }
                             end++;
                             break;
                        }
                    }
                    // end++;

                }
                // System.out.println(s.substring(end,start));
                // System.out.println(res);
            }
            
        
        }      
        if(res == null){
            return "";
        }

        // String tempres = "";
        // int min = Integer.MAX_VALUE;
        // for(String str : res){
        //     if(str.length() < min){
        //         tempres = str;
        //         min = str.length();
        //     }
        // }
        return res;
        
    }

}