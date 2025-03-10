#include <iostream>
using namespace std;
int main()
{
	int arr[20][20] = { 0 };
	int con = 0;
	int n = 0;
	cout << "Please input number from 2 to 20" << endl;
	do
	{
		cin >> n;
	} while (n<2 || n>20);
	con = n;

	
	
	for (int i = n-1; i >n/2; i--)
	{
		for (int j = 0; j < n; j++)
		{
			arr[i][j] = n;
		}
		for (int j = 0; j < n; j++)
		{
			arr[j][i] = n;
		}
		n--;
	}

	n = con;
	
	for (int i = 0; i < n; i++)
	{
		for (int j = n - 1; j >= i; j--)
		{
			arr[i][j] = n;
		}
		for (int j = i; j < n; j++)
		{
			arr[j][i] = n;
		}
		n--;
	}

	for (int i = 0; i < con; i++)
	{
		for (int j = 0; j < con; j++)
		{
			cout << arr[i][j] << " ";
		}
		cout << endl;
	}
}


