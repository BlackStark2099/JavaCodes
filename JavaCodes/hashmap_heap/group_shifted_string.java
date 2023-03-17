package JavaCodes.hashmap_heap;
import java.util.*;

public class group_shifted_string {
    
    public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strArr) {

		HashMap<String,ArrayList<String>> map = new HashMap<>();
		// String [] strArr = strs.split("");
		for(int i=0;i<strArr.length;i++){
            String key = "";
			if(strArr[i].length() == 1){
                key = "1##";
			}
			if(strArr[i].length() == 0){
				key = "0##";	
            }else{
				for(int j=1;j<strArr[i].length();j++){
                    int tempRes =strArr[i].charAt(j)-strArr[i].charAt(j-1);
                    if(tempRes<0) tempRes = tempRes + 26;
					key = key + tempRes+"#";
				}
			}

            if(map.containsKey(key)){
                ArrayList<String> temp = map.get(key);
                temp.add(strArr[i]);
                map.put(key, temp);
            }else{
                ArrayList<String> temp = new ArrayList<>();
                temp.add(strArr[i]);
                map.put(key, temp);
            }
		} 
        ArrayList<ArrayList<String>> res = new ArrayList<>();

        for(String key : map.keySet()){
            res.add(map.get(key));
        }

		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		ArrayList<ArrayList<String>> shiftedGroup = groupShiftedStrings(arr);
		for (ArrayList<String> lst : shiftedGroup) {
			Collections.sort(lst);
		}
		shiftedGroup.sort(new ListComparator());
		display(shiftedGroup);
	}

	// it is used to make the result unique
	static class ListComparator implements Comparator<List<String>> {
		@Override
		public int compare(List<String> l1, List<String> l2) {
			if (l1.size() != l2.size()) {
				return l2.size() - l1.size();
			}

			String l1str = l1.get(0);
			String l2str = l2.get(0);
			return l1str.compareTo(l2str);

		}
	}

	public static void display(ArrayList<ArrayList<String>> list) {
		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> currList = list.get(i);
			for (int j = 0; j < currList.size(); j++) {
				System.out.print(currList.get(j) + " ");
			}
			System.out.println();
		}
	}
}
