#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;

#define MAX_LENGTH 100
#define MAX_STRING_LENGTH 50


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

void InputRequest(Request reqArray[], int& inputtedRequests)
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

		reqArray[i + inputtedRequests].requestNumber = inputtedRequests + 1;
		cout << "Request Number is: " << reqArray[i + inputtedRequests].requestNumber << endl;

		cout << "Enter Date (DD-MM-YYYY): ";
		cin.ignore();
		cin.getline(reqArray[i + inputtedRequests].date, MAX_STRING_LENGTH);

		cout << "Enter Client Name: ";
		cin.getline(reqArray[i + inputtedRequests].clientName, MAX_STRING_LENGTH);

		cout << "Enter Device Type (e.g., Laptop, Phone): ";
		cin.getline(reqArray[i + inputtedRequests].deviceType, MAX_STRING_LENGTH);

		cout << "Enter Serial Number: ";
		cin.getline(reqArray[i + inputtedRequests].serialNumber, MAX_STRING_LENGTH);

		cout << "Enter Issue Description: ";
		cin.getline(reqArray[i + inputtedRequests].issueDescription, MAX_STRING_LENGTH);


		cout << "Technician Name is pending. " << endl;
		cout << "Repair Details are pending. " << endl;
		cout << "Repair Cost is pending. " << endl;

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
		reqArray[i + inputtedRequests].status = static_cast<RequestStatus>(0);
		cout << "\nRequest data successfully entered!" << endl;
		inputtedRequests += 1;
	}
}

void SortByDate(Request reqArray[], int const inputtedRequests)
{
	//TODO
}

void ImportAndExportBinaryFileAutomatically(Request reqArray[], int& inputtedRequests, bool end)
{
	if (end == false)
	{
		ifstream input_file("requests.dat", ios::binary | ios::ate);
		if (!input_file.is_open()) {
			cerr << "Error opening file for reading." << endl;
			return;
		}
		streamsize file_size = input_file.tellg();
		input_file.seekg(0, ios::beg);

		int requestCount = file_size / sizeof(Request);

		if (requestCount == 0/*&& file_size % sizeof(Request) == 0*/) {
			cerr << "No data in file or file size mismatch." << endl;
			input_file.close();
			return;
		}

		input_file.read(reinterpret_cast<char*>(reqArray), file_size);
		if (!input_file) {
			cerr << "Error reading data from file." << endl;
			input_file.close();
			return;
		}

		input_file.close();
		cout << "Data successfully imported from file." << endl;
		inputtedRequests += requestCount;

	}
	else
	{
		ofstream output_file("requests.dat", ios::binary);
		if (output_file.is_open())
		{
			for (int i = 0; i < inputtedRequests; i++)
			{
				output_file.write((char*)&reqArray[i], sizeof(reqArray[i]));
			}
			output_file.close();
			cout << "Data successfully exported to file." << endl;
		}
		else
		{
			cerr << "Error opening file for writing." << endl;
		}
	}
}

void ImportAndExportBinaryFile(Request reqArray[], int& inputtedRequests)
{
	cin.ignore();
	cout << "Do you want to import data from file (0) or export data to file (1)?" << endl;
	bool fine = false;
	int command;
	do
	{
		cin >> command;
		if (command < 0 || command > 1)
		{
			cout << "Wrong input! Try Again: (0 for import, 1 for export): ";
		}
		else fine = true;
	} while (fine == false);
	if (command == 1)
	{
		ofstream output_file("requests.dat", ios::binary);
		if (output_file.is_open())
		{
			for (int i = 0; i < inputtedRequests; i++)
			{
				output_file.write((char*)&reqArray[i], sizeof(reqArray[i]));
			}
			output_file.close();
			cout << "Data successfully exported to file." << endl;
		}
		else
		{
			cerr << "Error opening file for writing." << endl;
		}
	}
	else
	{
		ifstream input_file("requests.dat", ios::binary | ios::ate);
		if (!input_file.is_open()) {
			cerr << "Error opening file for reading." << endl;
			return;
		}
		streamsize file_size = input_file.tellg();
		input_file.seekg(0, ios::beg);

		int requestCount = file_size / sizeof(Request);

		if (requestCount == 0/*&& file_size % sizeof(Request) == 0*/) {
			cerr << "No data in file or file size mismatch." << endl;
			input_file.close();
			return;
		}

		input_file.read(reinterpret_cast<char*>(reqArray), file_size);
		if (!input_file) {
			cerr << "Error reading data from file." << endl;
			input_file.close();
			return;
		}

		input_file.close();
		cout << "Data successfully imported from file." << endl;
		inputtedRequests += requestCount;
	}
}

int main()
{
	PrintMenu();
	const int MAX_REQUESTS = 100;
	Request reqArray[MAX_REQUESTS];
	int inputtedRequests = 0;
	ImportAndExportBinaryFileAutomatically(reqArray, inputtedRequests, false);
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
			case 1: InputRequest(reqArray, inputtedRequests); break;
			case 2: DisplayDevices(reqArray, inputtedRequests); break;
			case 3: SearchForRequest(reqArray, inputtedRequests); break;
			case 4: /*sort by date*/break;
			case 5: ImportAndExportBinaryFile(reqArray, inputtedRequests); break;
			case 6: CompleteRequest(reqArray, inputtedRequests); break;
			case 7: break;
			}
		}
	} while (command != 8);
	ImportAndExportBinaryFileAutomatically(reqArray, inputtedRequests, true);
}