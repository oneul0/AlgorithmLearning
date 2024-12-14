import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, K;
    static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1,1}, {1,0}, {1, -1}, {0, -1}, {-1,-1}};
    static ArrayList<Ball>[][] map;
    static ArrayList<Ball> balls = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        String[] nmk = br.readLine().split(" ");
        N = Integer.parseInt(nmk[0]);
        M = Integer.parseInt(nmk[1]);
        K = Integer.parseInt(nmk[2]);
        map = new ArrayList[N][N];
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                map[i][j] = new ArrayList<>();
            }
        }
        // 볼 정보 저장
        for(int i = 0; i<M; i++){
            String[] b = br.readLine().split(" ");
            int r = Integer.parseInt(b[0])-1;
            int c = Integer.parseInt(b[1])-1;
            int m = Integer.parseInt(b[2]);
            int s = Integer.parseInt(b[3]);
            int d = Integer.parseInt(b[4]);
            balls.add(new Ball(r, c, m, s, d));
        }

        //K번 반복
        for(int i = 0; i<K; i++){
            //시뮬레이션 시작
            //1. 위치 이동
            move(N);
            divide(N);
        }
        
        int answer = 0;
        for(Ball b : balls){
            answer += b.m;
        }
        bw.write(answer+"");
        bw.flush();
        br.close();
        bw.close();
    }

    //1. 위치 이동 함수
    static void move(int N){
        for(Ball cur : balls){
            int nxtR = (cur.r+N+dir[cur.d][0] * (cur.s%N)) % N;
            int nxtC = (cur.c+N+dir[cur.d][1] * (cur.s%N)) % N;
            cur.r = nxtR;
            cur.c = nxtC;
            map[cur.r][cur.c].add(cur);
        }
    }

    static void divide(int N){
        for(int r = 0; r<N; r++){
            for(int c = 0; c<N; c++){
                if(map[r][c].size() < 2){
                    map[r][c].clear();
                    continue;
                }
                
                //여러개일 경우
                int mSum = 0, sSum = 0, odd = 0, even = 0;
                int size = map[r][c].size();
                
                for(Ball cur : map[r][c]){
                    mSum += cur.m;
                    sSum += cur.s;
                    if(cur.d %2 == 1) odd++;
                    else even++;
                    
                    balls.remove(cur); //모여있던 부분 삭제
                }

                map[r][c].clear();
                mSum /= 5;
                if(mSum == 0) continue;
                
                sSum /= size;
                
                if(odd == size || even == size){
                    for(int i = 0; i<dir.length; i+=2){ //짝수 방향
                        balls.add(new Ball(r,c,mSum,sSum,i));
                    }
                }
                else{
                    for(int i = 1; i<dir.length; i+=2){ //홀수 방향
                        balls.add(new Ball(r,c,mSum,sSum,i));
                    }
                }
            }
            
        }
    }
}

class Ball{
    // (r,c), 질량m, 속력 s, 방향 d
    int r, c, m, s, d;

    Ball(int r, int c, int m, int s, int d){
        this.r = r;
        this.c = c;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}

/*
k번 반복{
    1. 불공들 미리 입력된 정보를 기반으로 이동
    2. 합쳐진 불공 질량, 속력, 방향 공식에 의해서 계산하여 위치에 저장
    3. 질량 0인 불공 삭제 처리
}
남은 불공 질량의 합 구하기
* */

/*
*
* 1. 모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동한다.
-이동하는 중에는 같은 칸에 여러 개의 파이어볼이 있을 수도 있다.

* 2. 이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서는 다음과 같은 일이 일어난다.
2.1 같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
2.2 파이어볼은 4개의 파이어볼로 나누어진다.

* 3. 나누어진 파이어볼의 질량, 속력, 방향은 다음과 같다.
3.1 질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다.
3.2 속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.
3.3 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 된다.
3.4 질량이 0인 파이어볼은 소멸되어 없어진다.
*
* ri, ci, mi, si, di
* 마법사 상어가 이동을 K번 명령한 후, 남아있는 파이어볼 질량의 합을 구해보자.
* */