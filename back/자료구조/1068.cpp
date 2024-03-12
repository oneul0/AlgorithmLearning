#include <iostream>
#include <vector>
using namespace std;

int n=0, deleteNode = 0, leafCnt = 0, chk=0;
vector<int> v;
void delCnt(int pos){
    if(v[pos] == -2) return;
    v[pos] = -2;
    for(int i = 0; i<n; i++){
        if(v[i] == pos) delCnt(i);
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n;
    
    for(int i = 0; i<n; i++){
        int parent;
        cin >> parent;
        if(parent == -1) chk = i;
        v.push_back(parent);
    }
    cin>>deleteNode;
    if(deleteNode == chk){
        cout << 0;
        return 0;
    }
    delCnt(deleteNode);
    for(int i = 0; i<n; i++){
        int isNotLeafNode = 0;
        if(v[i] == -2) continue;
        //i노드가 자식 노드를 가지는지 체크
        for(int j = 0; j<n; j++){
            if(v[j] == i) isNotLeafNode = 1;
        }
        //i가 자식 노드가 없는 노드면 cnt++
        if(!isNotLeafNode) leafCnt++;
    }
    
    cout << leafCnt;
    return 0;
}