import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> count = new HashMap<>();
        for(String g : gems){
            count.compute(g, (k,v) -> k == null ? 1 : v+1);
        }
        
        
        // int[] answer = new int[]{start, end};
        // return answer;
        return null;
    }
}