class Solution {
    public int solution(String t, String p) {
        int tLen = t.length();
        int pLen = p.length();
        
        long pValue = Long.parseLong(p);
        int answer = 0;

        for (int i = 0; i <= tLen - pLen; i++) {
            String sub = t.substring(i, i + pLen);
            if (Long.parseLong(sub) <= pValue) {
                answer++;
            }
        }

        return answer;
    }
}