class Solution {
    public int solution(int[] numbers) {
        int answer = 1+2+3+4+5+6+7+8+9;
        for(int num : numbers){
            answer -= num;
        }
        return answer;
    }
}