import java.io.*;
import java.util.*;

public class climb_stairs {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] storage  = new int [n+1];
        int res = climb_stairs_memorisaton(n,storage);
        System.out.println(res);
    }

    private static int climb_stairs_memorisaton(int n,int [] storage) {
        if(n == 0){
            return 1;
        }
        int res = 0;
        if(storage[n] != 0){
            return storage[n];
        }
        if(n-1>=0){
            res = res +climb_stairs_memorisaton(n-1, storage);
        }
        if(n-2>=0){
            res = res + climb_stairs_memorisaton(n-2, storage);
        }
        if(n-3>=0){
            res = res + climb_stairs_memorisaton(n-3, storage);
        }
        storage[n] = res;
        return res;
    }

    private static int climb_stairs_tabulation(int n,int [] storage) {
        storage[0] = 1;
        for(int i=1;i<storage.length;i++){
            if(i-1>=0){
                storage[i] += storage[i-1];
            }
            if(i-2>=0){
                storage[i] += storage[i-2];
            }
            if(i-3>=0){
                storage[i] += storage[i-3];
            }
        }
        return storage[n];
    }

}
