import java.util.*;
class Solution {
    public int[] solution(long n) {
        String tmp = String.valueOf(n);
        int size = tmp.length();
        int[] answer = new int[size];
        for(int i = size-1; i>=0; i--){
            answer[size-1-i] = tmp.charAt(i)-'0';
        }
        return answer;
    }
}