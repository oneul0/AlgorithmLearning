#include <iostream>
#include <string>
using namespace std;

bool isPalindrome(string s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
        if (s[left] != s[right]) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}

bool isPseudoPalindrome(string s, int left, int right) {
    while (left < right) {
        if (s[left] != s[right]) {
            return isPalindrome(s.substr(left, right - left)) || isPalindrome(s.substr(left + 1, right - left));
        }
        left++;
        right--;
    }
    return true;
}

int main() {
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    int T;
    cin >> T;

    for (int i = 0; i < T; ++i) {
        string s;
        cin >> s;

        if (isPalindrome(s)) {
            cout << 0 << endl;
        } else if (isPseudoPalindrome(s, 0, s.length() - 1)) {
            cout << 1 << endl;
        } else {
            cout << 2 << endl;
        }
    }

    return 0;
}
