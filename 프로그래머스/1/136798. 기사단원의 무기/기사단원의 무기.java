class Solution {
    public int solution(int number, int limit, int power) {
        int[] factors = new int[number+1];
        getFactors(number, factors);
        
        int answer = 0;
        for(int i = 1; i<=number; i++){
            int demage = factors[i];
            if(factors[i] > limit) demage = power;
            answer+=demage;
        }
        return answer;
    }
    public void getFactors(int number, int[] factors){
        for(int i = 1; i<=number; i++){
            factors[i]++;
            for(int j = i+i; j<=number; j+=i){
                factors[j]++;
            }
        }
    }
}