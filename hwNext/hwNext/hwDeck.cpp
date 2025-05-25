#include <iostream>

using namespace std;

void push_l(int n);
void push_r(int n);
int pop_l(int& n);
int pop_r(int& n);
bool find(int n, int& count);

struct elem
{
	int key;
	elem* next;
}
*leftt = NULL, * rightt = NULL;

int main()
{
	int count = 0;
	int ch;
	do
	{
		int num;
		cout << "\n		Menu:\n";
		cout << "1 - Input left\n";
		cout << "2 - Input right\n";
		cout << "3 - Output left\n";
		cout << "4 - Output right\n";
		cout << "5 - Find number\n";
		cout << "6 - Exit\n";
		cout << "Your choice: ";
		cin >> ch;
		switch (ch)
		{
		case (1):
		case (2):
			cout << "\nInput number: ";
			cin >> num;
			if (ch == 1)
				push_l(num);
			else
				push_r(num);
			break;
		case (3):
		{
			if (leftt == NULL)
				cout << " The Deck is empty!";
			while (pop_l(num))
				cout << num << "\t";
			break;
		}
		case (4):
		{
			if (rightt == NULL)
				cout << " The Deck is empty!";
			while (pop_r(num))
				cout << num << "\t";
			break;
		}
		case (5):
		{
			cout << "Please input number to find: " << endl;
			cin >> num;
			if (find(num,count)) {
				cout << "Number " << num << " is in the Deck at "<< count << " position." << endl;
			}
			else {
				cout << "Number " << num << " is not in the Deck" << endl;
			}
			break;
		}
		} 
	} while (ch != 6);
	return 0;
}

void push_l(int n)
{
	elem* p;
	p = leftt;
	leftt = new elem;
	leftt->key = n;
	leftt->next = p;
	if (rightt == NULL)
	{
		rightt = leftt;
	}
}

void push_r(int n)
{
	elem* p;
	p = rightt;
	rightt = new elem;
	rightt->key = n;
	rightt->next = NULL;
	if (leftt == NULL)
		leftt = rightt;
	else
		p->next = rightt;
}

int pop_l(int& n)
{
	elem* p;
	if (leftt)
	{
		n = leftt->key;
		p = leftt;
		leftt = leftt->next;
		if (leftt == NULL)
			rightt = NULL;
		delete p;
		return 1;
	}
	else
		return 0;
}

int pop_r(int& n)
{
	elem* p;
	if (rightt)
	{
		n = rightt->key;
		if (leftt == rightt)
		{
			delete rightt;
			leftt = rightt = NULL;
		}
		else
		{
			p = leftt;
			while (p->next != rightt)
				p = p->next;
			p->next = NULL;
			delete rightt;
			rightt = p;
		}
		return 1;
	}
	else
		return 0;
}

bool find(int n, int& count)
{
	elem* p;
	p = leftt;

	if (p == NULL)
		return false;

	while (p != NULL)
	{
		if (p->key == n)
			return true;
		p = p->next;
		count++;
	}
}