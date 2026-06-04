class Solution {
    public String maskPII(String s) {
        String result;
        //email
        if(s.indexOf('@') != -1){
            result = maskingEmail(s);
        }
        //phone
        else{
            result = maskingNumber(s);
        }

        return result;
    }


    //email
    public String maskingEmail(String s){
        s = s.toLowerCase();
        String[] sub = s.split("@");
        StringBuilder sb = new StringBuilder();
        sb.append(sub[0].charAt(0)).append("*****").append(sub[0].charAt(sub[0].length()-1));
        sb.append("@").append(sub[1]);
        return sb.toString();
    }

    //phone
    public String maskingNumber(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') sb.append(s.charAt(i));
        }

        int len = sb.length();
        String str = sb.toString();
        if(len == 10){
            return "***-***-"+str.substring(len-4, len);
        }
        else if(len == 11){
            return "+*-***-***-"+str.substring(len-4, len);
        }
        else if(len == 12){
            return "+**-***-***-"+str.substring(len-4, len);
        }
        else if(len == 13){
            return "+***-***-***-"+str.substring(len-4, len);
        }
        
        return "";
    }

}