#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int T,N;
//백트래킹으로 풀자~
void dfs(int idx, int score, vector<string> mbti, vector<bool>chk){
    //종료조건
    if(idx >= N) return;
    //짝짓기
    
    //재귀

}

int main() {
  cin >> T;
  for(int i = 0; i<T; i++){
      int w[4];
      vector<string> mbti;
      vector<int> ans;
      cin >> N;
      for(int j = 0; j<4; j++){
          cin >> w[j];
      }
      for(int m = 0; m<N; m++){
          string s;
          cin >> s;
          mbti.push_back(s);
      }
        //sort(mbti.begin(), mbti.end());
        vector<bool> chk(N,false);
        int score=0;
      //mbti 점수 매기기
        dfs(0, score, mbti, chk);
        cout << *min_element(ans.begin(), ans.end())<<endl;

        
  }
  return 0;
}