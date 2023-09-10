package LeetCode;

import java.util.Arrays;

public class longest_common_prefix_14 {
    

// This code implements the longestCommonPrefix function that takes a list of strings v as input and returns the longest common prefix of all the strings. Here is an explanation of how the code works:

// Initialize an empty string ans to store the common prefix.
// Sort the input list v lexicographically. This step is necessary because the common prefix should be common to all the strings, so we need to find the common prefix of the first and last string in the sorted list.
// Iterate through the characters of the first and last string in the sorted list, stopping at the length of the shorter string.
// If the current character of the first string is not equal to the current character of the last string, return the common prefix found so far.
// Otherwise, append the current character to the ans string.
// Return the ans string containing the longest common prefix.
// Note that the code assumes that the input list v is non-empty, and that all the strings in v have at least one character. If either of these assumptions is not true, the code may fail.

    public String longestCommonPrefix(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length-1];
        // System.out.println(v);
        for(int i = 0;i<v.length;i++){
                    System.out.println(v[i]);
        }
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
    
}
