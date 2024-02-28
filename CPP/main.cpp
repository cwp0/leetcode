#include <iostream>

using namespace std;

int main() {
    int r = 0;
    start:
    int m = r;
    for(int i = m; i < 10; i++) {
        cout << "前" << i << endl;
        r = i + 2;
        cout << r << endl;
        cout << "后" << i << endl;
        goto start;
    }

    return 0;
}
