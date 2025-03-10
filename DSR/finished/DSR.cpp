#include <iostream>
#include <fstream>
#include <cstring>
#include <stdio.h>
#include <iomanip>
using namespace std;

#define MAX_LENGTH 100
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

const char deviceTypes[10][MAX_STRING_LENGTH] = {
	"Laptop", "Phone", "Tablet", "Desktop", "Smartwatch",
	"Printer", "Router", "Camera", "Monitor", "Keyboard"
};

const char issueDescriptions[10][MAX_STRING_LENGTH] = {
	"Screen not working", "Battery issue", "Overheating", "Software crash", "Hardware failure",
	"Network issue", "Slow performance", "No power", "Sound issue", "Keyboard malfunction"
};

void DisplayDevices(Request const reqArray[], int const requestsToFind)
{
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

	for (int i = 0; i < requestsToFind; i++)
	{
		cout << left << setw(9) << reqArray[i].requestNumber
			<< setw(12) << reqArray[i].date
			<< setw(20) << reqArray[i].clientName
			<< setw(15) << reqArray[i].deviceType
			<< setw(15) << reqArray[i].serialNumber
			<< setw(25) << reqArray[i].issueDescription
			<< setw(20) << reqArray[i].technicianName
			<< setw(25) << reqArray[i].repairDetails
			<< setw(4) << reqArray[i].repairCost
			<< setw(10) << (reqArray[i].status == PENDING ? "PENDING" : (reqArray[i].status == REJECTED ? "REJECTED" : "COMPLETED"))
			<< setw(10) << (reqArray[i].type == NORMAL ? "NORMAL" : (reqArray[i].type == FAST ? "FAST" : "EXPRESS"))
			<< endl;
	}
}

