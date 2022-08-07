package JavaCodes.stack_and_queue;

import java.util.*;
import java.io.*;

public class stack_to_queue_adapter_remove_efficient{
    
    public static class StackToQueueAdapter {
        Stack<Integer> mainS;
        Stack<Integer> helperS;
    
        public StackToQueueAdapter() {
          mainS = new Stack<>();
          helperS = new Stack<>();
        }
    
        int size() {
            return mainS.size();
        }
    
        void add(int val) {
          // write your code here
          while(!mainS.isEmpty()){
            helperS.push(mainS.pop());
          }
          mainS.push(val);
          while(!helperS.isEmpty()){
            mainS.push(helperS.pop());
          }
        }
    
        int remove() {
          if(mainS.isEmpty()){
            System.out.println("Queue underflow");
            return -1;
          }
          // write your code here
          return mainS.pop();
        }
    
        int peek() {
          // write your code here
          if(mainS.isEmpty()){
            System.out.println("Queue underflow");
            return -1;
          }
            return mainS.peek();
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StackToQueueAdapter qu = new StackToQueueAdapter();
    
        String str = br.readLine();
        while (str.equals("quit") == false) {
          if (str.startsWith("add")) {
            int val = Integer.parseInt(str.split(" ")[1]);
            qu.add(val);
          } else if (str.startsWith("remove")) {
            int val = qu.remove();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("peek")) {
            int val = qu.peek();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("size")) {
            System.out.println(qu.size());
          }
          str = br.readLine();
        }
      }  
}
