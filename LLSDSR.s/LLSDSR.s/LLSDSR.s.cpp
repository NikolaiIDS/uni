#include <iostream>
#include <fstream>
#include <cstring>
#include <stdio.h>
#include <iomanip>
#include <stdlib.h>
using namespace std;

#define MAX_STRING_LENGTH 50

enum RequestType {
	NORMAL,
	FAST,
	EXPRESS
};

enum RequestStatus {
	PENDING,
	REJECTED,
	COMPLETED
};

struct Request {
	int requestNumber = 0;
	char date[MAX_STRING_LENGTH]{ '0' };
	char clientName[MAX_STRING_LENGTH]{ '0' };
	char deviceType[MAX_STRING_LENGTH]{ '0' };
	char serialNumber[MAX_STRING_LENGTH]{ '0' };
	char issueDescription[MAX_STRING_LENGTH]{ '0' };
	char technicianName[MAX_STRING_LENGTH]{ "PENDING" };
	char repairDetails[MAX_STRING_LENGTH]{ "PENDING" };
	float repairCost = 0;

	RequestStatus status;
	RequestType type;
};

struct Node {
	Request data;
	Node* next;
};

const char deviceTypes[10][MAX_STRING_LENGTH] = {
	"Laptop", "Phone", "Tablet", "Desktop", "Smartwatch",
	"Printer", "Router", "Camera", "Monitor", "Keyboard"
};

const char issueDescriptions[10][MAX_STRING_LENGTH] = {
	"Screen not working", "Battery issue", "Overheating", "Software crash", "Hardware failure",
	"Network issue", "Slow performance", "No power", "Sound issue", "Keyboard malfunction"
};

// Linked List Operations

Node* GetLast(Node* head) {
	if (!head) return nullptr;
	while (head->next) {
		head = head->next;
	}
	return head;
}

Node* GetMiddle(Node* start, Node* end) {
	Node* slow = start;
	Node* fast = start;

	while (fast != end && fast->next != end) {
		fast = fast->next->next;
		slow = slow->next;
	}

	return slow;
}

Request* GetFirst10Requests(Node* head) {
	static Request arr[10]; 
	int count = 0;
	Node* curr = head;
	while (curr && count < 10) {
		arr[count++] = curr->data;
		curr = curr->next;
	}
	return arr;
}

void AddRequest(Node*& head, const Request& req) {
	Node* new_node = new Node{ req, nullptr };
	if (!head) {
		head = new_node;
	}
	else {
		Node* last = head;
		while (last->next) last = last->next;
		last->next = new_node;
	}
	cout << "Request added successfully!\n";
}

bool DeleteRequest(Node*& head, int requestNumber) {
	Node* temp = head;
	Node* prev = nullptr;
	while (temp && temp->data.requestNumber != requestNumber) {
		prev = temp;
		temp = temp->next;
	}
	if (!temp) {
		cout << "Request number " << requestNumber << " not found.\n";
		return false;
	}
	if (!prev) head = temp->next;
	else prev->next = temp->next;
	delete temp;
	cout << "Request number " << requestNumber << " deleted successfully.\n";
	return true;
}

Node* FindRequest(Node* head, int requestNumber) {
	while (head) {
		if (head->data.requestNumber == requestNumber) {
			cout << "Request found:\n";
			cout << "Request Number: " << head->data.requestNumber << endl;
			cout << "Date: " << head->data.date << endl;
			cout << "Client Name: " << head->data.clientName << endl;
			cout << "Device Type: " << head->data.deviceType << endl;
			cout << "Serial Number: " << head->data.serialNumber << endl;
			cout << "Issue Description: " << head->data.issueDescription << endl;
			cout << "Technician Name: " << head->data.technicianName << endl;
			cout << "Repair Details: " << head->data.repairDetails << endl;
			cout << "Repair Cost: " << head->data.repairCost << endl;
			cout << "Status: " << (head->data.status == PENDING ? "PENDING" : (head->data.status == REJECTED ? "REJECTED" : "COMPLETED")) << endl;
			cout << "Type: " << (head->data.type == NORMAL ? "NORMAL" : (head->data.type == FAST ? "FAST" : "EXPRESS")) << endl;
			return head;
		}
		head = head->next;
	}
	cout << "Request number " << requestNumber << " not found.\n";
	return nullptr;
}

