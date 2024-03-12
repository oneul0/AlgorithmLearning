#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<int> A(N);
    for (int i = 0; i < N; ++i) {
        cin >> A[i];
    }

    vector<int> result(N, -1);
    stack<int> st;

    for (int i = N - 1; i >= 0; --i) {
        while (!st.empty() && A[i] >= A[st.top()]) {
            st.pop();
        }

        if (!st.empty()) {
            result[i] = A[st.top()];
        }

        st.push(i);
    }

    for (int i = 0; i < N; ++i) {
        cout << result[i] << " ";
    }
    
    return 0;
}
