#include<iostream>
#include <vector>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
	int test_case;
	int T,n,h;
	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{
        
        cin >> n;
        vector<int> h(n); int down=0, up=0;
        cin >> h[0];
        for(int i = 1; i<n; i++){
            cin >> h[i];
            //내리막
            if(h[i-1]>h[i]) down = max(down, h[i-1]-h[i]);
            //오르막
            else if(h[i-1]<h[i]) up = max(up, h[i]-h[i-1]);
        }
        
        cout << '#' << test_case << " "<<up << " "<< down <<'\n';
	}
	return 0;
}