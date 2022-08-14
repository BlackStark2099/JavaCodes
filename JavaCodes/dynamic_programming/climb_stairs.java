import java.io.*;
import java.util.*;

public class climb_stairs {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] storage  = new int [n+1];
        int res = climbStairs(n,storage);
        System.out.println(res);
    }

    private static int climbStairs(int n,int [] storage) {
        if(n == 0){
            return 1;
        }
        int res = 0;
        if(storage[n] != 0){
            return storage[n];
        }
        if(n-1>=0){
            res = res +climbStairs(n-1, storage);
        }
        if(n-2>=0){
            res = res + climbStairs(n-2, storage);
        }
        if(n-3>=0){
            res = res + climbStairs(n-3, storage);
        }
        storage[n] = res;
        return res;
    }
}