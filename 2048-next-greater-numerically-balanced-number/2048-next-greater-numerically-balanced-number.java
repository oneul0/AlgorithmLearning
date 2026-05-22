class Solution {
    public int nextBeautifulNumber(int n) {
        int x = n+1;
        while(true){
            if(isBNum(x)) return x;
            x++;
        }
    }
    public boolean isBNum(int num){
        int[] count = new int[10];
        while(num >0){
            int idx = num%10;
            count[idx]++;
            num /= 10;
        }
        for(int i = 0; i<=9; i++){
            if(count[i] > 0 && count[i] != i) return false;
        }

        return true;
    }
}