void SelectionSort(Request arr[10]) {
	for (int i = 0; i < 10 - 1; ++i) {
		int minIndex = i;
		for (int j = i + 1; j < 10; ++j) {
			int day1, month1, year1, day2, month2, year2;
			sscanf_s(arr[j].date, "%d-%d-%d", &day1, &month1, &year1);
			sscanf_s(arr[minIndex].date, "%d-%d-%d", &day2, &month2, &year2);
			if ((year1 < year2) ||
				(year1 == year2 && month1 < month2) ||
				(year1 == year2 && month1 == month2 && day1 < day2)) {
				minIndex = j;
			}
		}
		swap(arr[i], arr[minIndex]);
	}
}

void MergeSort(Request arr[10]) {
	int n = 10;
	if (n < 2) return;
	int mid = n / 2;
	Request left[5];
	Request right[5];
	for (int i = 0; i < mid; ++i) {
		left[i] = arr[i];
	}
	for (int i = mid; i < n; ++i) {
		right[i - mid] = arr[i];
	}
	MergeSort(left);
	MergeSort(right);
	int i = 0, j = 0, k = 0;
	while (i < mid && j < n - mid) {
		int day1, month1, year1, day2, month2, year2;
		sscanf_s(left[i].date, "%d-%d-%d", &day1, &month1, &year1);
		sscanf_s(right[j].date, "%d-%d-%d", &day2, &month2, &year2);
		if ((year1 < year2) ||
			(year1 == year2 && month1 < month2) ||
			(year1 == year2 && month1 == month2 && day1 < day2)) {
			arr[k++] = left[i++];
		}
		else {
			arr[k++] = right[j++];
		}
	}
	while (i < mid) arr[k++] = left[i++];
	while (j < n - mid) arr[k++] = right[j++];
}

void CocktailShakerSort(Request arr[10]) {
	int n = 10;
	bool swapped = true;
	int start = 0;
	int end = n - 1;
	while (swapped) {
		swapped = false;
		for (int i = start; i < end; ++i) {
			int day1, month1, year1, day2, month2, year2;
			sscanf_s(arr[i].date, "%d-%d-%d", &day1, &month1, &year1);
			sscanf_s(arr[i + 1].date, "%d-%d-%d", &day2, &month2, &year2);
			if ((year1 > year2) ||
				(year1 == year2 && month1 > month2) ||
				(year1 == year2 && month1 == month2 && day1 > day2)) {
				swap(arr[i], arr[i + 1]);
				swapped = true;
			}
		}
		if (!swapped) break;
		swapped = false;
		end--;
		for (int i = end - 1; i >= start; --i) {
			int day1, month1, year1, day2, month2, year2;
			sscanf_s(arr[i].date, "%d-%d-%d", &day1, &month1, &year1);
			sscanf_s(arr[i + 1].date, "%d-%d-%d", &day2, &month2, &year2);
			if ((year1 > year2) ||
				(year1 == year2 && month1 > month2) ||
				(year1 == year2 && month1 == month2 && day1 > day2)) {
				swap(arr[i], arr[i + 1]);
				swapped = true;
			}
		}
		start++;
	}
}


void SortRequestsByDate(Node*& head) {
	if (!head || !head->next) return;
	bool swapped;
	do {
		swapped = false;
		Node* curr = head;
		while (curr->next) {
			int day1, month1, year1, day2, month2, year2;
			sscanf_s(curr->data.date, "%d-%d-%d", &day1, &month1, &year1);
			sscanf_s(curr->next->data.date, "%d-%d-%d", &day2, &month2, &year2);
			bool shouldSwap = (year1 > year2) ||
				(year1 == year2 && month1 > month2) ||
				(year1 == year2 && month1 == month2 && day1 > day2);
			if (shouldSwap) {
				swap(curr->data, curr->next->data);
				swapped = true;
			}
			curr = curr->next;
		}
	} while (swapped);

	cout << "Requests sorted by date.\n";
}

