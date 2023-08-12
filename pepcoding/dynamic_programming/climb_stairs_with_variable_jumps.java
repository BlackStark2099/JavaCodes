import java.io.*;
import java.util.*;

public class climb_stairs_with_variable_jumps {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] jumps = new int[n+1];
        int [] storage = new int[n+1];
        for(int i=0;i<n;i++){
            jumps[i] = input.nextInt();
        }
        System.out.println(climb_stairs_tabulation(n, storage,jumps));
    }

    // private static int climb_stairs_memorisaton(int n,int [] storage) {
       
    // }

    private static int climb_stairs_tabulation(int n,int [] storage,int [] jumps) {
        storage[n] = 1;
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<=i+jumps[i] && j < storage.length;j++){
                storage[i] += storage[j];
            }
        }
        
        return storage[0];
    }

}
