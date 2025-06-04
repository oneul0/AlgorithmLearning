#include <iostream>
#include <string>

using namespace std;

long calculate_hash(const string& str, int R, int MOD) {
    long ans = 0;
    long R_power = 1;
    int n = str.length();

    for(int i = 0; i < n; ++i){
        long char_val = static_cast<long>(str[i] - 96);
        long term = (char_val * R_power) % MOD;

        ans = (ans + term) % MOD;

        R_power = (R_power * R) % MOD;
    }
    return ans;
}

int main() {
    const int base = 31, modulus = 1234567891;

    int n;
    string str;
    cin >> n >> str;

    long hash_value = calculate_hash(str, base, modulus);
    cout << hash_value;
    return 0;
}