void SortRequestsByDeviceType(Node*& head) {
	if (!head || !head->next) return;
	bool swapped;
	do {
		swapped = false;
		Node* curr = head;
		while (curr->next) {
			if (strcmp(curr->data.deviceType, curr->next->data.deviceType) > 0) {
				swap(curr->data, curr->next->data);
				swapped = true;
			}
			curr = curr->next;
		}
	} while (swapped);
	cout << "Requests sorted by device type.\n";
}

void DisplayRequests(Node* head) {
	if (!head) {
		cout << "No requests to display.\n";
		return;
	}
	cout << left << setw(9) << "Request"
		<< setw(12) << "Date"
		<< setw(20) << "Client Name"
		<< setw(15) << "Device Type"
		<< setw(15) << "Serial No"
		<< setw(25) << "Issue Description"
		<< setw(20) << "Technician Name"
		<< setw(25) << "Repair Details"
		<< setw(4) << "Cost"
		<< setw(10) << "Status"
		<< setw(10) << "Type"
		<< endl;
	cout << string(162, '-') << endl;
	while (head) {
		const Request& req = head->data;
		cout << left << setw(9) << req.requestNumber
			<< setw(12) << req.date
			<< setw(20) << req.clientName
			<< setw(15) << req.deviceType
			<< setw(15) << req.serialNumber
			<< setw(25) << req.issueDescription
			<< setw(20) << req.technicianName
			<< setw(25) << req.repairDetails
			<< setw(4) << req.repairCost
			<< setw(10) << (req.status == PENDING ? "PENDING" : (req.status == REJECTED ? "REJECTED" : "COMPLETED"))
			<< setw(10) << (req.type == NORMAL ? "NORMAL" : (req.type == FAST ? "FAST" : "EXPRESS"))
			<< endl;
		head = head->next;
	}
}

// User Interaction Functions

void InputRequest(Node*& head, int& nextRequestNumber) {
	int n = 0;
	bool correctInput = false;
	while (!correctInput) {
		cout << "Please enter the number of requests you want to input:";
		cin >> n;
		if (cin.fail() || n <= 0 || n > 100) {
			cin.clear();
			cin.ignore();
			cout << "Invalid input. Please enter a positive number less than or equal to 100." << endl;
		}
		else {
			correctInput = true;
		}
	}

	for (int i = 0; i < n; i++) {
		cin.ignore();
		Request req;
		req.requestNumber = nextRequestNumber++;
		cout << "Request Number is: " << req.requestNumber << endl;

		cout << "Enter Date (DD-MM-YYYY): ";
		cin.getline(req.date, MAX_STRING_LENGTH);

		cout << "Enter Client Name: ";
		cin.getline(req.clientName, MAX_STRING_LENGTH);

		for (int j = 0; j < 10; j++) {
			cout << j + 1 << ": " << deviceTypes[j] << endl;
		}
		int deviceTypeIndex;
		cout << "Select Device Type: ";
		cin >> deviceTypeIndex;
		deviceTypeIndex--;
		while (deviceTypeIndex < 0 || deviceTypeIndex >= 10 || cin.fail()) {
			cout << "Invalid selection. Please select a valid device type index: ";
			cin >> deviceTypeIndex;
		}
		strcpy_s(req.deviceType, deviceTypes[deviceTypeIndex]);

		cout << "Enter Serial Number: ";
		cin.ignore();
		cin.getline(req.serialNumber, MAX_STRING_LENGTH);

		for (int j = 0; j < 10; j++) {
			cout << j + 1 << ": " << issueDescriptions[j] << endl;
		}
		int issueDescriptionIndex;
		cout << "Select Issue Description: ";
		cin >> issueDescriptionIndex;
		issueDescriptionIndex--;
		while (issueDescriptionIndex < 0 || issueDescriptionIndex >= 10 || cin.fail()) {
			cout << "Invalid selection. Please select a valid issue description index: ";
			cin >> issueDescriptionIndex;
		}
		strcpy_s(req.issueDescription, issueDescriptions[issueDescriptionIndex]);

		cout << "Technician Name is pending. " << endl;
		cout << "Repair Details are pending. " << endl;
		cout << "Repair Cost is pending. " << endl;

		int typeInput;
		bool fine = false;
		do {
			cout << "Enter Status (0 for NORMAL, 1 for FAST, 2 for EXPRESS): ";
			cin.ignore();
			cin >> typeInput;
			if (typeInput > 2 || typeInput < 0) {
				cout << "Wrong input! Try Again: (0 for NORMAL, 1 for FAST, 2 for EXPRESS): ";
			}
			else {
				fine = true;
			}
		} while (fine == false);

		req.type = static_cast<RequestType>(typeInput);
		req.status = static_cast<RequestStatus>(0);
		cout << "\nRequest data successfully entered!\n\n" << "----------------------------------" << endl;
		AddRequest(head, req);
	}
}

