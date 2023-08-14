package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class temp {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        HashMap<ArrayList<Integer>,Integer> map = new HashMap<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        map.put(temp,1);
        ArrayList<Integer> temp2 = new ArrayList<>();
        temp2.add(1);
        temp2.add(2);
        map.get(temp2);
        System.out.println(map.get(temp2));
    }
}