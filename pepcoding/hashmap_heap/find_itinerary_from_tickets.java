package pepcoding.hashmap_heap;
import java.util.*;

public class find_itinerary_from_tickets {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		HashMap<String, Boolean> map2 = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);
			if(!map2.containsKey(s2)){
				map2.put(s2,true);	
			}else{
							map2.put(s2,true);	
				}if(!map2.containsKey(s1)){
				map2.put(s1,false);	
			}
			// map2.put(s2,true);
		}
		String src = "";
		String des = "";
		
		for(String key : map2.keySet()){
			if(!map2.get(key)) src = key;
		}

		// System.out.println(map2);
		for(int i=0;i<map.size();i++){
			System.out.print(src+" -> ");
			src = map.get(src);
			des = src;
		}
		System.out.println(des+".");


	}
}
