import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();

        for (int i=0; i<players.length; i++) {
            rank.put(players[i], i);
        }

        for (String called : callings) {
            int idx = rank.get(called);

            String front = players[idx-1];

            players[idx-1] = called;
            players[idx] = front;

            rank.put(called, idx-1);
            rank.put(front, idx);
        }

        return players;
    }
}