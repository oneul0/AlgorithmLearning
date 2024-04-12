#include <iostream>
#include <vector>
using namespace std;

int n;
long long b;

vector<vector<long long>> matrixMultiply(const vector<vector<long long>>& A, const vector<vector<long long>>& B) {
    vector<vector<long long>> result(n, vector<long long>(n, 0));
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            for (int k = 0; k < n; ++k) {
                result[i][j] += A[i][k] * B[k][j];
            }
            result[i][j] %= 1000;
        }
    }
    return result;
}

vector<vector<long long>> matrixPow(const vector<vector<long long>>& matrix, long long power) {
    vector<vector<long long>> result(n, vector<long long>(n, 0));
    // 단위 행렬로 초기화
    for (int i = 0; i < n; ++i) {
        result[i][i] = 1;
    }
    vector<vector<long long>> base = matrix;
    while (power > 0) {
        if (power % 2 == 1) {
            result = matrixMultiply(result, base);
        }
        base = matrixMultiply(base, base);
        power /= 2;
    }
    
    
    return result;
}

int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n >> b;
    vector<vector<long long>> matrix(n, vector<long long>(n, 0));

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> matrix[i][j];
        }
    }

    vector<vector<long long>> ans = matrixPow(matrix, b);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cout << ans[i][j] << " ";
        }
        cout << '\n';
    }
    return 0;
}
