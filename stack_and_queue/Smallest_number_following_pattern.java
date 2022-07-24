package JavaCodes.stack_and_queue;
import java.util.*;
import java.io.*;

public class Smallest_number_following_pattern {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Integer> stack = new Stack<>();
        int count = 1;
        String ans = "";
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            if(curr == 'd'){
                stack.push(count);
                count++;
            }else{
                stack.push(count);
                count++;
                while(stack.size()>0){
                    ans = ans + stack.pop();
                }
            }
        }
        stack.push(count);
        while(stack.size()>0){
            ans = ans + stack.pop();
        }
        System.out.println(ans);
    }
}
