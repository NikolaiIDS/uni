#include <iostream>
using namespace std;

void generateMatrix(int n) {
    int matrix[20][20] = { 0 }; 

    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            matrix[i][j] = n - i; 
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }
}

int main() {
    int n;
    cout << "Enter matrix size (n, max 20): ";
    cin >> n;

    if (n > 20 || n < 1) {
        cout << "Invalid value for n!";
        return 1;
    }

    generateMatrix(n);
    return 0;
}
