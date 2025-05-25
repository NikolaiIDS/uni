#include <iostream>

using namespace std;

void input (int *x, int *y) {
    for (int i = 0; i < 5; i++) {
        cin >> x[i];
    }
    for (int i = 0; i < 5; i++) {
        cin >> y[i];
    }
}

void sortArray(int *x) {
    for (int i = 0; i < 5; i++) {
        for (int j = i + 1; j < 5; j++) {
            if (x[i] > x[j]) {
                int temp = x[i];
                x[i] = x[j];
                x[j] = temp;
            }
        }
    }
}

void checkContainsMin(int *x, int *y) {
    for (int i = 0; i < 5; i++) {
        bool found = false;
        for (int j = 0; j < 5; j++) {
            if (x[i] == y[j]) {
                found = true;
                break;
            }
    }
    if (!found) {
        cout << "Minimum element from X not in Y: " << x[i] << endl;
        return;
    }
}
cout << "All minimum elements from X are in Y." << endl;
}

int main() {
    cout << "Enter 5 integers for array X:" << endl;
    int x[5] = {};
    int y[5] = {};
    input(x, y);
    sortArray(x);
    sortArray(y);

    return 0;
}