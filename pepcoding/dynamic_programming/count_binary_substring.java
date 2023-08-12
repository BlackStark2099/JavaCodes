
import java.util.*;
import java.io.*;

public class count_binary_substring {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int [] dp_0 = new int[num+1];
        int [] dp_1 = new int[num+1];
        dp_0[0] = 1;
        dp_1[0] = 1;
        
        for(int i=1;i<num;i++){
            dp_0[i] = dp_1[i-1];
            dp_1[i] = dp_0[i-1] + dp_1[i-1]; 
        }

        System.out.println(dp_0[num-1]+dp_1[num-1]);
    }
    
}
