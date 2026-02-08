import java.util.*;
class Solution {
    public int solution(String s) {
        String[] strs = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i<strs.length; i++){
            s = s.replaceAll(strs[i], i+"");
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
}