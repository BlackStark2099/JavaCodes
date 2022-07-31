package JavaCodes.stack_and_queue;

import java.io.*;
import java.util.*;

public class merge_overlapping{
    
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        Pair[] arr2 = new Pair[n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
            arr2[j] = new Pair(arr[j][0],arr[j][1]);
        }

        mergeOverlappingIntervals(arr2);
    }

    public static class Pair implements Comparable<Pair>{
        int start,end;
        public Pair(int start,int end) {
            this.start = start;

            
            this.end = end;
        }

        @Override
        public int compareTo(Pair a){
            return this.start - a.start;
        } 
    }

    public static void mergeOverlappingIntervals(Pair[] arr) {
        Arrays.sort(arr);
        Stack<Pair> stack  = new Stack<>();
        stack.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(stack.peek().end >= arr[i].start && stack.peek().end < arr[i].end){
                stack.peek().end = arr[i].end;
            }else if(stack.peek().end >= arr[i].start && stack.peek().end >= arr[i].end){
                continue;
            }else{
                stack.push(arr[i]);
            }
        }
        arr = new Pair[stack.size()];
        for(int i=arr.length-1;i>=0;i--){
            arr[i] = stack.pop();
        }
        
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i].start+" "+arr[i].end);
        }
    }    
}
