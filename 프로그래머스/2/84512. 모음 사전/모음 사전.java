import java.util.*;
class Solution {
    int answer = 0, cnt=0;
    String word;
    char[] al = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        this.word = word;
        
        dfs(new StringBuilder());
        
        return answer;
    }
    
    boolean dfs(StringBuilder sb){
        
        //단어가 같으면 true 반환하면서 탐색 종료
        if(sb.toString().equals(word)) return true;
        
        // 만드는 단어의 길이가 5 이상이면 false 반환하며 탐색 계속(가지치기 같은 느낌)
        if(sb.length() >= 5) return false;
        
        for(char c : al){
            //단어 추가하며 탐색 cnt
            sb.append(c); cnt++;
            
            //정답 단어인지 판독하는 부분(현재 단어와 목표 단어가 같은지 판별)
            if(dfs(sb)){
                answer = cnt;
                return true;
            }
            
            //만약 단어가 같지 않으면 추가한 단어 삭제(다음 탐색에 영향을 주지 않게)
            sb.deleteCharAt(sb.length()-1);
            
        }
        
        return false;
    }
}
