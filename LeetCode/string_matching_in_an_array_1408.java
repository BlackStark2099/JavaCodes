package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class string_matching_in_an_array_1408 {
    public static void main(String[] args) {
        String [] arr =  new String[]{"qqbbotwgw","gvqqbbotwgw","tjnncbenboaqfi","aoqqbbotwgwg","zdlzvmeud","ctjnncbenboaqfi","tavvikigizmsuzy","hxaoqqbbotwgwgrn","fchkqrzdstjmdzg","aoqqbbotwgwgnm","rdgyqis","abzdlzvmeud","gldysdfdr","zsfchkqrzdstjmdzgv","pcopgdcjxeqoivoz","zsfchkqrzdstjmdzgvsj","cwvfdipevvz","egzsfchkqrzdstjmdzgvsjql","ve","nttjnncbenboaqfih","wrwnfpnmg","gitjnncbenboaqfi","mackwvtsdxjzddhh","okqqbbotwgw","cklnr","aoqqbbotwgwgq","cftqgnapiwh","jmackwvtsdxjzddhhu","rksiwkbpgprlhiz","kmackwvtsdxjzddhhoj","efexwhddu","mefexwhdduh","ukooqicbjvr","oaoqqbbotwgwgq","wbvmimjyw","kmackwvtsdxjzddhhojv","daszwpaz","gvqqbbotwgwf","sacwvuetwlkgnlls","mackwvtsdxjzddhhs","mytlblxftosclrbc","qgaoqqbbotwgwgnmi","kmdlqj","xegzsfchkqrzdstjmdzgvsjqlsm","ptramqfwtgwayarh","tgmackwvtsdxjzddhhq","yrxfdgskxdqyrf","mytlblxftosclrbclf","vlbbvfncrhi","zjgldysdfdrl","tsh","stsh","atexbgaqmyckqvkl","aoqqbbotwgwgqq","y","vvee","vtjwyivfjagzju","xokqqbbotwgwjn","kudusxyvqoozft","vveecr","g","vtshdx","jrmqmee","ouzsfchkqrzdstjmdzgvu","ockscojww","gaoqqbbotwgwga","rffjmpmtb","vet","daomkoijcputkbld","oimytlblxftosclrbclfl","lzdagbcaynxixbg","pejmackwvtsdxjzddhhu","tgbi","abzdlzvmeudky","pxnauizoit","gotgbi","qyu","fgvvee","olvnjprv","qgaoqqbbotwgwgnmisx","mhif","wkudusxyvqoozftlg","hofvzkxznykxubr","xouzsfchkqrzdstjmdzgvu","mordjmj","mgotgbio","ye","ggitjnncbenboaqfie","cydjufgftzwdmid","rcjmackwvtsdxjzddhhue","gufndz","ypvtjwyivfjagzju","szec","bgvqqbbotwgwfu"};
        System.out.println(stringMatching(arr));
    }

    public static List<String> stringMatching(String[] v) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=96;i<123;i++){
            map.put((char)i,i%95);
        }
        List<String> res = new ArrayList<>();
        for(int i = 0;i<v.length;i++){
            for(int j = 0;j<v.length;j++){
                if(i == j) continue;
                if(v[i].length()>=v[j].length()){
                    if(patternMatching(v[j], v[i],map)){
                        res.add(v[j]);
                    }
                }
            }
        }
        Set<String> resultSet = new HashSet<>(res);
List<String> resultList = new ArrayList<>(resultSet);

return resultList;

    }

    public static boolean patternMatching(String str1, String str2,HashMap<Character,Integer> map){
       
        int hash1 = calculateHash(str1, map);
        int hash2 = 0;
        for(int i=0;i<str2.length()-str1.length()+1;i++){
            hash2 = calculateHash(str2.substring(i,i+str1.length()),map);
            if(hash1 == hash2) return true;
        }
        return false;
    }

    public static int calculateHash(String str1,HashMap<Character,Integer> map){
        int hash = 0;
        for(int i=str1.length()-1;i>=0;i--){
            hash = hash + map.get(str1.charAt(i))*(int)Math.pow(26,str1.length()-1-i);
        }
        return hash;
    }
    
}
