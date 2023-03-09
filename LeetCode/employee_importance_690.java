

package LeetCode;

import java.io.*;
import java.util.*;

class Solution {
    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Integer> empImp = new HashMap<>();
        HashMap<Integer,List<Integer>> subordinates = new HashMap<>();
        for(int i = 0;i<employees.size();i++){
            empImp.put(employees.get(i).id,employees.get(i).importance);
            subordinates.put(employees.get(i).id,employees.get(i).subordinates);
        }

        return getSubImp(id,empImp,subordinates);
    }

    public int getSubImp(int id,HashMap<Integer,Integer> empImp, HashMap<Integer,List<Integer>> sub){
        int res = 0;
        List<Integer> arr = sub.get(id);
        for(int i=0;i < arr.size();i++){
            res = res + getSubImp(arr.get(i),empImp,sub);
        }

        return res + empImp.get(id);
    }
}