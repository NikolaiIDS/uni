#include <iostream>
using namespace std;

const int n = 20;

void moveToLeft(int arr[], int k){
    int arrT[n];

    if (k > n)
    {
        k = k % n;
    }
    
    int count = 0;
    for (int i = k; i < n; i++)
    {
        arrT[count] = arr[i];
        count++;
    }
    for (int i = 0; i < k; i++)
    {
        arrT[count] = arr[i];
        count++;
    }
    
    arr = arrT;
}

int main(){
    int arr[n];
    cout << "Enter the number of elements in the array: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int k = 0;
    cout << "Enter the number of positions to move to the left: ";
    cin >> k;
    moveToLeft(arr, k);

    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    
}