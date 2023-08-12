package pepcoding.stack_and_queue;

import java.io.*;
import java.util.*;

public class min_stack_2_constant_space{
    
 
    public static class MinStack {
        Stack<Integer> data;
        int min;
    
        public MinStack() {
          data = new Stack<>();
        }
    
        int size() {
          // write your code here
          return data.size();
        }
    
        void push(int val) {
          if(data.isEmpty()){
            data.push(val);
            min = val;
          }
          else if(val>min){
                data.push(val);
            }else{
                int prevmin = min;
                min = val;  
                data.push(2*val-prevmin);
            }
        }
    
        int pop() {
          // write your code here
          if(min < data.peek()){
            return data.pop();
          }else{
            int curr = min;
            min = (-1)*data.peek() +  2*curr;
            data.pop();
            return curr;
          }
        }
    
        int top() {
            if(min>data.peek()){
                return min;
            }else{
                return data.peek();
            }
        }
    
        int min() {
          // write your code here
          return min;
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();
    
        String str = br.readLine();
        while (str.equals("quit") == false) {
          if (str.startsWith("push")) {
            int val = Integer.parseInt(str.split(" ")[1]);
            st.push(val);
          } else if (str.startsWith("pop")) {
            int val = st.pop();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("top")) {
            int val = st.top();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("size")) {
            System.out.println(st.size());
          } else if (str.startsWith("min")) {
            int val = st.min();
            if (val != -1) {
              System.out.println(val);
            }
          }
          str = br.readLine();
        }
      }

      
}