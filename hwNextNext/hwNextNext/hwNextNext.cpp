#include <iostream>

using namespace std;

void push(int n);
void maxNumberInQueue();
int pop(int& n);

struct elem {
	int key; elem* next;
} *first = NULL, * last = NULL, * p;

int main()
{
	int num = 1;
	cout << "\n Input integers \(0 for end)" << endl;
	do {
		cin >> num;
		if (num != 0)
			push(num);
	} while (num != 0);

	maxNumberInQueue();
	cout << "\n";
	return 0;
}

void push(int n)
{
	p = last;
	last = new elem;
	last->key = n;
	last->next = NULL;
	if (p != NULL) p->next = last;
	if (first == NULL)
	{
		first = last;
	}
}

int pop(int& n)
{
	if (first)
	{
		n = first->key;
		p = first;
		first = first->next;
		if (first == NULL)	last = first;
		delete p;
		return 1;
	}
	else
		return 0;
}

void maxNumberInQueue()
{
	int n;
	elem* p = first;
	if (p == NULL)
	{
		cout << "Queue is empty" << endl;
		return;
	}
	n = p->key;
	while (p != NULL)
	{
		if (p->key > n) n = p->key;
		p = p->next;
	}
	cout << "Max number in queue is: " << n << endl;
}