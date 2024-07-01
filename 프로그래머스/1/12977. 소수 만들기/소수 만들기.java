import java.io.IOException;
import java.util.Arrays;
class Solution {
  boolean[] eratos(int max){
        boolean[] isPrime = new boolean[max];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i = 2 ; i*i<=max ; i++){
            if(isPrime[i]){
                for(int j = i*i; j <=max ; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public int solution(int[] nums) {
        int answer = 0;
        boolean[] isPrime = eratos(2999);

        for(int i = 0 ; i < nums.length-2; i++){
            for(int j = i+1 ; j < nums.length-1; j++){
                for(int k = j+1 ; k < nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isPrime[sum]){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}