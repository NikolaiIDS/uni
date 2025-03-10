#include <iostream>
using namespace std;

void print(int arr[5][5])
{
	for (int i = 0; i < 5; i++)
	{
		for (int j = 0; j < 5; j++)
		{
			cout<<arr[i][j]<< " ";
		}
		cout << endl;
	}
}

int main() {
	int matrix[5][5] = { 0 };
	int b[5][5] = { 0 };
	int c[5][5] = { 0 };
	int input = 0;

	for (int i = 0; i < 5; i++)
	{
		for (int j = 0; j < 5; j++)
		{
			cin >> input;
			matrix[i][j] = input;
		}
	}

	int currMax = 0;
	int currMin = 0;
	int plCount = 0;
	int ngCount = 0;
	for (int i = 0; i < 5; i++)
	{
		for (int j = 0; j < 5; j++)
		{
			if (matrix[i][j] > 0)
			{
				b[i][j] = matrix[i][j];
				if (currMax < matrix[i][j])
				{
					plCount++;
					currMax = matrix[i][j];
				}
			}
			else
			{
				c[i][j] = matrix[i][j];
				if (currMin > matrix[i][j])
				{
					ngCount++;
					currMin = matrix[i][j];
				}
			}
		}
	}
	cout << "The matrix A:" << endl;
	print(matrix);
	cout << "The matrix B:" << endl;
	print(b);
	cout << "the biggest number in the matrix is " << currMax << " and " << plCount << " items were inserted in it" << endl;
	cout << "The matrix C:" << endl;
	print(c);
	cout << "the smallest number in the matrix is " << currMin << " and " << ngCount << " items were inserted in it" << endl;

}
