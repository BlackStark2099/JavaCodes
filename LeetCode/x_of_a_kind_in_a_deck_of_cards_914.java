class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<deck.length;i++){
            if(map.containsKey(deck[i])){
                map.put(deck[i],map.get(deck[i])+1);
            }else{
                map.put(deck[i],1);
            } 
        }
        int i =0;
        int ans = 0;
        // System.out.println(map);
        for(Integer m : map.keySet()){
            if(i == 0) {
                ans = map.get(m);
                i++;
            }else{
                ans = gcd(ans,map.get(m));
            }
            // System.out.println(ans);
        }
        if(ans > 1){
            return true;
        }else{
            return false;
        }
    }

    public static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}