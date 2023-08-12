package pepcoding.hashmap_heap;
import java.util.*;

public class longest_substring_with_at_most_k_unique_characters {

    public static int solution(String s, int k) {
		// write your code here
		HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        
        int start = 0;
        int end = 0;
		Integer res = null;      

        for(int i = 0;i<s.length();i++){
			start = i;
            if(map1.containsKey(s.charAt(i))) {
				map1.put(s.charAt(i),map1.get(s.charAt(i))+1);
            }
			else map1.put(s.charAt(i),1);
			if(map1.size()>k){
				while(end<i){
					if(map1.get(s.charAt(end)) != 1){
						map1.put(s.charAt(end),map1.get(s.charAt(end))-1);
					}else{
						map1.remove(s.charAt(end));
						end++;
						break;
					}
					end++;
                }

			}
			if(map1.size() == k){
				if(res == null) res = start-end+1;
				else if(res < start-end+1) res = start-end+1;
			}
			// System.out.println(map1+" "+res+" "+s.charAt(i));
        }      

		if(res == null) res = start-end+1;
		else if(res < start-end+1) res = start-end+1;
		return res;
		

	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
