import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = citations.length;
        Arrays.sort(citations);
        
        for(int citation: citations){
            if(citation >= answer) break;
            else answer -= 1;
        }
        
        return answer;
    }
}