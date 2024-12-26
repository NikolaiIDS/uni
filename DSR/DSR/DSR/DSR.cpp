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
	char date[MAX_STRING_LENGTH]{ '0' };
	char clientName[MAX_STRING_LENGTH]{ '0' };
	char deviceType[MAX_STRING_LENGTH]{ '0' };
	char serialNumber[MAX_STRING_LENGTH]{ '0' };
	char issueDescription[MAX_STRING_LENGTH]{ '0' };
	char technicianName[MAX_STRING_LENGTH]{ "PENDING" };
	char repairDetails[MAX_STRING_LENGTH]{ "PENDING" };
	float repairCost  = 0;
	RequestStatus status;
};



void DisplayDevices(Request reqArray[], int const requestsToFind)
{
	for (int i = 0; i < requestsToFind; i++)
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
		if (reqArray[i].status == 0)
		{
			cout << "PENDING" << endl;
		}
		else if (reqArray[i].status == 1)
		{
			cout << "REJECTED" << endl;
		}
		else if (reqArray[i].status == 2)
		{
			cout << "COMPLETED" << endl;
		}
		cout << "----------------------------------" << endl;
	}
}

void CompleteRequest(Request reqArray[], int const inputtedRequests)
{
	int requestNumber;
	cout << "Enter the request number you want to complete: ";
	cin >> requestNumber;
	for (int i = 0; i < inputtedRequests; i++)
	{
		if (reqArray[i].requestNumber == requestNumber)
		{

			cout << "Enter Technician Name: ";
			cin.getline(reqArray[i].technicianName, MAX_STRING_LENGTH);

			cout << "Enter Repair Details: ";
			cin.getline(reqArray[i].repairDetails, MAX_STRING_LENGTH);

			cout << "Enter Repair Cost: ";
			cin >> reqArray[i].repairCost;
		}
	}
	cout << "Request number " << requestNumber << " not found." << endl;
}

void SearchForRequest(Request reqArray[], int const inputtedRequests)
{
	cout << "Search for request by device type(0) or request status(1)." << endl;
	cin.ignore();

	int searchType;
	bool fine = false;
	const int maxRequests = 100;
	int foundCount = 0;
	Request foundRequests[maxRequests];

	do
	{
		cin >> searchType;
		if (searchType < 0 || searchType>1)
		{
			cout << "Wrong input! Try Again: (0 for device type, 1 for request status): ";
			cin.ignore();
		}
		else fine = true;
	} while (fine == false);

	if (searchType == 0)
	{
		char searchString[MAX_STRING_LENGTH];
		cout << "Enter the device type or substring to search for: ";
		cin.ignore();
		cin.getline(searchString, MAX_STRING_LENGTH);

		for (int i = 0; i < inputtedRequests; i++)
		{
			if (strstr(reqArray[i].deviceType, searchString) != nullptr)
			{
				foundRequests[foundCount++] = reqArray[i];
			}
		}

		if (foundCount > 0)
		{
			DisplayDevices(foundRequests, foundCount);
		}
		else
		{
			cout << "No devices found matching the search criteria." << endl;
		}
	}
	else if (searchType == 1)
	{
		int searchStatus;
		cout << "Enter the request status to search for (0 for PENDING, 1 for REJECTED, 2 for COMPLETED): ";
		cin.ignore();
		cin >> searchStatus;

		for (int i = 0; i < inputtedRequests; i++)
		{
			if (reqArray[i].status == searchStatus)
			{
				foundRequests[foundCount++] = reqArray[i];
			}
		}
		if (foundCount > 0)
		{
			DisplayDevices(foundRequests, foundCount);
		}
		else
		{
			cout << "No devices found matching the search criteria." << endl;
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
		reqArray[i].requestNumber = inputtedRequests + 1;
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


		cout << "Technician Name is pending. " << endl;
		cout << "Repair Details are pending. "<< endl;
		cout << "Repair Cost is pending. "<<endl;

		/*
		int statusInput;

		bool fine = false;
		do
		{
			cout << "Enter Status (0 for PENDING, 1 for REJECTED, 2 for COMPLETED): ";
			cin.ignore();

			cin >> statusInput;
			if (statusInput > 2 || statusInput < 0)
			{
				cout << "Wrong input! Try Again: (0 for PENDING, 1 for REJECTED, 2 for COMPLETED): ";
			}
			else
			{
				fine = true;
			}
		} while (fine == false);
		cin.ignore();

		reqArray[i].status = static_cast<RequestStatus>(statusInput);*/
		reqArray[i].status = static_cast<RequestStatus>(0);
		cout << "\nRequest data successfully entered!" << endl;
		inputtedRequests = inputtedRequests++;
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
			case 2: DisplayDevices(reqArray, inputtedRequests); break;
			case 3: SearchForRequest(reqArray, inputtedRequests); break;
			case 4: break;
			case 5: break;
			case 6: CompleteRequest(reqArray, inputtedRequests); break;
			case 7: break;
			}
		}
	} while (command != 8);
}