import java.util.*;

import java.util.*;
public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        Deque<Integer> st = new ArrayDeque<>();
        
        for(int i = 0; i<arr.length; i++){
            if(st.isEmpty() || arr[i] != st.peek()){
                st.push(arr[i]);
            }
        }
        answer = new int[st.size()];
        
        for(int i = answer.length-1; i>=0; i--){
            answer[i] = st.pop();
        }
        return answer;
    }
}