void CompleteRequest(Node* head) {
	int requestNumber;
	cout << "Enter the request number you want to complete: ";
	cin.ignore();
	cin >> requestNumber;
	Node* node = head;
	while (node) {
		if (node->data.requestNumber == requestNumber) {
			if (node->data.status == PENDING) {
				cout << "To COMPLETE request (0). To REJECT request (1); ";
				int input;
				do {
					cin >> input;
					if (cin.fail() || input > 2 || input < 0) {
						cout << "Wrong input please try again: To COMPLETE request (0). To REJECT request (1): ";
					}
					else break;
				} while (true);

				if (input == 1) {
					node->data.status = REJECTED;
					cout << "Request successfully REJECTED." << endl;
					return;
				}
				else {
					cin.ignore();
					cout << "Enter Technician Name: ";
					cin.getline(node->data.technicianName, MAX_STRING_LENGTH);

					cout << "Enter Repair Details: ";
					cin.getline(node->data.repairDetails, MAX_STRING_LENGTH);

					do {
						cout << "Enter Repair Cost before type calculation: ";
						cin >> node->data.repairCost;
						if (cin.fail()) {
							cout << "Try again please." << endl;
						}
						else break;
					} while (true);

					if (node->data.type == NORMAL) {
						cout << "Final price is: " << node->data.repairCost << " because request type is NORMAL" << endl;
					}
					else if (node->data.type == FAST) {
						node->data.repairCost += node->data.repairCost / 5;
						cout << "Final price is: " << node->data.repairCost << " because request type is FAST" << endl;
					}
					else {
						node->data.repairCost += node->data.repairCost / 2;
						cout << "Final price is: " << node->data.repairCost << " because request type is EXPRESS" << endl;
					}

					node->data.status = COMPLETED;
					cout << "Request successfully completed." << endl;
					return;
				}
			}
			else {
				cout << "Request has either been COMPLETED or REJECTED" << endl;
			}
			return;
		}
		node = node->next;
	}
	cout << "Request number " << requestNumber << " not found." << endl;
}

Node* BinarySearchBySerialNumber(Node* head, const char* serialNumber) {
	Node* start = head;
	Node* end = nullptr;
	while (start != end) {
		Node* mid = GetMiddle(start, end);
		if (strstr(mid->data.serialNumber, serialNumber) != nullptr) {
			return mid;
		}
		int cmp = strcmp(mid->data.serialNumber, serialNumber);
		if (cmp < 0) {
			start = mid->next;
		}
		else {
			end = mid;
		}
	}
	return nullptr;
}

