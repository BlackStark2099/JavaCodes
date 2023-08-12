import java.util.*;
import java.io.*;

public class arrange_buildings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        Long [] dp_0 = new Long[num+1];
        Long [] dp_1 = new Long[num+1];
        dp_0[0] = (long) 1;
        dp_1[0] = (long) 1;
        
        for(int i=1;i<num;i++){
            dp_0[i] = dp_1[i-1];
            dp_1[i] = dp_0[i-1] + dp_1[i-1]; 
        }
        Long res = (long) ((dp_0[num-1]+dp_1[num-1])*(dp_0[num-1]+dp_1[num-1]));

        System.out.println(res);
    }
    
}
