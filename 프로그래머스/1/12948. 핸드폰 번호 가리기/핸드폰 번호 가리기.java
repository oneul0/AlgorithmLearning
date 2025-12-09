class Solution {
    public String solution(String phone_number) {
        int masking = phone_number.length()-4;
        String answer = "*".repeat(masking) + phone_number.substring(masking);
        return answer;
    }
}