void SearchForRequest(Node* head) {
	cout << "Search for request by device type(0), request status(1) or serial number (2)." << endl;
	cin.ignore();

	int searchType;
	bool fine = false;
	do {
		cin >> searchType;
		if (searchType < 0 || searchType > 1) {
			cout << "Wrong input! Try Again: (0 for device type, 1 for request status): ";
			cin.ignore();
		}
		else fine = true;
	} while (fine == false);

	if (searchType == 0) {
		char searchString[MAX_STRING_LENGTH];
		cout << "Enter the device type or substring to search for: ";
		cin.ignore();
		cin.getline(searchString, MAX_STRING_LENGTH);

		Node* node = head;
		bool found = false;
		while (node) {
			if (strstr(node->data.deviceType, searchString) != nullptr) {
				if (!found) {
					cout << "Matching requests:\n";
					cout << left << setw(9) << "Request"
						<< setw(12) << "Date"
						<< setw(20) << "Client Name"
						<< setw(15) << "Device Type"
						<< setw(15) << "Serial No"
						<< setw(25) << "Issue Description"
						<< setw(20) << "Technician Name"
						<< setw(25) << "Repair Details"
						<< setw(4) << "Cost"
						<< setw(10) << "Status"
						<< setw(10) << "Type"
						<< endl;
					cout << string(162, '-') << endl;
				}
				found = true;
				const Request& req = node->data;
				cout << left << setw(9) << req.requestNumber
					<< setw(12) << req.date
					<< setw(20) << req.clientName
					<< setw(15) << req.deviceType
					<< setw(15) << req.serialNumber
					<< setw(25) << req.issueDescription
					<< setw(20) << req.technicianName
					<< setw(25) << req.repairDetails
					<< setw(4) << req.repairCost
					<< setw(10) << (req.status == PENDING ? "PENDING" : (req.status == REJECTED ? "REJECTED" : "COMPLETED"))
					<< setw(10) << (req.type == NORMAL ? "NORMAL" : (req.type == FAST ? "FAST" : "EXPRESS"))
					<< endl;
			}
			node = node->next;
		}
		if (!found) {
			cout << "No devices found matching the search criteria." << endl;
		}
	}
	else if (searchType == 1) {
		int searchStatus;
		cout << "Enter the request status to search for (0 for PENDING, 1 for REJECTED, 2 for COMPLETED): ";
		cin.ignore();
		cin >> searchStatus;

		Node* node = head;
		bool found = false;
		while (node) {
			if (node->data.status == searchStatus) {
				if (!found) {
					cout << "Matching requests:\n";
					cout << left << setw(9) << "Request"
						<< setw(12) << "Date"
						<< setw(20) << "Client Name"
						<< setw(15) << "Device Type"
						<< setw(15) << "Serial No"
						<< setw(25) << "Issue Description"
						<< setw(20) << "Technician Name"
						<< setw(25) << "Repair Details"
						<< setw(4) << "Cost"
						<< setw(10) << "Status"
						<< setw(10) << "Type"
						<< endl;
					cout << string(162, '-') << endl;
				}
				found = true;
				const Request& req = node->data;
				cout << left << setw(9) << req.requestNumber
					<< setw(12) << req.date
					<< setw(20) << req.clientName
					<< setw(15) << req.deviceType
					<< setw(15) << req.serialNumber
					<< setw(25) << req.issueDescription
					<< setw(20) << req.technicianName
					<< setw(25) << req.repairDetails
					<< setw(4) << req.repairCost
					<< setw(10) << (req.status == PENDING ? "PENDING" : (req.status == REJECTED ? "REJECTED" : "COMPLETED"))
					<< setw(10) << (req.type == NORMAL ? "NORMAL" : (req.type == FAST ? "FAST" : "EXPRESS"))
					<< endl;
			}
			node = node->next;
		}
		if (!found) {
			cout << "No devices found matching the search criteria." << endl;
		}
	}
	else if (searchType == 2) {
		char searchString[MAX_STRING_LENGTH];
		cout << "Enter the serial number or substring to search for: ";
		cin.ignore();
		cin.getline(searchString, MAX_STRING_LENGTH);

		SortRequestsByDeviceType(head);

		Node* found = BinarySearchBySerialNumber(head, searchString);


		if (found) {
			cout << "Matching requests:\n";
			cout << left << setw(9) << "Request"
				<< setw(12) << "Date"
				<< setw(20) << "Client Name"
				<< setw(15) << "Device Type"
				<< setw(15) << "Serial No"
				<< setw(25) << "Issue Description"
				<< setw(20) << "Technician Name"
				<< setw(25) << "Repair Details"
				<< setw(4) << "Cost"
				<< setw(10) << "Status"
				<< setw(10) << "Type"
				<< endl;
			cout << string(162, '-') << endl;
			const Request& req = found->data;
			cout << left << setw(9) << req.requestNumber
				<< setw(12) << req.date
				<< setw(20) << req.clientName
				<< setw(15) << req.deviceType
				<< setw(15) << req.serialNumber
				<< setw(25) << req.issueDescription
				<< setw(20) << req.technicianName
				<< setw(25) << req.repairDetails
				<< setw(4) << req.repairCost
				<< setw(10) << (req.status == PENDING ? "PENDING" : (req.status == REJECTED ? "REJECTED" : "COMPLETED"))
				<< setw(10) << (req.type == NORMAL ? "NORMAL" : (req.type == FAST ? "FAST" : "EXPRESS"))
				<< endl;
		}
		else {
			cout << "No device found matching the search criteria." << endl;
		}
	}
}

