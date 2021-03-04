#include <stdio.h>
#include "string.h"
#include "stdlib.h"
#define _CRT_SECURE_NO_WARNINGS


typedef struct
{
	char firstName[50];
	char lastName[50];
	char companyName[50];
	char address[50];
	char city[50];
	char county[50];
	char state[50];
	char zip[50];
	char phone1[50];
	char phone2[50];
	char email[50];
	char web[50];
} contact;

int numContacts = 0;
contact contacts[501];

int readFile(char* fileName);
int findContact(char* string);
void printContact(contact theContact);


void main()
{
	char string[20];
	char fileName[] = "C:\\Users\\Maria\\Desktop\\us-500.csv";
	int i = 0;
	int option;


	if (!readFile(fileName))
	{
		printf("File could not be opened !!\n");
		return;
	}

	puts("Enter name you are looking for: ");

	gets_s(string);

	findContact(string);

}

int findContact(char* string)
{
	int i, j = 0;
	for (i = 0; i < numContacts; i++)
	{
		// INSERT YOUR CODE HERE
		if (strstr(strlwr(contacts[i].firstName), strlwr(string)))
		{
			printContact(contacts[i]);
		}
	}

	return j;
}

void printContact(contact theContact)
{
	printf("First Name: %s\n", theContact.firstName);
	printf("Last Name: %s\n", theContact.lastName);
	printf("Company Name: %s\n", theContact.companyName);
	printf("Address: %s\n", theContact.address);
	printf("City: %s\n", theContact.city);
	printf("County: %s\n", theContact.county);
	printf("State: %s\n", theContact.state);
	printf("Zip: %s\n", theContact.zip);
	printf("Phone #1: %s\n", theContact.phone1);
	printf("Phone #2: %s\n", theContact.phone2);
	printf("e-mail: %s\n", theContact.email);
	printf("Web: %s\n", theContact.web);

}


int readFile(char* fileName)
{
	char line[200];
	FILE* fptr = fopen(fileName, "r");
	char* token;
	char delim[6] = ",";
	int n = 0, i = 0;
	contact newContact;

	if (fptr == NULL)
	{
		printf("Error opening file ! \n");
		return 0;
	}

	// use fgets to skip first line
	fgets(line, 200, fptr);

	//first data line
	fgets(line, 200, fptr);
	while (!feof(fptr))
	{
		char delim[6] = "\",";
		token = strtok(line, delim);
		strcpy(newContact.firstName, token);
		token = strtok(NULL, delim);
		strcpy(newContact.lastName, token);
		token = strtok(NULL, delim);
		strcpy(newContact.companyName, token);
		token = strtok(NULL, delim);
		strcpy(newContact.address, token);
		token = strtok(NULL, delim);
		strcpy(newContact.city, token);
		token = strtok(NULL, delim);
		strcpy(newContact.county, token);
		token = strtok(NULL, delim);
		strcpy(newContact.state, token);
		token = strtok(NULL, delim);
		strcpy(newContact.zip, token);
		token = strtok(NULL, delim);
		strcpy(newContact.phone1, token);
		token = strtok(NULL, delim);
		strcpy(newContact.phone2, token);
		token = strtok(NULL, delim);
		strcpy(newContact.email, token);
		token = strtok(NULL, delim);
		strcpy(newContact.web, token);
		token = strtok(NULL, delim);


		contacts[numContacts] = newContact;
		numContacts++;

		printContact(newContact);

		//next data line
		fgets(line, 200, fptr);

	}

	fclose(fptr);

	return 1;
}
