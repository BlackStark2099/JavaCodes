package LeetCode;

public class Climbing_Stairs_70 {
    public static void main(String[] args) {
        climbStairs(2);
        
    }

    public static int climbStairs(int n) {
        System.out.println("hello");
        int [] tab = new int[n+1];
        tab[0] = 1;
        for(int i = 1;i<n+1;i++){
            int res = 0;
            if(i-1 >= 0){
                res = res + tab[i-1];
            }
            if(i-2 >= 0){
                res = res + tab[i-2];
            }
            tab[i] = res;
            System.out.println(i+" "+res);
        }          
        return tab[n];
    }
    
}
