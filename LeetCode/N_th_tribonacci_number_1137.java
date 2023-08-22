package LeetCode;

public class N_th_tribonacci_number_1137 {
    public static void main(String[] args) {
        tribonacci(2);
    }
    public static int tribonacci(int n) {
        Integer [] memory = new Integer[n+4];
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        
        memory[0] = 0;
        memory[1] = 1;
        memory[2] = 1;

        return calculate(memory,n);
    }

    public static int calculate(Integer [] memory,int n){
        if(n < 0) return 0;
        if(memory[n] != null) return n;
        if(memory[n-3] == null){
            calculate(memory,n-3);
        }
        if(memory[n-2] == null){
            calculate(memory,n-2);
        }
        if(memory[n-1] == null){
            calculate(memory,n-1);
        }

        memory[n] = memory[n-3] + memory[n-2] + memory[n-1];
        return memory[n];
    }
    
}
