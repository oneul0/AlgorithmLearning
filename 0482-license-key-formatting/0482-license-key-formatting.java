class Solution {
    public String licenseKeyFormatting(String s, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '-') continue;
            else {
                char c = s.charAt(i);
                if(c>='a' && c<='z') c = Character.toUpperCase(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(!stack.isEmpty()){
            if(count<k){
                sb.append(stack.pop());
                count++;
            }
            else{
                sb.append("-");
                count = 0;
            }
        }
        return sb.reverse().toString();
    }
}