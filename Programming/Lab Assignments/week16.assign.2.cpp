#include <stdio.h>
#include "string.h"
#include "stdlib.h"
#define _CRT_SECURE_NO_WARNINGS

typedef struct
{
	int day, month, year;
} date;

typedef struct
{
	char firstName[50];
	char lastName[50];
	char email[50];
	date dob;
} person;

char months[12][12] = { "January","February","March","April","May","June","July","August","September","October","November","December" };
int numContacts = 0;
person people[10];
int readFile(char* fileName);
int getAge(date dob);
char* getMonth(int month);

void printPerson(person p1);

int  main()
{
	char fileName[] = "C:\\Users\\Maria\\Desktop\\people.txt";
	int i = 0;

	if (!readFile(fileName))
	{
		printf("File could not be opened !!\n");
		return 0;
	}


}

// PRINTS OUT A PERSON DATA
// USES getAGE AND getMonth
void printPerson(person p1)
{
	printf("First name is: %s\n", p1.firstName);
	printf("Last name is: %s\n", p1.lastName);
	printf("e-mail is: %s\n", p1.email);
	printf("DOB is: %d/%d/%d\n", p1.dob.day, p1.dob.month, p1.dob.year);
	printf("Age is: %d\n\n", getAge(p1.dob));
}


int readFile(char* fileName)
{
	char line[400];
	FILE* fptr = fopen(fileName, "r");
	char* token;
	char delim[6] = ",";
	int n = 0, i = 0;
	person p1;
	date d1;

	if (fptr == NULL)
	{
		printf("Error opening file ! \n");
		return 0;
	}

	// use fgets to skip first line
	fgets(line, 400, fptr);

	//first data line
	fgets(line, 400, fptr);
	while (!feof(fptr))
	{
		// INSERT CODE HERE
		// USE STRTOK TO PARSE DATA AND POPULATE person STRUCTURE p1
		token = strtok(line, delim);
		strcpy(p1.firstName, token);
		token = strtok(NULL, delim);
		strcpy(p1.lastName, token);
		token = strtok(NULL, delim);
		strcpy(p1.email, token);

		token = strtok(NULL, "/");
		p1.dob.day = atoi(token);
		token = strtok(NULL, "/");
		p1.dob.month = atoi(token);
		token = strtok(NULL, "\t");
		p1.dob.year = atoi(token);

		// PRINT OUT PERSON p1
		printPerson(p1);

		// ADD p1 to ARRAY OF person STRUCTURES
		people[n] = p1;

		// INCREMENT NUM READ IN
		n++;

		//next data line
		fgets(line, 200, fptr);

	}
	numContacts = n;

	fclose(fptr);

	return 1;
}

// RETURNS AGE - DON'T WORRY ABOUT ACCURACY - NEAREST YEAR WILL DO

int getAge(date dob)
{
	int age;

	age = 2020 - dob.year;

	return age;

}

// RETURNS STRING TO USE IN PRINTING OUT THE MONTH
char* getMonth(int month)
{
	return months[month - 1];

}