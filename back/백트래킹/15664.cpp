#include<iostream>
#include<algorithm>

using namespace std;

int arr[10], choose[10], N, M;
bool used[10];

void dfs(int cnt) {
    if(cnt == M) { //길이가 M이 되면 출력
        for(int i=0;i<M;i++) {
            cout << arr[choose[i]] << ' ';
        }
        cout << '\n';
        return;
    }
    int pre = -1;
    for(int i=0;i<N;i++) {
        if(used[i] || pre == arr[i]) continue; //방문했거나 같은 숫자이면 continue
        pre = arr[i];
        used[i] = true; //사용(방문) 체크
        choose[cnt] = i;
        dfs(cnt + 1);
        used[i] = false;
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> N >> M;
    for(int i=0;i<N;i++) cin >> arr[i];
    sort(arr, arr + N);
    dfs(0);

    return 0;
}