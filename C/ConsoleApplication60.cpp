#include <stdio.h>
#include "string.h"
#include "stdlib.h"
#define _CRT_SECURE_NO_WARNINGS

typedef struct
{
	char firstName[50];
	char lastName[50];
	long id;
	char english, french, maths, philosophy;
} result;

// array of pointers to 'result' structures - assuming that there is 100 or less records in the data file
result* results[100];

// number of records read from the file
int numResults = 0;

// read file and populate the results
// you will need to use malloc to allocate a new 'result' structure for each record read from the file
// the *result pointer returned by malloc will be stored in the next member of the array *results[]
int readFile(char* fileName);

// set all the pointers in *results[] to NULL before reading in the file
void initialiseResults();

// function to print an individual member of the *results[] array
void printResult(result* aResult);

int main()
{
	char fileName[] = "C:\\Users\\Maria\\Desktop\\results.txt";
	int i = 0;


	void initialiseResults();

	if (!readFile(fileName))
	{
		printf("File could not be opened !!\n");
		return 0;
	}

	while (results[i] != NULL)
	{
		printResult(results[i]);
		i++;
	}

	return 0;
}

void printResult(result* aResult)
{
	printf("%12s%12s%6d%10c%11c%12c%10c\n", aResult->lastName, aResult->firstName, aResult->id,
		aResult->maths, aResult->english, aResult->french, aResult->philosophy);
}

void initialiseResults()
{
	int i = 0;

	for (i = 0; i < 100; i++) results[i] = NULL;
}

int readFile(char* fileName)
{
	char line[200];
	FILE* fptr = fopen(fileName, "r");
	int i = 0;

	if (fptr == NULL)
	{
		printf("Error opening file ! \n");
		return 0;
	}

	// use fgets to skip first line
	fgets(line, 200, fptr);

	//first data line
	results[i] = (result*)malloc(sizeof(result));

	fscanf(fptr, "%d\t%s\t%s\t%c\t%c\t%c\t%c\n", &results[i]->id, results[i]->firstName, results[i]->lastName,
		&results[i]->english, &results[i]->maths, &results[i]->french, &results[i]->philosophy);

	while (!feof(fptr))
	{
		i++;
		results[i] = (result*)malloc(sizeof(result));
		fscanf(fptr, "%d\t%s\t%s\t%c\t%c\t%c\t%c\n", &results[i]->id, results[i]->firstName, results[i]->lastName,
			&results[i]->english, &results[i]->maths, &results[i]->french, &results[i]->philosophy);
	}

	numResults = i;

	fclose(fptr);

	return 1;

	return 1;
}
