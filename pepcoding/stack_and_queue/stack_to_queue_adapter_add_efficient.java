package pepcoding.stack_and_queue;

import java.util.*;
import java.io.*;

public class stack_to_queue_adapter_add_efficient{
    
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
        mainS.push(val);
    }

    int remove() {
        if(this.size() == 0){
            System.out.println("Queue underflow");
            return -1;
        }
        while(mainS.size() != 1){
            helperS.push(mainS.pop());
        }
        int res = mainS.pop();
        while(!helperS.isEmpty()){
            mainS.push(helperS.pop());
        }
        return res;
    }

    int peek() {
        if(this.size() == 0){
            System.out.println("Queue underfflow");
            return -1;
        }
        while(mainS.size() != 1){
            helperS.push(mainS.pop());
        }
        int res = mainS.pop();
        helperS.push(res);
        while(!helperS.isEmpty()){
            mainS.push(helperS.pop());
        }
        return res;
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
