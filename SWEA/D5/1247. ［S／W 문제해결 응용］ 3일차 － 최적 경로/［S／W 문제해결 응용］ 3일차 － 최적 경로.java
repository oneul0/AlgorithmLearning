import java.util.*;
import java.io.*;

class Solution
{
    static class Coord {
        int x, y;
        Coord(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int answer;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
            answer =987654321;
            StringTokenizer st = new StringTokenizer(br.readLine());
            Coord cur = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Coord home = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Coord[] customers = new Coord[N];
            for(int i = 0; i<N; i++){
                customers[i] = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
			findMinDist(cur, home,customers, 0, 0, new boolean[N], N);
            bw.write("#"+test_case+" "+answer+"\n");
		}
        
        bw.flush();
        bw.close();
        br.close();
	}
    
    //거리가 같지만 방위가 다른 여러 지점이 존재할 수도 있음
    //따라서 bfs로 최단거리를 보장할 수 없으므로
    //N<=10이므로 백트래킹으로 갈 수 있는 후보군을 모두 탐색한다
    //depth(방문한 집의 수)일 때 가장 작은 경우로 탐색을 이어가면 됨
	public static void findMinDist(Coord cur, Coord home, Coord[] customers, int depth, int dist, boolean[] visited, int N){
        if(depth == N){
            answer = Math.min(answer, getDist(cur, home)+dist);
			return;
        }
        for(int i = 0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            findMinDist(customers[i], home, customers, depth+1, dist+getDist(cur, customers[i]), visited, N);
            visited[i] = false;
        }
    }
       
    public static int getDist(Coord c1, Coord c2){
        int x1 = c1.x;
        int y1 = c1.y;
        int x2 = c2.x;
        int y2 = c2.y;
        return (int) Math.abs(x2-x1) + (int) Math.abs(y2-y1);
    }
}