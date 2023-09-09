package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class roman_to_integer_13 {
    static class Roman {
        int value;
        int priority;

        Roman(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

    public static int romanToInt(String s) {
        Map<Character, Roman> map = new HashMap<>();
        map.put('I', new Roman(1, 1));
        map.put('V', new Roman(5, 2));
        map.put('X', new Roman(10, 3));
        map.put('L', new Roman(50, 4));
        map.put('C', new Roman(100, 5));
        map.put('D', new Roman(500, 6));
        map.put('M', new Roman(1000, 7));

        int len = s.length();
        int value = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (i > 0 && map.get(s.charAt(i)).priority > map.get(s.charAt(i - 1)).priority) {
                value = value + map.get(s.charAt(i)).value - map.get(s.charAt(i-1)).value;
                i--;
            }else{
                value = value + map.get(s.charAt(i)).value; 
            }
        }
        return value;
    }
}
