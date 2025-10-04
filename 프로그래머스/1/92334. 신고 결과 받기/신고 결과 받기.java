import java.util.*;
class Solution {
    
    public int[] solution(String[] id_list, String[] report, int k) {
        int N =id_list.length;
        Map<String, Integer> name_id = new HashMap<>();
        for(int i = 0; i<N; i++){
            name_id.putIfAbsent(id_list[i], i);
        }
        
        List<Set<String>> reported = new ArrayList<>(); //신고당한 횟수
        for(int i = 0; i<N; i++){
            reported.add(new HashSet<>());
        }
        
        for(String rel : report){
            String[] tmp = rel.split(" ");
            int user_id = name_id.get(tmp[0]);
            int reported_id = name_id.get(tmp[1]);
            reported.get(reported_id).add(tmp[0]);
        }
        
        int[] answer = new int[N];
        for(int i = 0; i<N; i++){
            if(reported.get(i).size() >= k){
                for(String name : reported.get(i)){
                    int user_id = name_id.get(name);
                    answer[user_id]++;
                }
                
            }
        }
        
        return answer;
    }
}