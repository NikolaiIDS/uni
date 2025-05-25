#include <iostream>
using namespace std;

int stack[100], n = 100, top = -1;

struct elem {
    int key;
    elem* next;
} *start = NULL, * p = NULL;

void pushStack(int n) {
    p = start;
    start = new elem;
    start->key = n;
    start->next = p;
}

bool popStack(int& n) {
    if (start) {
        n = start->key;
        p = start;
        start = start->next;
        delete p;
        return true;
    }
    else {
        return false;
    }
}

void displayStack() {
    if (start) {
        cout << "Stack elements are:";
        elem* temp = start;
        while (temp) {
            cout << temp->key << " ";
            temp = temp->next;
        }
        cout << endl;
    }
    else
        cout << "Stack is empty" << endl;
}

void push(int val) {
    if (top >= n - 1)
        cout << "Stack Overflow" << endl;
    else {
        top++;
        stack[top] = val;
    }
}

void pop() {
    if (top <= -1)
        cout << "Stack Underflow" << endl;
    else {
        cout << "The popped element is " << stack[top] << endl;
        top--;
    }
}

void display() {
    if (top >= 0) {
        cout << "Stack elements are:";
        for (int i = top; i >= 0; i--)
            cout << stack[i] << " ";
        cout << endl;
    }
    else
        cout << "Stack is empty" << endl;
}

void printMenuArr() {
    int ch, val;
    cout << "1) Push in stack" << endl;
    cout << "2) Pop from stack" << endl;
    cout << "3) Display stack" << endl;
    cout << "4) Exit" << endl;
    do {
        cout << "Enter choice: " << endl;
        cin >> ch;
        switch (ch) {
        case 1: {
            cout << "Enter value to be pushed:" << endl;
            cin >> val;
            push(val);
            break;
        }
        case 2: {
            pop();
            break;
        }
        case 3: {
            display();
            break;
        }
        case 4: {
            cout << "Exit" << endl;
            break;
        }
        default: {
            cout << "Invalid Choice" << endl;
        }
        }
    } while (ch != 4);
}
void printMenuSta() {
    int ch, val;
    cout << "1) Push in stack" << endl;
    cout << "2) Pop from stack" << endl;
    cout << "3) Display stack" << endl;
    cout << "4) Exit" << endl;
    do {
        cout << "Enter choice: " << endl;
        cin >> ch;
        switch (ch) {
        case 1: {
            cout << "Enter value to be pushed:" << endl;
            cin >> val;
            pushStack(val);
            break;
        }
        case 2: {
            popStack(val);
            break;
        }
        case 3: {
            displayStack();
            break;
        }
        case 4: {
            cout << "Exit" << endl;
            break;
        }
        default: {
            cout << "Invalid Choice" << endl;
        }
        }
    } while (ch != 4);
}
int main() {
    cout << "please enter 1 for array based stack or 2 for linked list based stack" << endl;
    int choice;
	cin >> choice;
    if (choice == 1) {
        printMenuArr();
    }
    else if (choice == 2) {
        printMenuSta();
    }
    else {
        cout << "Invalid choice" << endl;
    }
    return 0;
}