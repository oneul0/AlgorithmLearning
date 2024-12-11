import java.util.*;

class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    HashMap<String, List<Song>> songs = new HashMap<>();
    
    public int[] solution(String[] genres, int[] plays) {
        // Map으로 장르별 총합 구하기
        for (int i = 0; i < genres.length; i++) {
            if (map.containsKey(genres[i])) {
                map.put(genres[i], map.get(genres[i]) + plays[i]);
                songs.get(genres[i]).add(new Song(i, plays[i]));
            } else {
                map.put(genres[i], plays[i]);
                List<Song> songList = new ArrayList<>();
                songList.add(new Song(i, plays[i]));
                songs.put(genres[i], songList);
            }
        }
        
        // 상위 2개 장르 추출
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue())); // 내림차순
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < entryList.size(); i++) {
            List<Song> tmp = songs.get(entryList.get(i).getKey());
            tmp.sort(Song::compareTo); // 내림차순
            for (int j = 0; j < Math.min(2, tmp.size()); j++) {
                ans.add(tmp.get(j).idx);
            }
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}

class Song implements Comparable<Song> {
    int idx, played;
    
    Song(int idx, int played) {
        this.idx = idx;
        this.played = played;
    }
    
    @Override
    public int compareTo(Song o) {
        if (this.played == o.played) {
            return Integer.compare(this.idx, o.idx);
        }
        return Integer.compare(o.played, this.played);
    }
}
