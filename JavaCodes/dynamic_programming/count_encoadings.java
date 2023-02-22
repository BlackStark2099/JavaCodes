import java.util.*;
import java.io.*;

public class count_encoadings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();

        int [] dp = new int[str.length()];
         if(str.charAt(0) != '0'){
            dp[0] = 1;
        }else {
            System.out.println(0);
            return;
        }
        for(int i=1;i<dp.length;i++){
            int tempRes = 0;
            int temp = Integer.parseInt(""+str.charAt(i));
            if(str.charAt(i) != '0'){
                tempRes = dp[i-1];
            }else{
                // System.out.println(0);

                // dp[0] = 0;
            }
            int tempNum = Integer.parseInt(str.substring(i-1, i+1));
            if(tempNum > 0 && tempNum<27 && tempNum != temp){
                if(i-2 >= 0){
                    tempRes = tempRes + dp[i-2]; 
                }
                else{
                    tempRes = tempRes + 1; 
                }
            }
            dp[i] = tempRes;
        }

        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i]+"  ");
        }
        System.out.println();

        System.out.println(dp[str.length()-1]);
    }


    public static void apporach1(){
        
    }
}
