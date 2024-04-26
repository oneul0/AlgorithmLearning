#include<iostream>
#include <map>
using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);cin.tie(nullptr);
	int test_case;
	int T;

	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        string s;
        int ans, a=1, b=1;
        cin >> s;
        for(char& c : s){
            if(c == 'L'){
                b += a;
            }
            else if(c == 'R'){
                a += b;
            }
        }
        cout << '#'<<test_case<<" "<<a << " "<< b << " "<<'\n';
	}
	return 0;
}