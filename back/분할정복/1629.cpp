// #include <iostream>
// #include <algorithm>
// #include <cmath>
// #include <vector>

// using namespace std;
// long long a, b, c, ans;

// int main(){
//     ios_base::sync_with_stdio(0); cin.tie(0);
//     cin >> a >> b >> c;
//     vector<long long> DP(b+1,0);
//     int tmp = b/2;

//     DP[0] = a%c;

//     for(int i = 1; i<=tmp; i++){
//         DP[i] = (DP[i-1]*a)%c;
//     }
//     if(b%2==0) ans = DP[tmp]*DP[tmp]%c;
//     else ans = DP[tmp]*DP[tmp]%c * a%c;
//     cout << ans;
//     return 0;
// }


// BOJ - 1629 Multiplication
#include <iostream>
using namespace std;
// a^b = a^(b/2) x a^(b/2)		2147483647
long long a, b, c, k;

long long power(long long b) {
	if (b == 0) return 1;
	if (b == 1) return a;
	
	k = power(b / 2);
	// if (b % 2 == 0) return k * k % c;
	// return k * k % c * a % c;
    return k;
}

int main(void) {
	cin >> a >> b >> c; 
	cout << power(b);

	return 0;
}