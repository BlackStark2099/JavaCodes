package JavaCodes.stack_and_queue;

import java.io.*;
import java.util.*;


public class postfix_evaluation_conversion{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Stack<Integer> ans = new Stack<>();
        Stack<String> infix = new Stack<>(); 
        for(int i=0;i < exp.length();i++){
            char curr = exp.charAt(i);
            if(curr == '+' || curr == '-' || curr == '*' || curr == '/'){
                int v1 = ans.pop(),v2 = ans.pop();
                ans.push(solve(v2, v1, curr));
                String v22 = infix.pop(),v11 = infix.pop();
                infix.push("("+v11+curr+v22+")");
            }else{
                infix.push(""+curr);
                ans.push(Integer.parseInt(""+curr));
            }
        }
        System.out.println(ans.peek());
        System.out.println(infix.peek());
        prefix(infix.peek());
    }

    public static void prefix(String exp){
        Stack<String> prefix = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for(int i=0;i < exp.length();i++){
            char ch = exp.charAt(i);
            if(ch == '('){
                operator.push(ch);
            }else if(ch == ')'){
                while(!operator.isEmpty() && operator.peek() != '('){
                    char op;
                    String v1,v2;
                    op = operator.pop();
                    v1 = prefix.pop();
                    v2 = prefix.pop();
                    prefix.push(op+v2+v1);
                }
                operator.pop();
            }else if(ch == '+' || ch == '-'  || ch == '*'  || ch == '/' ){
                int currPre = getPriority(ch);
                while(!operator.isEmpty() && currPre <= getPriority(operator.peek())){
                    char op;
                    String v1,v2;
                    op = operator.pop();
                    v1 = prefix.pop();
                    v2 = prefix.pop();
                    prefix.push(op+v2+v1);
                }
                operator.push(ch);
            }else{
                prefix.push(""+ch);
            }
        }

        while(!operator.isEmpty()){
            char op;
            String v1,v2;
            op = operator.pop();
            v1 = prefix.pop();
            v2 = prefix.pop();
            prefix.push(op+v2+v1);
        }
        System.out.println(prefix.peek());
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

    public static int getPriority(char ch){
        if(ch == '*' || ch == '/'){
            return 2;
        }else if(ch == '+' || ch == '-'){
            return 1;
        }else{
            return -1;
        }
    }
}

