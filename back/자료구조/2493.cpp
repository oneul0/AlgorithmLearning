#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int N, tower;
stack<pair<int,int>> st;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    cin >> N;
    for(int i = 1; i<=N; i++){
        cin >> tower;
        while(!st.empty()){
            if(st.top().second>tower){
                cout << st.top().first<<" ";
                break;
            }
            st.pop();//낮은 타워는 높은 타워 뒤에 있으면 어짜피 받지 못함.
        }
        if(st.empty()) cout << "0 ";
        st.push({i,tower});
    }
    
    return 0;
}
