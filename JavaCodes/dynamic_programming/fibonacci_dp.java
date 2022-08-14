import java.util.*;
import java.io.*;

public class fibonacci_dp{
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int [] storage = new int[num+1];
        System.out.println(fibo(num,storage));
        for(int i=0;i<num+1;i++){
            System.out.print(storage[i]+"  ");
        }
    }

    private static int fibo(int num, int[] storage) {
        if(num == 0 || num == 1){
            return num;
        }
        if(storage[num] != 0){
            return storage[num];
        }
        
        storage[num] = fibo(num-2, storage) + fibo(num-1, storage);
        return storage[num];
    } 
}