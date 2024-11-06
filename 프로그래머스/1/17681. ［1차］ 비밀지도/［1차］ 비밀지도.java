import java.util.*;
//비트마스킹
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        //or 연산 후 String으로 변환해야할듯
        String[] tmp = new String[n];
        for(int i = 0; i<arr1.length; i++){
            tmp[i] = String.format("%"+n+"s", Integer.toBinaryString(arr1[i] | arr2[i])).replace(" ", "0");
        }
        
        for(int t = 0; t<tmp.length; t++){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<tmp[t].length(); i++){
                sb.append(tmp[t].charAt(i) == '1' ? '#' : ' ');
            }
            answer[t] = sb.toString();
        }
        return answer;
    }
}