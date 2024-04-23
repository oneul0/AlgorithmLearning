#include<iostream>
#include <algorithm>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
	int test_case;
	int T, dump;
	
	for(test_case = 1; test_case <= 10; ++test_case)
	{
        int v[100] = {0};
        cin >> dump;
        for(int i = 0; i<100; i++){
            cin >> v[i];
        }
        sort(v, v+100);
        while(dump--){
            if(v[99]-v[0]<=1) break;
            v[0] += 1;
            v[99] -= 1;
            sort(v, v+100);
        }
        sort(v, v+100);
        cout<< '#' << test_case << " " << v[99]-v[0] << '\n';
	}
	return 0;
}