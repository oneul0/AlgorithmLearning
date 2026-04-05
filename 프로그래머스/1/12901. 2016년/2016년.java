class Solution {
    public String solution(int a, int b) {
        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int total = 0;
        for(int i = 0; i<a-1; i++){
            total += months[i];
        }
        total+=(b-1);
        return days[total%7];
    }
}