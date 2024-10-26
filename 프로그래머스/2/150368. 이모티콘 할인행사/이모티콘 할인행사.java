import java.util.*;
class Solution {
    int[] discount = {10,20,30,40}, answer = new int[2];
    ArrayList<Pair> emoPrice = new ArrayList<>();
    int[][] users;
    int[] emoticons;
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        for(int i = 0; i<7; i++) emoPrice.add(new Pair(0,0));
        dfs(0, emoticons.length, users, emoticons);
        return answer;
    }
    
    void dfs(int emoticon, int emoCount, int[][] users, int[] emoticons){
        if(emoticon < emoCount){
            for(int i = 0; i<discount.length; i++){
                emoPrice.get(emoticon).saledPrice = emoticons[emoticon] - ((emoticons[emoticon]/100)*discount[i]);
                emoPrice.get(emoticon).discount = discount[i];
                dfs(emoticon+1, emoCount, users, emoticons);
            }
        }        
        else{
            int subs = 0, totalCart = 0;
            
            for(int i = 0; i<users.length; i++){
                int cart = 0;
                for(int j = 0; j<emoCount; j++){
                    if(emoPrice.get(j).discount >= users[i][0]){
                        cart += emoPrice.get(j).saledPrice;
                    }
                }
                //구독 or 구매
                if(cart >= users[i][1]){
                    subs++;
                }
                else{
                    totalCart += cart;
                }
            }
            
            if(subs > answer[0]){
                answer[0] = subs;
                answer[1] = totalCart;
            }
            else if(subs == answer[0] && totalCart > answer[1]){
                answer[1] = totalCart;
            }
            return;
        }
    }
}

class Pair{
    int saledPrice, discount;
    Pair(int saledPrice, int discount){
        this.saledPrice = saledPrice;
        this.discount = discount;
    }
}



