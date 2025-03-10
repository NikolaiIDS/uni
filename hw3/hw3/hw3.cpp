#include <iostream>

using namespace std;


int main() {

    int n = 5;
    int matrix[5][5];

    int upperValue = n * n - n;
    int lowerValue = 0;

    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            if (i == j) {
                matrix[i][j] = 0;  
            }
            else {
                matrix[i][j] = upperValue--;
            }
        }
    }

    for (int j = 0; j < n; j++) {
        for (int i = j + 1; i < n; i++) {
            matrix[i][j] = ++lowerValue;
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}
