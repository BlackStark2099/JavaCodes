package JavaCodes.stack_and_queue;
import java.util.*;
import java.io.*;

public class Prefix_evaluation_and_conversions {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Stack<String> postfix = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<Character> operator = new Stack<>();
        Stack<Integer> ans = new Stack<>();
        for(int i = exp.length()-1;i>=0;i--){
            char curr = exp.charAt(i);
            if(curr == '+' || curr == '-' || curr == '*' || curr == '/'){
                int v1 = ans.pop(),v2 = ans.pop();
                ans.push(solve(v1, v2, curr));
                String v22 = infix.pop(),v11 = infix.pop();
                infix.push("("+v22+curr+v11+")");
                String vP1 = postfix.pop(),vP2 = postfix.pop();
                postfix.push(vP1+vP2+curr);            
            }else{
                infix.push(""+curr);
                ans.push(Integer.parseInt(""+curr));
                postfix.push(""+curr);
            }
        }
        System.out.println(ans.peek());
        System.out.println(infix.peek());
        System.out.println(postfix.peek());
    }

    
    public static int solve(int v1,int v2,char ch){
        if(ch == '*'){
            return v1*v2;
        }
        if(ch == '/'){
             return (v1/v2);
        }
        if(ch == '+'){
             return (v1+v2);
        }
        if(ch == '-'){
            return (v1-v2);
        }
        return 0 ;
    }

}