void AdditionalRequestInformation(Node* head) {
	cout << "To displaying completed requests for certain technician (0). \n To display all requests with a certain issue for a certain device (1)\n: ";
	cin.ignore();
	int command;
	do {
		cin >> command;
		if (command > 1 || command < 0 || cin.fail()) {
			cout << "Wrong Command. Please try again. To displaying completed requests for certain technician (0). \n To display all requests with a certain issue for a certain device (1)\n: ";
		}
		else break;
	} while (true);

	if (command == 1) {
		char searchDevice[MAX_STRING_LENGTH];
		cout << "Enter a device type substring to search for: ";
		cin.ignore();
		cin.getline(searchDevice, MAX_STRING_LENGTH);
		char searchIssue[MAX_STRING_LENGTH];
		cout << "Enter an issue description substring to search for: ";
		cin.ignore();
		cin.getline(searchIssue, MAX_STRING_LENGTH);

		Node* node = head;
		Node* filteredHead = nullptr;
		int count = 0;
		while (node) {
			if (strstr(node->data.deviceType, searchDevice) != nullptr &&
				strstr(node->data.issueDescription, searchIssue) != nullptr) {
				AddRequest(filteredHead, node->data);
				count++;
			}
			node = node->next;
		}
		SortRequestsByDeviceType(filteredHead);
		DisplayRequests(filteredHead);
		Request* first10 = GetFirst10Requests(head);
		SelectionSort(first10);
		for (int i = 0; i < 10; ++i) {
			cout << "Request #" << first10[i].requestNumber << " - " << first10[i].date << endl;
		};

		
		while (filteredHead) {
			Node* tmp = filteredHead;
			filteredHead = filteredHead->next;
			delete tmp;
		}
	}
	else if (command == 0) {
		Node* node = head;
		Node* completedHead = nullptr;
		while (node) {
			if (node->data.status == COMPLETED) {
				AddRequest(completedHead, node->data);
			}
			node = node->next;
		}

		cout << "Technician Names for Completed Requests:" << endl;
		node = completedHead;
		while (node) {
			cout << node->data.technicianName << endl;
			node = node->next;
		}

		char searchTechnician[MAX_STRING_LENGTH];
		cout << "Enter a technician name substring to search for: ";
		cin.ignore();
		cin.getline(searchTechnician, MAX_STRING_LENGTH);

		Node* filteredHead = nullptr;
		node = completedHead;
		while (node) {
			if (strstr(node->data.technicianName, searchTechnician) != nullptr) {
				AddRequest(filteredHead, node->data);
			}
			node = node->next;
		}
		SortRequestsByDate(filteredHead);
		DisplayRequests(filteredHead);
		Request* first10 = GetFirst10Requests(head);
		MergeSort(first10);
		for (int i = 0; i < 10; ++i) {
			cout << "Request #" << first10[i].requestNumber << " - " << first10[i].date << endl;
		};

		// Free filtered/completed lists
		while (completedHead) {
			Node* tmp = completedHead;
			completedHead = completedHead->next;
			delete tmp;
		}
		while (filteredHead) {
			Node* tmp = filteredHead;
			filteredHead = filteredHead->next;
			delete tmp;
		}
	}
}

