class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> nums = new ArrayDeque<>();
        Set<String> isOps = new HashSet<>();
        isOps.add("+");
        isOps.add("-");
        isOps.add("*");
        isOps.add("/");
        for(int i = 0; i<tokens.length; i++){
            if(isOps.contains(tokens[i])){
                String b = nums.pop();
                String a = nums.pop();
                String val = calc(a, b, tokens[i]);
                nums.push(val);
            }
            else{
                nums.push(tokens[i]);
            }
        }
        return Integer.parseInt(nums.pop());
    }

    public String calc(String a, String b, String op){
        int aVal = Integer.parseInt(a);
        int bVal = Integer.parseInt(b);
        
        switch(op){
            case "+":
                return String.valueOf(aVal+bVal);
            case "-":
                return String.valueOf(aVal-bVal);
            case "*":
                return String.valueOf(aVal*bVal);
            case "/":
                return String.valueOf(aVal/bVal);
            default:
                return "";
        }
    }
}