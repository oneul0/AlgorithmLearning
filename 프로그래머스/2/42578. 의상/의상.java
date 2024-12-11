import java.util.*;
class Solution {
    HashMap<String, ArrayList<String>> map = new HashMap<>();
    public int solution(String[][] clothes) {
        int answer = 0;
        for(String[] cloth : clothes){
            if(map.containsKey(cloth[1])){
                map.get(cloth[1]).add(cloth[0]);
            }
            else{
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(cloth[0]);
                map.put(cloth[1], tmp);
            }
        }
        
        int comb = 1;
        for(String key : map.keySet()){
            comb *= (map.get(key).size()+1);
        }
        answer += (comb-1);    
        
        
        
        return answer;
    }
}