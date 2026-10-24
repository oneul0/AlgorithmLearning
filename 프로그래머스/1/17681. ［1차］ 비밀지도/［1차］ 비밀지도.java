import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb;
        for(int i = 0; i<n; i++){
            int con = arr1[i] | arr2[i];
            sb = new StringBuilder();
            for(int j = n-1; j>=0; j--){
                char c = ((con & (1<<j)) != 0) ? '#' : ' ';
                sb.append(c);
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}
