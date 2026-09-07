import java.util.*;
import java.io.*;

class Solution
{
    static class Cage {
        int l, r, s;
        Cage(int l, int r, int s){
            this.l = l;
            this.r = r;
            this.s = s;
        }
    }
    static int N, X, M;
    static int[] arr, answer;
    static Cage[] ham;
    static boolean found;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            ham = new Cage[M];
            arr = new int[N+1];
            answer = new int[N+1];
            found = false;
            for(int i = 0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                ham[i] = new Cage(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
            dfs(N);
            bw.write("#"+test_case+" ");
            if(!found) bw.write("-1");
            else{
                for(int i = 1; i<=N; i++){
                    bw.write(answer[i]+" ");
                }
            }
            bw.newLine();
		}
        bw.flush();
        br.close();
        bw.close();
	}
    
    public static void dfs(int idx) throws Exception {
        if(found) return;
        
        if(idx == 0){
            answer = arr.clone();
            found = true;
            return;
        }
        for(int cur = X; cur>=0; cur--){
			arr[idx] = cur;
            if(isValid(idx)){
                dfs(idx-1);
            }
            if(found) return;
        }
    }
    public static boolean isValid(int idx){
        for(Cage c : ham){
            if(idx>c.r || idx<c.l) continue;
            
            int sum = 0;
            
            for(int i = idx; i<=c.r; i++){
                sum += arr[i];
            }
            
            //l까지 도착했으면 구간이 완성된 것이므로 si와 다르다면 안되는 경우
            if(idx == c.l){
                if(sum != c.s) return false;
            }
            else{
                if(sum > c.s) return false; //이 시점에서 si보다 크면 불가능
                int remain = idx - c.l;
                if(sum + remain * X < c.s) return false; //앞을 전부 X로 채워도 안되면 불가능
            }
        }
        return true;
    }
}

//뒤에서부터 arr을 채우되, 구간의 최대값(s) Math.min(X, s)를 먼저 넣어줘서 뒤에서부터 큰 값을 채워나갈 수 있도록 한다
