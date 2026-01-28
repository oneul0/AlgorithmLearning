import java.util.*;
class Solution {
    int[][] q;
    int[] ans;
    int answer = 0, n, m;
    public int solution(int n, int[][] q, int[] ans) {
        this.q = q;
        this.ans = ans;
        this.n = n;
        this.m = m;
        
        comb(1, 0);
        
        return answer;
    }
    
    int[] code = new int[5];
    public void comb(int start, int len){
        if(len >= 5){
            HashSet<Integer> chk = new HashSet<>();
            for(int c : code){
                chk.add(c);
            }
            if(isCorrect(chk)) answer++;
            return;
        }
        for(int i = start; i<=n; i++){
            code[len] = i;
            comb(i+1, len+1);
        }
    }
    
    public boolean isCorrect(HashSet<Integer> chk){
        for(int i = 0; i<q.length; i++){
            int count = 0;
            for(int num : q[i]){
                if(chk.contains(num)) count++;
            }
            if(count != ans[i]) return false;
        }
        return true;
    }
}
//조합 모두 생성
//생성한 조합이 
//응답에 따라 불가능한 조합 제거
