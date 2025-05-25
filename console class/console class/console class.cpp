#include <iostream>

using namespace std;

struct elem {
    int key;
    elem* next;
} *top1 = nullptr, * top2 = nullptr, * first = nullptr, * last = nullptr;

void enqueue(int value) {
    elem* newElem = new elem{ value, nullptr };
    if (last == nullptr) {
        first = last = newElem;
    }
    else {
        last->next = newElem;
        last = newElem;
    }
}

int dequeue() {
    if (first == nullptr) {
        throw runtime_error("Queue is empty");
    }
    int value = first->key;
    elem* temp = first;
    first = first->next;
    if (first == nullptr) {
        last = nullptr;
    }
    delete temp;
    return value;
}

void push(elem*& top, int value) {
    elem* newElem = new elem{ value, top };
    top = newElem;
}

void displayStack(elem* top) {
    while (top != nullptr) {
        cout << top->key << " ";
        top = top->next;
    }
    cout << endl;
}

int main() {
    int num;

    cout << "Enter whole numbers (0 to stop):" << endl;
    while (true) {
        cin >> num;
        if (num == 0) break;
        enqueue(num);
    }

    while (first != nullptr) {
        int value = dequeue();
        if (value > 0) {
            push(top1, value);
        }
        else if (value < 0) {
            push(top2, value);
        }
    }

    cout << "Positive stack (top1): ";
    displayStack(top1);

    cout << "Negative stack (top2): ";
    displayStack(top2);

    return 0;
}
