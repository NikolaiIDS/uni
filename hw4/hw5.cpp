#include <iostream>
using namespace std;

bool isPrime(int num) {
    if (num < 2) return false;
    for (int i = 2; i * i <= num; ++i)
        if (num % i == 0) return false;
    return true;
}

void findPrimePairs(int n) {
    if (n <= 13) {
        cout << "The number must be greater than 13.\n";
        return;
    }

    int* primes = new int[n];
    int count = 0;

    for (int i = 2; i < n; ++i) {
        if (isPrime(i)) {
            primes[count++] = i;
        }
    }

    cout << "Pairs with a difference of 4:\n";
    for (int i = 0; i < count; ++i) {
        for (int j = i + 1; j < count; ++j) {
            if (primes[j] - primes[i] == 4)
                cout << "(" << primes[i] << ", " << primes[j] << ")\n";
        }
    }

    delete[] primes;
}

int main() {
    int n;
    cout << "Enter a natural number > 13: ";
    cin >> n;
    findPrimePairs(n);
    return 0;
}
