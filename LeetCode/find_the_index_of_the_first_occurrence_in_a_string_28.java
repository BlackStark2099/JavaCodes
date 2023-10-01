package LeetCode;

import java.util.HashMap;

public class find_the_index_of_the_first_occurrence_in_a_string_28 {
    public static void main(String[] args) {
        System.out.println(strStr("baaaaaaaa", "bagytisyy"));
    }
    public static int strStr(String haystack, String needle) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> powerMap = new HashMap<>(); 
        for(int i=1;i<31;i++){
            powerMap.put(i-1,(int)Math.pow(31,i));
        }
        System.out.println(powerMap);
        for(int i=96;i<123;i++){
            map.put((char)i,i%95);
        }
        return patternMatching(needle,haystack,map,powerMap);
    }
     public static int patternMatching(String str1, String str2,HashMap<Character,Integer> map,HashMap<Integer,Integer> powerMap){
        int hash1 = calculateHash(str1, map,powerMap);
        int hash2 = 0;
        for(int i=0;i<str2.length()-str1.length()+1;i++){
            hash2 = calculateHash(str2.substring(i,i+str1.length()),map,powerMap);
            if(hash1 == hash2 && str2.substring(i, i+str1.length()).equals(str1)) return i;
        }
        return -1;
    }
    public static int calculateHash(String str1,HashMap<Character,Integer> map,HashMap<Integer,Integer> powerMap){
        int hash = 0;
        for(int i=str1.length()-1;i>=0;i--){
            System.out.println(str1.length()-1-i);
            System.out.println(powerMap.get(str1.length()-1-i));
            hash = hash + (str1.length()-1-i)*powerMap.get(map.get(str1.charAt(i)));
        }
        return hash;
    }
}
