package JavaCodes.hashmap_heap;

import java.io.*;
import java.util.*;

public class number_of_employees_under_every_manager {

  public static void main(String[] args) throws IOException{
     
        Scanner scn = new Scanner(System.in);
        int n = Integer.parseInt(scn.nextLine());
        String ceo = "";
    
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
          String[] parts = scn.nextLine().split(" ");
          String emp = parts[0];
          String man = parts[1];
          if(!map.containsKey(emp)){
            map.put(emp,0);
          }
          if(emp.equals(man)){
            continue;
          } 
          if(!map.containsKey(man)){
            map.put(man,map.get(emp)+1);
          }else{
            map.put(man,map.get(man)+map.get(emp)+1);
          }
          
        }
        for(String k : map.keySet()){
          System.out.println(k+" "+map.get(k));
        }
        //write your code here
    }

}