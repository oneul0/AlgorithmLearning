class Solution {
    public int solution(int price) {
        int percentage = 0;
        if(price>=500_000){
            percentage = 20;
        }
        else if(price>=300_000){
            percentage = 10;
        }
        else if(price>=100_000) {
            percentage = 5;
        }
        
        return (price*(100-percentage)/100);
    }
}