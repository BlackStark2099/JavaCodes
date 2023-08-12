package pepcoding.stack_and_queue;

import java.io.*;
import java.util.*;

public class Infix_conversion{  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<String> postfix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(ch == '('){
                operator.push(ch);
            }else if(ch == ')'){
                while(!operator.isEmpty() && operator.peek() != '('){
                    char op;
                    String v1,v2;
                    op = operator.pop();
                    v1 = postfix.pop();
                    v2 = postfix.pop();
                    postfix.push(v2+v1+op);
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
                    v1 = postfix.pop();
                    v2 = postfix.pop();
                    postfix.push(v2+v1+op);
                    v1 = prefix.pop();
                    v2 = prefix.pop();
                    prefix.push(op+v2+v1);
                }
                operator.push(ch);
            }else{
                postfix.push(""+ch);
                prefix.push(""+ch);
            }
        }

        while(!operator.isEmpty()){
            char op;
            String v1,v2;
            op = operator.pop();
            v1 = postfix.pop();
            v2 = postfix.pop();
            postfix.push(v2+v1+op);
            v1 = prefix.pop();
            v2 = prefix.pop();
            prefix.push(op+v2+v1);
        }
        System.out.println(prefix.pop());
        System.out.println(postfix.pop());
        
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