import java.util.*;
class Solution {
    int time, healPerSec, additionalHeal;
    int maxHp;
    Map<Integer, Integer> map = new HashMap<>();
    int[] status;
    public int solution(int[] bandage, int health, int[][] attacks) {
        this.maxHp = health;
        this.time = bandage[0];
        this.healPerSec = bandage[1];
        this.additionalHeal = bandage[2];
        int maxlen = attacks[attacks.length-1][0];
        status = new int[maxlen+1];
        status[0] = 0;
        
        for(int[] attack : attacks){
            map.put(attack[0], attack[1]);
        }
        
        //전체 체력은 전역으로
        //연속 성공 여부를 status로
        int cur = maxHp;
        for(int i = 1; i<=maxlen; i++){
            if(map.containsKey(i)){
                cur -= map.get(i);
                status[i] = 0;
            }
            else{
                status[i] = status[i-1]+1;
                cur = (cur+healPerSec) > maxHp ? maxHp : cur+healPerSec;
            }
            if(cur <= 0){
                cur = -1;
                break;
            }
            if(cur == maxHp) continue;
            if(status[i] == time){
                cur = (cur+additionalHeal) > maxHp ? maxHp : cur+additionalHeal;
                status[i] = 0;
            }
        }
        return cur;
    }
}