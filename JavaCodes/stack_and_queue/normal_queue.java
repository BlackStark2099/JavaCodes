package JavaCodes.stack_and_queue;
import java.io.*;

public class normal_queue {
    public static class CustomQueue {
        int[] data;
        int front;
        int back;
        int size;
    
        public CustomQueue(int cap) {
          data = new int[cap];
          front = 0;
          back = 0;
          size = 0;
        }
    
        int size() {
            return size;
        }
    
        void display() {
            int temp = back;
            for(int i=0;i<size;i++){
                if(temp>=data.length){
                    temp = temp % data.length;
                }
                System.out.print(data[temp]+" ");
                temp++;
            }   
            System.out.println();
        }
    
        void add(int val) {
          if(size == data.length){
            System.out.println("Queue overflow");
            return;
          }
          data[front] = val;
          front++;
          if(front>=data.length){
            front = front%data.length;
          }
          size++;
        }
    
        int remove() {
            if(size == 0){
                System.out.println("Queue underflow");
                return -1;
            }
            int val = data[back];
            back++;
            if(back==data.length){
                back = back%data.length;
            }
            size--;
            return val;
        }
    
        int peek() {
            if(size == 0){
                System.out.println("Queue underflow");
                return -1;
            }
            return data[back];
        }
      }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomQueue qu = new CustomQueue(n);

        String str = br.readLine();
        while(str.equals("quit") == false){
            if(str.startsWith("add")){
            int val = Integer.parseInt(str.split(" ")[1]);
            qu.add(val);
            } else if(str.startsWith("remove")){
            int val = qu.remove();
            if(val != -1){
                System.out.println(val);
            }
            } else if(str.startsWith("peek")){
            int val = qu.peek();
            if(val != -1){
                System.out.println(val);
            }
            } else if(str.startsWith("size")){
            System.out.println(qu.size());
            } else if(str.startsWith("display")){
            qu.display();
            }
            str = br.readLine();
        }
    }
}
