import java.util.*;
class Solution {
    class Word implements Comparable<Word> {
        String word;
        int n;
        Word(String word, int n){
            this.word = word;
            this.n = n;
        }
        @Override
        public int compareTo(Word o){
            char a = this.word.charAt(n);
            char b = o.word.charAt(n);
            if(a != b) return Character.compare(a, b);
            return this.word.compareTo(o.word);
        }
    }
    public String[] solution(String[] strings, int n) {
        int len = strings.length;
        String[] answer = new String[len];
        Word[] tmp = new Word[len];
        
        for(int i = 0; i<len; i++){
            tmp[i] = new Word(strings[i], n);
        }
        Arrays.sort(tmp);
        for(int i = 0; i<len; i++){
            answer[i] = tmp[i].word;
        }
        return answer;
    }
}