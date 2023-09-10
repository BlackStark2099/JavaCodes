package LeetCode;

import java.util.List;

public class check_if_a_string_is_an_acronym_of_words_2828 {
    public static void main(String[] args) {

    }

    public static boolean isAcronym(List<String> words, String s) {
        if(words.size() != s.length()) return false;
        for(int i=0;i<words.size();i++){
            if(words.get(i).charAt(0) != s.charAt(i)) return false;
        }
        return true;
    }
}
