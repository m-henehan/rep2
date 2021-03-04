#include <stdio.h>
#include "string.h"
#include "stdlib.h"
#define _CRT_SECURE_NO_WARNINGS

struct result
{
	int id, i = 0;
	char* firstName;
	char* lastName;
	char english, maths, french, philosophy;
	struct result* next;
};


struct result* readFile(char* fileName);
void printResult(struct result* theResult);
result* findResult(struct result* first, int id);

int main()
{
	char fileName[] = "C:\\Users\\Maria\\Desktop\\results.txt";
	int i = 0;

	struct result* first;
	struct result* foundResult;

	if ((first = readFile(fileName)) == NULL)
	{
		printf("File could not be opened !!\n");
		return 0;
	}

	printf("Looking for ID 105 ......\n");
	foundResult = findResult(first, 105);
	if (foundResult != NULL)
	{
		printResult(foundResult);
	}

	printf("\n\n");

	printf("Looking for ID 135 ......\n");
	foundResult = findResult(first, 135);
	if (foundResult != NULL)
	{
		printResult(foundResult);
	}

	return 0;
}

void printResult(struct result* theResult)
{

	{
		printf("%12s%12s%6d%10c%11c%12c%10c\n", theResult->lastName, theResult->firstName, theResult->id,
			theResult->maths, theResult->english, theResult->french, theResult->philosophy);
	}
}


struct result* readFile(char* fileName)
{
	char line[400];

	FILE* fptr = fopen(fileName, "r");
	char* token;
	char delim[6] = "\t";

	struct result* first = NULL;
	struct result* last = NULL;
	struct result* current = NULL;

	if (fptr == NULL)
	{
		printf("Error opening file ! \n");
		return 0;
	}

	// use fgets to skip first line
	fgets(line, 200, fptr);

	while (!feof(fptr))
	{

		//next data line
		fgets(line, 200, fptr);

		if (first == NULL)
		{
			first = (struct result*)malloc(sizeof(struct result));
			current = first;

		}
		else
		{

			current->next = (struct result*)malloc(sizeof(struct result));
			current = current->next;

		}

		if ((token = strtok(line, delim)) != NULL)
		{
			current->id = atoi(token);
		}

		if ((token = strtok(NULL, delim)) != NULL)
		{

			current->firstName = strdup(token);
		}

		if ((token = strtok(NULL, delim)) != NULL)
		{

			current->lastName = strdup(token);
		}

		if ((token = strtok(NULL, delim)) != NULL)
		{

			current->english = *token;
		}

		if ((token = strtok(NULL, delim)) != NULL)
		{

			current->maths = *token;

		}

		if ((token = strtok(NULL, delim)) != NULL)
		{

			current->french = *token;
		}

		if ((token = strtok(NULL, delim)) != NULL)
		{

			current->philosophy = *token;
		}


	}

	fclose(fptr);

	return first;
}


result* findResult(struct result* first, int id)
{
	struct result* current = first;

	while (current != NULL)
	{

		if (current->id == id) {
			return current;
		}
		current = current->next;
	}

	return NULL;
}