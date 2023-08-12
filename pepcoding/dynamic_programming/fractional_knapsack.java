import java.io.*;
import java.util.Arrays;
public class fractional_knapsack {
    public static class Obj implements Comparable<Obj>{
        int wts;
        int price;
        double ratio;
        Obj(int wts,int price){
            this.wts = wts;
            this.price = price;
            this.ratio = price*1.0/wts;
        }
        @Override
        public int compareTo(fractional_knapsack.Obj o) {
           if(o.ratio > this.ratio){
            return -1; 
           }else if(o.ratio < this.ratio){
            return 1;
           }else{
            return 0;
           }
        }
        
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String priceStr = br.readLine();
        String [] priceArr = priceStr.split(" ");
        String wtsStr = br.readLine();
        String [] wtsArr = wtsStr.split(" ");
        Obj [] objArr = new Obj[n];
        int target = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            objArr[i] = new Obj(Integer.parseInt(wtsArr[i]),Integer.parseInt(priceArr[i]));
        }

        Arrays.sort(objArr);

        double res = 0;
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.println(objArr[i].wts + "  " + objArr[i].price + "  "+ objArr[i].ratio);
        }
        System.out.println();
        for(int i=n-1;i>=0 && target > 0;i--){
            if(target - objArr[i].wts >= 0){
                res = res + objArr[i].price;
                target = target - objArr[i].wts;
                System.out.println(target+ "  "+res+" "+objArr[i].wts+" "+objArr[i].price);
            }else{
                res = res + objArr[i].ratio*target;
                target = 0;
                System.out.println(" ---- "+target+ "  "+res+" "+objArr[i].wts+" "+objArr[i].price);
            }
        }
        System.out.println(res);
    }   

}
