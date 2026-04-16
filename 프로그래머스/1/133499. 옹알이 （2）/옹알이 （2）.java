class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] canSpeak = {"aya", "ye", "woo", "ma"};
        
        for (String word : babbling) {
            boolean isValid = true;
            
            for (String s : canSpeak) {
                if (word.contains(s + s)) {
                    isValid = false;
                    break;
                }
            }
            
            if (!isValid) continue;
            
            for (String s : canSpeak) {
                word = word.replace(s, " ");
            }
            
            if (word.trim().length() == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}