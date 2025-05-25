#include <iostream>

using namespace std;

struct elem {
	int key;
	elem* next;
}
*start = NULL, * p = NULL, * start2 = NULL, * p2 = NULL;

void display(elem* start) {
	if (start) {
		cout << "Elements in the stack:\n";
		elem* temp = start;
		while (temp != NULL) {
			cout << temp->key << endl;
			//cout << temp->next->key;
			temp = temp->next;
		}
	}
	else {
		cout << "Stack is empty.\n";
	}
}

void push(int n, elem*& start, elem*& p)
{
	p = start;
	start = new elem;
	start->key = n;
	start->next = p;
}

int pop(int& n, elem*& start, elem*& p)
{
	if (start)
	{
		n = start->key;
		p = start;
		start = start->next;
		delete p;
		return 1;
	}
	else
		return 0;
}

int getSize(elem* start) {
	int size = 0;
	elem* temp = start;
	while (temp != NULL) {
		size++;
		temp = temp->next;
	}
	return size;
}

void copyStack()
{
	int size = getSize(start);
	if (size > 10) {
		cout << "Error: Stack size exceeds maximum allowed size.\n";
		return;
	}

	int arr[10] = {};
	
	int temp = 0;

	for (int i = 0; i < size; i++)
	{
		pop(temp, start, p);
		arr[i] = temp;
	}

	for (int i = size-1; i >= 0; i--)
	{
		push(arr[i], start2, p2);
		push(arr[i], start, p);

	}
}


int main()
{
	int num;
	cout << "Input integers (to end enter 0):\n";
	bool a = true;
	while (a)
	{
		cin >> num;
		if (num == 0)
			break;
		push(num, start, p);
	}
	cout << "\nStack:  ";
	display(start);
	copyStack();
	cout << "\nStack2:  ";
	display(start2);
	cout << "\nStack:  ";
	display(start);

	return 0;
}
