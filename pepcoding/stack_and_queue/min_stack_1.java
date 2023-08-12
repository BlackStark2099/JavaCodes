package pepcoding.stack_and_queue;

import java.util.*;
import java.io.*;

public class min_stack_1{

    public static class Pair{
        int val,min;
         Pair(int val, int min){
            this.min = min;
            this.val = val;
         }
    }
    
    public static class MinStack {
        Stack<Pair> allData;

        public MinStack() {
            allData = new Stack<>();
        }


        int size() {
            return allData.size();
        }

        void push(int val) {
          if(allData.isEmpty()){
              allData.push(new Pair(val, val));
          }
           else if(allData.peek().min > val){
                allData.push(new Pair(val, val));
            } else{
                allData.push(new Pair(val,allData.peek().min));
            }
        }

        int pop() {
          if(allData.isEmpty()){
            return -1;
          }
          return allData.pop().val;
        }

        int top() {
          if(allData.isEmpty()){
            return -1;
          }
          return allData.peek().val;
        }

        int min(){
          if(allData.isEmpty()){
            return -1;
          }
          return allData.peek().min;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while(str.equals("quit") == false){
        if(str.startsWith("push")){
            int val = Integer.parseInt(str.split(" ")[1]);
            st.push(val);
        } else if(str.startsWith("pop")){
            int val = st.pop();
            if(val != -1){
            System.out.println(val);
            }
        } else if(str.startsWith("top")){
            int val = st.top();
            if(val != -1){
            System.out.println(val);
            }
        } else if(str.startsWith("size")){
            System.out.println(st.size());
        } else if(str.startsWith("min")){
            int val = st.min();
            if(val != -1){
            System.out.println(val);
            }
        }
        str = br.readLine();
        }
    }
}