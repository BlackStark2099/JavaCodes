package LeetCode;

import java.util.Arrays;

public class count_good_meals_1711{
    public static void main(String[] args) {
        int [] del = new int[]{149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234};
        System.out.println(countPairs(del));
    }

    public static int countPairs(int[] del) {
        Arrays.sort(del);
        int n = del.length;
        long max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(max<del[i]) max = del[i];
        }
        // long maxValue = (long)Math.pow(2, maxPow);
        long num = 2;
        long res = 0;
        boolean[][] visited = new boolean[n][n];
        Arrays.sort(del);
        for(int i = 0;num<max*max;i++){
            visited = new boolean[n][n];
            System.out.println(num);
            res = res + getResult(0,n-1, del, num,visited);
            num=num*2;
        }
        System.out.println();
        return (int)res%1000000007;
    }


    public static long getResult(int i,int l,int[] del,long m,boolean[][] visited){
        long res = 0;
        if(i>=l){
            return 0;
        }
        if(del[i]+del[l] == m && i != l && !visited[i][l] ){
            System.out.println(i+" "+l+" "+del[i]+" "+del[l]+" "+m);
            visited[i][l] = true;
            res = res+1;
        }
        
        if(del[i]+del[l] < m){
            res = res + getResult(i+1, l, del, m,visited);
        }else if(del[i]+del[l] > m){
            res = res + getResult(i, l-1, del, m,visited);
        }else if(del[i]+del[l] == m){
            res = res + getResult(i, l-1, del, m,visited); 
            res = res + getResult(i+1, l-1, del, m,visited);
            res = res + getResult(i+1, l, del, m,visited);
        }
        return res;
    }
}
