import java.util.*;
class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int[] tmp = new int[arr.length];
        for(int i = 0; i<arr.length; i++){
            tmp[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(tmp);
        String answer = tmp[0] +" " +tmp[tmp.length-1];
        return answer;
    }
}