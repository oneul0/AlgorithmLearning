import java.util.*;
class Solution {
    int maxNum = 10000000, answer=0;
    boolean[] eratos = new boolean[maxNum];
    HashSet<String> primes = new HashSet<>();
    int[] nums;
    public int solution(String numbers) {

        makeEratos();
        nums = new int[numbers.length()];
        for(int i = 0; i<numbers.length(); i++){
            nums[i] = numbers.charAt(i) - '0';
        }

        makePrime("", new boolean[numbers.length()]);

        return answer;
    }

    void makePrime(String num, boolean[] chk){
        if(!num.isEmpty() && !eratos[Integer.parseInt(num)] && !primes.contains(num)){
                primes.add(num);
                answer++;
        }
        for(int i = 0; i<nums.length; i++){
            if(num.isEmpty() && nums[i] == 0) continue;
            if(!chk[i]){
                chk[i] = true;
                makePrime(num+nums[i], chk);
                chk[i] = false;
            }
        }
    }

    void makeEratos(){
        eratos[0] = eratos[1] = true;
        for(int i = 2; i*i<maxNum; i++){
            if(!eratos[i]){
                for(int j = i*i; j<maxNum; j+=i){
                    eratos[j] = true;
                }
            }
        }
    }
}