void CompleteRequest(Request reqArray[], int const inputtedRequests)
{
	int requestNumber;
		(reqArray, inputtedRequests);
	cout << "Enter the request number you want to complete: ";
	cin.ignore();
	cin >> requestNumber;
	for (int i = 0; i < inputtedRequests; i++)
	{
		if (reqArray[i].requestNumber == requestNumber)
		{
			if (reqArray[i].status == 0)
			{
				cout << "To COMPLETE request (0). To REJECT request (1); ";

				int input;
				do
				{
					cin >> input;
					if (cin.fail() || input > 2 || input < 0)
					{
						cout << "Wrong input please try again: To COMPLETE request (0). To REJECT request (1): ";
					}
					else break;
				} while (true);

				if (input == 1)
				{
					reqArray[i].status = static_cast<RequestStatus>(1);
					cout << "Request successfully REJECTED." << endl;
					return;
				}
				else
				{
					cin.ignore();
					cout << "Enter Technician Name: ";
					cin.getline(reqArray[i].technicianName, MAX_STRING_LENGTH);

					cout << "Enter Repair Details: ";
					cin.getline(reqArray[i].repairDetails, MAX_STRING_LENGTH);

					do
					{
						cout << "Enter Repair Cost before type calculation: ";
						cin >> reqArray[i].repairCost;
						if (cin.fail())
						{
							cout << "Try again please." << endl;
						}
						else break;
					} while (true);

					if (reqArray[i].type == 0)
					{
						cout << "Final price is: " << reqArray[i].repairCost << "because request type is NORMAL" << endl;
					}
					else if (reqArray[i].type == 1)
					{
						reqArray[i].repairCost += reqArray[i].repairCost / 5;
						cout << "Final price is: " << reqArray[i].repairCost << "because request type is FAST" << endl;
					}
					else
					{
						reqArray[i].repairCost += reqArray[i].repairCost / 2;
						cout << "Final price is: " << reqArray[i].repairCost << "because request type is EXPRESS" << endl;
					}

					reqArray[i].status = static_cast<RequestStatus>(2);
					cout << "Request successfully completed." << endl;
					return;
				}
			}
			else cout << "Request has either been COMPLETED or REJECTED" << endl;
			return;
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
	cout << "6: Complete request." << endl;
	cout << "7: Additional request information." << endl;
	cout << "8: Clear console." << endl;
	cout << "9: Exit." << endl;
	cout << "----------------------------------" << endl;
}

int InputCommand(int& c)
{
	cout << "Please input command from 1 to 9." << endl;
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
		cin.ignore();
		cout << "";
		reqArray[inputtedRequests].requestNumber = inputtedRequests + 1;
		cout << "Request Number is: " << reqArray[inputtedRequests].requestNumber << endl;

		cout << "Enter Date (DD-MM-YYYY): ";
		cin.getline(reqArray[inputtedRequests].date, MAX_STRING_LENGTH);

		cout << "Enter Client Name: ";
		cin.getline(reqArray[inputtedRequests].clientName, MAX_STRING_LENGTH);

		for (int j = 0; j < 10; j++)
		{
			cout << j + 1 << ": " << deviceTypes[j] << endl;
		}
		int deviceTypeIndex;
		cout << "Select Device Type: ";
		cin >> deviceTypeIndex;
		deviceTypeIndex--;
		while (deviceTypeIndex < 0 || deviceTypeIndex >= 10 || cin.fail())
		{
			cout << "Invalid selection. Please select a valid device type index: ";
			cin >> deviceTypeIndex;
		}
		strcpy_s(reqArray[inputtedRequests].deviceType, deviceTypes[deviceTypeIndex]);

		cout << "Enter Serial Number: ";
		cin.ignore();
		cin.getline(reqArray[inputtedRequests].serialNumber, MAX_STRING_LENGTH);

		for (int j = 0; j < 10; j++)
		{
			cout << j + 1 << ": " << issueDescriptions[j] << endl;
		}
		int issueDescriptionIndex;
		cout << "Select Issue Description: ";
		cin >> issueDescriptionIndex;
		issueDescriptionIndex--;
		while (issueDescriptionIndex < 0 || issueDescriptionIndex >= 10 || cin.fail())
		{
			cout << "Invalid selection. Please select a valid issue description index: ";
			cin >> issueDescriptionIndex;
		}
		strcpy_s(reqArray[inputtedRequests].issueDescription, issueDescriptions[issueDescriptionIndex]);

		cout << "Technician Name is pending. " << endl;
		cout << "Repair Details are pending. " << endl;
		cout << "Repair Cost is pending. " << endl;

		int typeInput;
		bool fine = false;
		do
		{
			cout << "Enter Status (0 for NORMAL, 1 for FAST, 2 for EXPRESS): ";
			cin.ignore();

			cin >> typeInput;
			if (typeInput > 2 || typeInput < 0)
			{
				cout << "Wrong input! Try Again: (0 for NORMAL, 1 for FAST, 2 for EXPRESS): ";
			}
			else
			{
				fine = true;
			}
		} while (fine == false);

		reqArray[inputtedRequests].type = static_cast<RequestType>(typeInput);
		reqArray[inputtedRequests].status = static_cast<RequestStatus>(0);
		cout << "\nRequest data successfully entered!\n\n" << "----------------------------------" << endl;
		inputtedRequests += 1;
	}
}

void SortByDate(Request reqArray[], int const inputtedRequests)
{
	auto parseDate = [](const char* date, int& day, int& month, int& year) {
		sscanf_s(date, "%d-%d-%d", &day, &month, &year);
		};

	for (int i = 0; i < inputtedRequests - 1; ++i) {
		for (int j = 0; j < inputtedRequests - i - 1; ++j) {
			int day1, month1, year1;
			int day2, month2, year2;
			parseDate(reqArray[j].date, day1, month1, year1);
			parseDate(reqArray[j + 1].date, day2, month2, year2);

			if (year1 > year2 || (year1 == year2 && month1 > month2) || (year1 == year2 && month1 == month2 && day1 > day2)) {
				Request temp = reqArray[j];
				reqArray[j] = reqArray[j + 1];
				reqArray[j + 1] = temp;
			}
		}
	}
	DisplayDevices(reqArray, inputtedRequests);
}

void ImportAndExportBinaryFileAutomatically(Request reqArray[], int& inputtedRequests, bool end)
{
	if (end == false)
	{
		ifstream input_file("requestsPermanent.dat", ios::binary | ios::ate);
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
		ofstream output_file("requestsPermanent.dat", ios::binary);
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
	
		if (requestCount == 0) {
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

void SortByDeviceType(Request reqArray[], int const inputtedRequests)
{
	Request sortedRequests[MAX_LENGTH];
	for (int i = 0; i < inputtedRequests; ++i) {
		sortedRequests[i] = reqArray[i];
	}
	for (int i = 0; i < inputtedRequests - 1; ++i) {
		for (int j = 0; j < inputtedRequests - i - 1; ++j) {
			if (strcmp(sortedRequests[j].deviceType, sortedRequests[j + 1].deviceType) < 0) {
				Request temp = sortedRequests[j];
				sortedRequests[j] = sortedRequests[j + 1];
				sortedRequests[j + 1] = temp;
			}
		}
	}
}

void AdditionalRequestInformation(Request reqArray[], int& inputtedRequests)
{
	cout << "To displaying completed requests for certain technician (0). \n To display all requests with a certain issue for a certain device (1)\n: ";
	cin.ignore();
	int command;
	do
	{
		cin >> command;
		if (command > 1 || command < 0 || cin.fail())
		{
			cout << "Wrong Command. Please try again. To displaying completed requests for certain technician (0). \n To display all requests with a certain issue for a certain device (1)\n: ";
		}
		else break;
	} while (true);

	if (command == 1)
	{
		char searchDevice[MAX_STRING_LENGTH];
		cout << "Enter a device type substring to search for: ";
		cin.ignore();
		cin.getline(searchDevice, MAX_STRING_LENGTH);
		char searchIssue[MAX_STRING_LENGTH];
		cout << "Enter an issue description substring to search for: ";
		cin.ignore();
		cin.getline(searchIssue, MAX_STRING_LENGTH);
		Request filteredRequests[MAX_LENGTH];
		int filteredCount = 0;
		for (int i = 0; i < inputtedRequests; ++i)
		{
			if (strstr(reqArray[i].deviceType, searchDevice) != nullptr && strstr(reqArray[i].issueDescription, searchIssue) != nullptr)
			{
				filteredRequests[filteredCount++] = reqArray[i];
			}
		}
		SortByDeviceType(filteredRequests, filteredCount);
		DisplayDevices(filteredRequests, filteredCount);
	}
	else if (command == 0)
		{
			Request completedRequests[MAX_LENGTH];
			int completedCount = 0;

			for (int i = 0; i < inputtedRequests; ++i)
			{
				if (reqArray[i].status == COMPLETED)
				{
					completedRequests[completedCount++] = reqArray[i];
				}
			}

			cout << "Technician Names for Completed Requests:" << endl;
			for (int i = 0; i < completedCount; ++i)
			{
				cout << completedRequests[i].technicianName << endl;
			}

			char searchTechnician[MAX_STRING_LENGTH];
			cout << "Enter a technician name substring to search for: ";
			cin.ignore();
			cin.getline(searchTechnician, MAX_STRING_LENGTH);

			Request filteredRequests[MAX_LENGTH];
			int filteredCount = 0;
			for (int i = 0; i < completedCount; ++i)
			{
				if (strstr(completedRequests[i].technicianName, searchTechnician) != nullptr)
				{
					filteredRequests[filteredCount++] = completedRequests[i];
				}
			}
			SortByDate(filteredRequests, filteredCount);
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

		if (command < 1 || command > 9 || cin.fail())
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
			case 4: SortByDate(reqArray, inputtedRequests); break;
			case 5: ImportAndExportBinaryFile(reqArray, inputtedRequests); break;
			case 6: CompleteRequest(reqArray, inputtedRequests); break;
			case 7: AdditionalRequestInformation(reqArray, inputtedRequests); break;
			case 8: system("cls"); PrintMenu(); break;
			}
		}
	} while (command != 9);
	ImportAndExportBinaryFileAutomatically(reqArray, inputtedRequests, true);
}