class Solution {
    public int solution(int num) {
        long tmp = num;
        for(int i = 0; i<500; i++){
            if(tmp == 1) return i;
            if(tmp % 2 == 0) tmp /= 2;
            else tmp = (tmp * 3)+1;
        }
        return -1;
    }
}