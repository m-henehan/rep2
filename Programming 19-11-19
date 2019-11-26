#include "string.h"
#include "stdlib.h"
#include <stdio.h>

struct date
{
	int day, month, year;
};

struct student
{
	char firstName[50];
	char surname[50];
	int ID;
	struct date DOB;
};


int addStudent(struct student students[], int numStudents);
void printStudents(struct student students[], int numStudents);
void sortByID(struct student students[], int numStudents);
void sortBySurname(struct student students[], int numStudents);

int main()
{

	struct student students[100] = { {"Rolando","Gamble", 17560001, {1,1,2000}}, {"Kyra","Eaton", 17973061, {11,10,2016}}, {"Chandler","Bing", 17427400, {6,12,1999}}, {"Makayla","Huang", 17127058, {2,2,2000}}, {"Jazmyn","Terrell", 17746780, {29,6,2000}}, {"Erica","Glass", 17058753, {13,8,2000}}, {"Alyvia","Blair", 17599020, {11,9,2000}}, {"Talia","Chen", 17619205, {17,10,2000}}, {"Rebekah","Hopkins", 17912255, {25,11,2000}}, {"Jocelynn","Ware", 17899236, {27,4,1999}} };

	int numStudents = 10;

	// use addStudent to add a new student and it returns the updated number of students
	// obviously, numStudents is the number of structures in the array (students[]) that contain data
	numStudents = addStudent(students, numStudents);

	// sort by ID number and print out list
	sortByID(students, numStudents);
	printf("\n\n%d Students, Sorted by ID: \n", numStudents);
	printStudents(students, numStudents);

	// sort by surname and print out list
	sortBySurname(students, numStudents);
	printf("\n\n%d Students, Sorted by Surname: \n", numStudents);
	printStudents(students, numStudents);

	return 0;
}

int addStudent(struct student students[], int numStudents)
{
	char first[50], last[50];
	int id, dd, mm, yyyy;

	printf("Enter new student data; first name, surname, ID and DOB ");
	scanf("%s %s %d %d %d %d", first, last, &id, &dd, &mm, &yyyy);
	
		strcpy_s(students[numStudents].firstName, first);
		strcpy_s(students[numStudents].surname, last);
		students[numStudents].ID = id;
		students[numStudents].DOB.day = dd;
		students[numStudents].DOB.month = mm;
		students[numStudents].DOB.year = yyyy;

		numStudents++;

	return numStudents;
}

void printStudents(struct student students[], int numStudents)
{
	int i;
	printf("%20s%20s%15s\t\t%10s\n", "First Name", "Surname", "ID Number", "DOB");
	for (i = 0; i < numStudents; i++)
	{
		printf("%20s %20s \t %d \t\t %d %d %d\n", students[i].firstName, students[i].surname, students[i].ID, students[i].DOB.day, students[i].DOB.month, students[i].DOB.year);
	}
	printf("\n\n");
}


void sortByID(struct student students[], int numStudents)
{
	int i, pass;
	struct student temp;
	for (pass = 1; pass < numStudents; pass++)
	{
		for (i = 0; i < numStudents - 1; i++)
		{
			if (students[i].ID > students[i + 1].ID)
			{
				temp = students[i];
				students[i] = students[i + 1];
				students[i + 1] = temp;
			}

		}

	}
}


void sortBySurname(struct student students[], int numStudents)
{
	int i, pass;
	struct student temp;
	for (pass = 1; pass < numStudents; pass++)
	{
		for (i = 0; i < numStudents - 1; i++)
		{
			if (strcmp(students[i].surname, students[i + 1].surname)>0)
			{
				temp = students[i];
				students[i] = students[i + 1];
				students[i + 1] = temp;
			}

		}

	}
}
