class Solution {
    int n, target, answer = 0;
    int[] numbers;
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        this.target = target;
        this.numbers = numbers;
        dfs(0, 0);
        return answer;
    }
    
    public void dfs(int val,int idx){
        if(idx >= n){
            if(target==val) answer++;
            return;
        }
        dfs(val + numbers[idx], idx+1);
        dfs(val - numbers[idx], idx+1);
    }
}