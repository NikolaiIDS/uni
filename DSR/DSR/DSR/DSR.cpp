#include <iostream>
using namespace std;

#define MAX_STRING_LENGTH 50

enum RequestStatus {
	PENDING,
	REJECTED,
	COMPLETED
};

struct Request {
	int requestNumber;
	char date[MAX_STRING_LENGTH];
	char clientName[MAX_STRING_LENGTH];
	char deviceType[MAX_STRING_LENGTH];
	char serialNumber[MAX_STRING_LENGTH];
	char issueDescription[MAX_STRING_LENGTH];
	char technicianName[MAX_STRING_LENGTH];
	char repairDetails[MAX_STRING_LENGTH];
	float repairCost;
	RequestStatus status;
};

void PrintMenu()
{
	cout << "----------------------------------" << endl;
	cout << "1: New request." << endl;
	cout << "2: Display all devices." << endl;
	cout << "3: Search for device." << endl;
	cout << "4: Sort and display requests." << endl;
	cout << "5: External files." << endl;
	cout << "6: Update request." << endl;
	cout << "7: Additional request information." << endl;
	cout << "8: Exit." << endl;
	cout << "----------------------------------" << endl;
}

int InputCommand(int& c)
{
	cout << "Please input command from 1 to 8." << endl;
	cin >> c;
	return c;
}

Request InputRequest()
{
	Request req;

	cout << "Enter Request Number: ";
	cin >> req.requestNumber;
	cin.ignore(); 

	cout << "Enter Date (DD-MM-YYYY): ";
	cin.getline(req.date, MAX_STRING_LENGTH);

	cout << "Enter Client Name: ";
	cin.getline(req.clientName, MAX_STRING_LENGTH);

	cout << "Enter Device Type (e.g., Laptop, Phone): ";
	cin.getline(req.deviceType, MAX_STRING_LENGTH);

	cout << "Enter Serial Number: ";
	cin.getline(req.serialNumber, MAX_STRING_LENGTH);

	cout << "Enter Issue Description: ";
	cin.getline(req.issueDescription, MAX_STRING_LENGTH);

	cout << "Enter Technician Name: ";
	cin.getline(req.technicianName, MAX_STRING_LENGTH);

	cout << "Enter Repair Details: ";
	cin.getline(req.repairDetails, MAX_STRING_LENGTH);

	cout << "Enter Repair Cost: ";
	cin >> req.repairCost;
	cin.ignore(); 

	cout << "Enter Status (0 for PENDING, 1 for REJECTED, 2 for COMPLETED): ";
	int statusInput;
	cin >> statusInput;
	cin.ignore(); 
	req.status = static_cast<RequestStatus>(statusInput);

	cout << "\nRequest data successfully entered!" << endl;
}

int main()
{
	PrintMenu();
	Request reqArray[100];
	int inputedRequests = 0;
	int command;
	do
	{
		command = InputCommand(command);

		if (command < 1 || command > 8)
		{
			cout << "Wrong command!" << endl;
		}
		else
		{
			switch (command)
			{
				case 1: reqArray[inputedRequests] = InputRequest(); break;
				case 2: break;
				case 3: break;
				case 4: break;
				case 5: break;
				case 6: break;
				case 7: break;
			}
		}
	} while (command != 8);
}