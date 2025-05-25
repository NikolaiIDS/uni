#include <iostream>

using namespace std;

struct elem {
	int key; elem* next;
} *first = NULL, * last = NULL, * start1 = NULL, * start2 = NULL, * p = NULL, * leftt = NULL, * rightt = NULL;

void pushQueue(int n)
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

int popQueue(int& n)
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
		p = rightt;
		rightt = rightt->next;
		if (rightt == NULL)
			leftt = NULL;
		delete p;
		return 1;
	}
	else
		return 0;
}

void push(int n, elem* &start)
{
	p = start;
	start = new elem;
	start->key = n;
	start->next = p;
}

int pop(int& n, elem* &start)
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

void DisplayStack(elem* start) {
	if (start) {
		cout << "Elements in the stack:\n";
		elem* temp = start;
		while (temp != NULL) {
			cout << temp->key << endl;
			temp = temp->next;
		}
	}
	else {
		cout << "Stack is empty.\n";
	}
}

void displayDeck()
{
	if (leftt == NULL) {
		cout << "Deck is empty.\n";
		return;
	}

	elem* temp = leftt;
	cout << "Elements in the deck (from left to right):\n";
	while (temp != nullptr) {
		cout << temp->key << " ";
		
		if (temp->key%2 == 0)
		{
			push(temp->key, start1);
		}
		else {
			push(temp->key, start2);
		}
		temp = temp->next;
	}
	cout << endl;
}

int main()
{
	int num = 1;
	cout << "\n Input integers \(0 for end)" << endl;
	do {
		cin >> num;
		if (num != 0)
			pushQueue(num);
	} while (num != 0);

	while (popQueue(num))
	{
		cout << num << "  ";
		if (num > 0)
			push_r(num);
		else
			push_l(num);
	}
	displayDeck();
	DisplayStack(start1);
	DisplayStack(start2);
	cout << "\n";
}
// cw22.cpp : queue whole positive numbers. 0 za krai na enqueue. dequeue all 
// and display all elements. if positive add to right of deck if negative left of deck
//display deck, traverse deck and all even numbers to stack 1 and all odd numbers to stack 2. display stacks
