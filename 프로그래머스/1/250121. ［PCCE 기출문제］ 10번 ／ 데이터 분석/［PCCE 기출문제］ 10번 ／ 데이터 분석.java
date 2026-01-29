import java.util.*;
class Solution {
    class Data implements Comparable<Data> {
        int code, date, maximum, remain;
        String sortBy;
        Data(int code, int date, int maximum, int remain, String sortBy){
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
            this.sortBy = sortBy;
        }
        
        @Override
        public int compareTo(Data o){
            switch(this.sortBy){
                case "code":
                    return this.code - o.code;
                case "date":
                    return this.date - o.date;
                case "maximum":
                    return this.maximum - o.maximum;
                case "remain":
                    return this.remain - o.remain;
                default:
                    break;
            }
            return this.code- o.code;
        }
        
    }
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Data> datas = new ArrayList<>();
        for(int i = 0; i<data.length; i++){
            if(chkExt(data, i, val_ext, ext)){
                datas.add(new Data(data[i][0], data[i][1], data[i][2], data[i][3], sort_by));    
            }
        }
        Collections.sort(datas);
        int[][] answer = new int[datas.size()][4];
        for(int i = 0; i<datas.size(); i++){
            answer[i] = new int[]{datas.get(i).code, 
                                  datas.get(i).date,
                                  datas.get(i).maximum,
                                  datas.get(i).remain
                                  };
        }
        return answer;
    }
    public boolean chkExt(int[][] data, int idx, int valExt, String ext){
        int[] cur = data[idx];
        switch(ext){
                case "code":
                    if(cur[0] >= valExt) return false;
                    break;
                case "date":
                    if(cur[1] >= valExt) return false;
                    break;
                case "maximum":
                    if(cur[2] >= valExt) return false;
                    break;
                case "remain":
                    if(cur[3] >= valExt) return false;
                    break;
                default:
                    break;
        }
        return true;
    }
}