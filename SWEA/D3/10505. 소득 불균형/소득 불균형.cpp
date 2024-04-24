#include<iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
	int test_case;
	int T,n,ans;
	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{
        
        cin >> n;
        vector<int> h(n);
        int total = 0, cnt=0;
        for(int i = 0; i<n; i++){
            cin >> h[i];
            total += h[i];
        }
        total /= n;
        for(auto& a : h){
            if(a <= total) cnt++;
        }
        

        cout << '#' << test_case << " "<< cnt <<'\n';
	}
	return 0;
}