// File I/O for Linked List

void ImportBinaryFile(Node*& head, int& nextRequestNumber, const char* filename) {
	ifstream input_file(filename, ios::binary | ios::ate);
	if (!input_file.is_open()) {
		cerr << "Error opening file for reading." << endl;
		return;
	}
	streamsize file_size = input_file.tellg();
	input_file.seekg(0, ios::beg);

	int requestCount = file_size / sizeof(Request);

	if (requestCount == 0) {
		cerr << "No data in file or file size mismatch." << endl;
		input_file.close();
		return;
	}

	for (int i = 0; i < requestCount; ++i) {
		Request req;
		input_file.read(reinterpret_cast<char*>(&req), sizeof(Request));
		AddRequest(head, req);
		if (req.requestNumber >= nextRequestNumber)
			nextRequestNumber = req.requestNumber + 1;
	}

	input_file.close();
	cout << "Data successfully imported from file." << endl;
}

void ExportBinaryFile(Node* head, const char* filename) {
	ofstream output_file(filename, ios::binary);
	if (output_file.is_open()) {
		Node* node = head;
		while (node) {
			output_file.write((char*)&node->data, sizeof(node->data));
			node = node->next;
		}
		output_file.close();
		cout << "Data successfully exported to file." << endl;
	}
	else {
		cerr << "Error opening file for writing." << endl;
	}
}

void PrintMenu() {
	cout << "----------------------------------" << endl;
	cout << "1: New request." << endl;
	cout << "2: Display all devices." << endl;
	cout << "3: Search for device." << endl;
	cout << "4: Sort and display requests." << endl;
	cout << "5: External files." << endl;
	cout << "6: Complete request." << endl;
	cout << "7: Additional request information." << endl;
	cout << "8: Clear console." << endl;
	cout << "9: Exit." << endl;
	cout << "----------------------------------" << endl;
}

int InputCommand(int& c) {
	cout << "Please input command from 1 to 9." << endl;
	cin >> c;
	return c;
}

void ImportAndExportBinaryFile(Node*& head, int& nextRequestNumber) {
	cin.ignore();
	cout << "Do you want to import data from file (0) or export data to file (1)?" << endl;
	bool fine = false;
	int command;
	do {
		cin >> command;
		if (command < 0 || command > 1) {
			cout << "Wrong input! Try Again: (0 for import, 1 for export): ";
		}
		else fine = true;
	} while (fine == false);
	if (command == 1) {
		ExportBinaryFile(head, "requests.dat");
	}
	else {
		ImportBinaryFile(head, nextRequestNumber, "requests.dat");
	}
}

int main() {
	PrintMenu();
	Node* head = nullptr;
	int nextRequestNumber = 1;
	ImportBinaryFile(head, nextRequestNumber, "requestsPermanent.dat");
	int command;
	do {
		command = InputCommand(command);

		if (command < 1 || command > 9 || cin.fail()) {
			cout << "Wrong command!" << endl;
		}
		else {
			switch (command) {
			case 1: InputRequest(head, nextRequestNumber); break;
			case 2: DisplayRequests(head); break;
			case 3: SearchForRequest(head); break;
			case 4: 
				SortRequestsByDate(head); 
				DisplayRequests(head); 
				Request* first10 = GetFirst10Requests(head);
				CocktailShakerSort(first10);
				for (int i = 0; i < 10; ++i) {
					cout << "Request #" << first10[i].requestNumber << " - " << first10[i].date << endl;
				} break;

			case 5: ImportAndExportBinaryFile(head, nextRequestNumber); break;
			case 6: CompleteRequest(head); break;
			case 7: AdditionalRequestInformation(head); break;
			case 8: system("cls"); PrintMenu(); break;
			}
		}
	} while (command != 9);
	ExportBinaryFile(head, "requestsPermanent.dat");

	// Free memory
	while (head) {
		Node* tmp = head;
		head = head->next;
		delete tmp;
	}
}