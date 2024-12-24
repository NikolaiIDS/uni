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



void DisplayAllDevices(Request reqArray[], int const inputtedRequests)
{
	for (int i = 0; i < inputtedRequests; i++)
	{
		cout << "Request Number: " << reqArray[i].requestNumber << endl;
		cout << "Date: " << reqArray[i].date << endl;
		cout << "Client Name: " << reqArray[i].clientName << endl;
		cout << "Device Type: " << reqArray[i].deviceType << endl;
		cout << "Serial Number: " << reqArray[i].serialNumber << endl;
		cout << "Issue Description: " << reqArray[i].issueDescription << endl;
		cout << "Technician Name: " << reqArray[i].technicianName << endl;
		cout << "Repair Details: " << reqArray[i].repairDetails << endl;
		cout << "Repair Cost: " << reqArray[i].repairCost << endl;
		cout << "Status: ";
		if (reqArray[i].status == 1)
		{
			cout << "PENDING" << endl;
		}
		else if (reqArray[i].status == 2)
		{
			cout << "REJECTED" << endl;
		}
		else if (reqArray[i].status == 3)
		{
			cout << "COMPLETED" << endl;
		}
	}
}

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

void InputRequest(int& inputtedRequests, Request reqArray[])
{
	int n = 0;

	bool correctInput = false;
	while (!correctInput)
	{
		cout << "Please enter the number of requests you want to input:";
		cin >> n;
		if (cin.fail() || n <= 0 || n > 100)
		{
			cin.clear();
			cin.ignore();
			cout << "Invalid input. Please enter a positive number less than or equal to 100." << endl;
		}
		else
		{
			correctInput = true;
		}
	}

	for (int i = 0; i < n; i++)
	{
		reqArray[i].requestNumber = inputtedRequests+1;
		cout << "Request Number is: " << reqArray[i].requestNumber << endl;

		cout << "Enter Date (DD-MM-YYYY): ";
		cin.ignore();
		cin.getline(reqArray[i].date, MAX_STRING_LENGTH);

		cout << "Enter Client Name: ";
		cin.getline(reqArray[i].clientName, MAX_STRING_LENGTH);

		cout << "Enter Device Type (e.g., Laptop, Phone): ";
		cin.getline(reqArray[i].deviceType, MAX_STRING_LENGTH);

		cout << "Enter Serial Number: ";
		cin.getline(reqArray[i].serialNumber, MAX_STRING_LENGTH);

		cout << "Enter Issue Description: ";
		cin.getline(reqArray[i].issueDescription, MAX_STRING_LENGTH);

		cout << "Enter Technician Name: ";		
		cin.getline(reqArray[i].technicianName, MAX_STRING_LENGTH);

		cout << "Enter Repair Details: ";
		cin.getline(reqArray[i].repairDetails, MAX_STRING_LENGTH);

		cout << "Enter Repair Cost: ";
		cin.ignore();
		cin >> reqArray[i].repairCost;

		cout << "Enter Status (0 for PENDING, 1 for REJECTED, 2 for COMPLETED): ";
		int statusInput;
		cin.ignore();
		cin >> statusInput;
		cin.ignore();
		reqArray[i].status = static_cast<RequestStatus>(statusInput);

		cout << "\nRequest data successfully entered!" << endl;
		inputtedRequests++;
	}
}

int main()
{
	PrintMenu();
	const int MAX_REQUESTS = 100;
	Request reqArray[MAX_REQUESTS];
	int inputtedRequests = 0;
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
			case 1: InputRequest(inputtedRequests, reqArray); break;
			case 2: DisplayAllDevices(reqArray, inputtedRequests); break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 6: break;
			case 7: break;
			}
		}
	} while (command != 8);
}