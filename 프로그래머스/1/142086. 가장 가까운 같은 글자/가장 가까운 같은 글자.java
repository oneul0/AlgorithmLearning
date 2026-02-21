import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] lastIdx = new int[26];
        Arrays.fill(lastIdx, -1);
        int[] answer = new int[s.length()];
        for(int i = 0; i<s.length(); i++){
            int curIdx = s.charAt(i) - 'a';
            if(lastIdx[curIdx] == -1) answer[i] = -1;
            else answer[i] = i-lastIdx[curIdx];
            lastIdx[curIdx] = i;
        }
        return answer;
    }
}