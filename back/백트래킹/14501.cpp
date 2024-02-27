#include <iostream>

using namespace std;

int N;
int* T; // Ti
int* P; // Pi
int max_pay = 0;

void input(){
    cin >> N;
    T = new int[N + 1];
    P = new int[N + 1];
    for(int i = 0; i < N; i++) {
        cin >> T[i] >> P[i];
    }
}

void solution(int x, int sum){
    if (x > N) return;

    max_pay = max(max_pay, sum);
    for(int i = x; i < N; i++) {
        solution(T[i] + i, sum + P[i]);
    }
}

int main () {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    input();
    solution(0, 0);
    delete[] T,P;
    cout << max_pay;
}