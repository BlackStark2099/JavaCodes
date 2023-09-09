package LeetCode;

import java.util.HashMap;

public class check_if_strings_can_be_made_equal_with_operations_I_2839 {
    public static void main(String[] args) {
        System.out.println(        canBeEqual("jjgg", "gjgj"));
    }
    public static boolean canBeEqual(String s1, String s2) {
        HashMap<Character,Integer> occurance1 = new HashMap<>();
        HashMap<Character,Integer> occurance2 = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            if(occurance1.get(s1.charAt(i))==null){
                occurance1.put(s1.charAt(i), 1);
            }else{
                occurance1.put(s1.charAt(i),occurance1.get(s1.charAt(i))+1);
            }
            if(occurance2.get(s2.charAt(i))==null){
                occurance2.put(s2.charAt(i), 1);
            }else{
                occurance2.put(s2.charAt(i),occurance2.get(s2.charAt(i))+1);
            }
        }
        System.out.println(occurance1);
        System.out.println(occurance2);
        for(int i=0;i<s2.length();i++){
            if(occurance1.get(s2.charAt(i)) != occurance2.get(s2.charAt(i))){
                return false;
            }
            if(s1.charAt(i) == s2.charAt((i+2)%4) || s1.charAt(i) == s2.charAt((i))){
                continue;
            }else{
                return false;
            } 
        }
        return true;
    }
    
}
