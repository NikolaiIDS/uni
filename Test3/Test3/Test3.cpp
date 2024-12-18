#include <iostream>
#include <string>
using namespace std;
struct Student {
	string name;
	float score;
};


void Input(Student arr[],const int& length)
{
	for (int i = 0; i < length; i++)
	{
		cout << "Please input student No" << i + 1 << "'s name: ";
		cin >> arr[i].name;
		cout << "Please input student No" << i + 1 << "'s score: ";
		cin >> arr[i].score;
	}
}

float Print(Student arr[],const int& length)
{
	float sum = 0;

	for (int i = 0; i < length; i++)
	{
		cout << "student No" << i + 1 << "'s name: " << arr[i].name << endl;
		cout << "student No" << i + 1 << "'s score: " << arr[i].score << endl;
		sum += arr[i].score;
	}
	return sum / length;
}

void MaxScore(Student arr[],const int& length, string& name)
{
	float max = arr[0].score;
	name = arr[0].name;

	for (int i = 0; i < length; i++)
	{
		if (max < arr[i].score)
		{
			max = arr[i].score;
			name = arr[i].name;
		}
	}
}

int main()
{
	const int length = 3;
	Student arr[length];
	Input(arr, length);

	cout << "For Print please input 1" << endl;
	cout << "For MaxScore please input 2" << endl;
	cout << "To leave: 3" << endl;

	int command; 
	string name;
	float avg;

	do
	{
		cout << "Please input command: ";
		cin >> command;
		if (command == 1)
		{
			avg = Print(arr, length);
			cout << "Average score is: " << avg << endl;
		}
		else if (command == 2)
		{
			MaxScore(arr, length, name);
			cout << "The person with the highest score is: " << name << endl;
		}
	} while (command != 3);


}

