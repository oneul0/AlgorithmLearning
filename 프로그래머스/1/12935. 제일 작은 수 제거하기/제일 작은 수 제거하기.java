import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length <= 1) return new int[]{-1};
        int minNum = Arrays.stream(arr)
            .min().orElse(0);
        int idx = 0;
        int[] answer = new int[arr.length-1];
        for(int num : arr){
            if(num==minNum) continue;
            answer[idx++] = num;
        }
        
        return answer;
    }
}