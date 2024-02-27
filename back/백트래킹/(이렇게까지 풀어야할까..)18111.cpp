#include <iostream>

using namespace std;

int N, M, B;
int** map;
int** inventory;

void init_map(int N){
    map = new int*[N+1];
    inventory = new int*[N+1];
    for(int i = 0; i<N+1; i++){
        map[i] = new int[N+1]; //동적 할당
        inventory[i] = new int[N+1];
    }
}

void destroy_map(int N){
    for(int i = 0; i<N+1; i++){
        delete[] map[i];
        delete[] inventory[i];
    }
    delete[] map;
    delete[] inventory;
}

void flattening(){
    
}

int main(){
    cin >> N >> M >> B;
    init_map(N);

    for(int i = 0; i<N; i++){
        for(int j = 0; j<N; j++){
            cin >> map[i][j];
        }
    }



    destroy_map(N);
    return 0;
}