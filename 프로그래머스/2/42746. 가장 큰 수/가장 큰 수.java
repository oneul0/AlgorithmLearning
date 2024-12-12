import java.util.*;
class Solution {
    String answer;
    int[] numbers;
    ArrayList<String> arr = new ArrayList<>();
    public String solution(int[] numbers) throws Exception{
        this.numbers = numbers;
        int flag = 0;
        for(int i : numbers){
            arr.add(i+"");
            flag += i;
        }
        if(flag == 0) return "0";
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String ss = s1+s2;
                String sss = s2+s1;
                return Integer.parseInt(sss) - Integer.parseInt(ss);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String num : arr){
            sb.append(Integer.parseInt(num));
        }
        
        
        return sb.toString();
    }
    //9533430
    //9534330
}

//두 문자열 중 작은 것 기준으로 length 산정
//비교하며 크거나 같으면 짧은 것 앞으로