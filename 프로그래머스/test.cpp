#include <iostream>

// 주어진 숫자의 n번째 비트와 m번째 비트를 바꾸는 함수
int swapBits(int num, int n, int m) {
    // n번째 비트와 m번째 비트를 추출합니다.
    int nthBit = (num >> n) & 1;
    int mthBit = (num >> m) & 1;

    // n번째 비트와 m번째 비트를 서로 바꿉니다.
    num = num & (~(1 << n)); // n번째 비트를 0으로 설정합니다.
    num = num | (mthBit << n); // n번째 비트에 m번째 비트의 값을 삽입합니다.
    num = num & (~(1 << m)); // m번째 비트를 0으로 설정합니다.
    num = num | (nthBit << m); // m번째 비트에 n번째 비트의 값을 삽입합니다.

    return num;
}

int main() {
    int originalNumber = 12;
    int n = 1; // 바꾸고 싶은 첫 번째 비트의 위치
    int m = 3; // 바꾸고 싶은 두 번째 비트의 위치

    int swappedNumber = swapBits(originalNumber, n, m);

    std::cout << "Original number: " << originalNumber << std::endl;
    std::cout << "Swapped number: " << swappedNumber << std::endl;

    return 0;
}
