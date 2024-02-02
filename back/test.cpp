#include<iostream>
#include <vector>
#include <climits>
using namespace std;
int n;

vector<vector<int>> v;

#define INF INT_MAX

void Floyd()
{   
    for(int k=0;k<n;k++)
    {   
        for(int i=0;i<n;i++)
        {   
            for(int j=0;j<n;j++)
            {   
                v[i][j] =min(v[i][j],v[i][k]+v[k][j]);
            }
        }
    }
}

int main()
{   cin>>n;

    v.resize(n);

    for(int i=0;i<n;i++)
    {   for(int j=0;j<n;j++){
            int t;
            cin>>t;
            v[i].push_back(t);
        }
        
    }
    for(int i=0;i<n;i++)
    {   
        for(int j=0;j<n;j++)
        {   
            if(v[i][j]==0)
            v[i][j]=INF;
        }
    }
    
    Floyd();
    for(int i=0;i<n;i++)
    {   for(int j=0;j<n;j++)
        {   
            if(v[i][j]==INF) cout<<0<<' ';
            else cout<<1<<' ';
        }
        cout<<'\n';
    }
}