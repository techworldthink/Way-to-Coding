/*
 * Collect student details like ID,Name,marks of 3 subjects and store it in array of student struct.
 * Display details of student baseed on given id.
 * Student details collection & display details must loop umtil user want quite.
 * Display student marks summary.
 */

#include<stdio.h>
#include<ctype.h>

#define Max_Subjects 3
#define Max_Students 100

void CaptureData();
void DisplayData();

struct StudentDetails {
	int studentID;
	int mark[Max_Subjects];
	int score;
	char grade;
};


void CaptureData() {

	struct StudentDetails student[Max_Students];
	char YOrNo;
	int i;

	/*Initialize all members to NULL value*/
	for(i=0; i<Max_Students; i++) {
		student[i].studentID = 0;
		student[i].mark[0] = 0;
		student[i].mark[1] = 0;
		student[i].mark[2] = 0;
		student[i].score = 0;
		student[i].grade = ' ';
	}

	for(i=0; i<Max_Students; i++) {
		printf("\nEnter the Student ID: ");
		scanf("%d", &student[i].studentID);
		printf("\nEnter the mark in Subject 1: ");
		scanf("%d", &student[i].mark[0]);
		printf("\nEnter the mark in Subject 2: ");
		scanf("%d", &student[i].mark[1]);
		printf("\nEnter the mark in Subject 3: ");
		scanf("%d", &student[i].mark[2]);
		getchar();
		student[i].score = (student[i].mark[0] + student[i].mark[1] + student[i].mark[2])/(Max_Subjects);
		printf("\nDo you want to continue: Y/N: ");
		YOrNo = getchar();
		if(toupper(YOrNo) != 'Y') break;
	}

	DisplayData(student);

}


void DisplayData(struct StudentDetails student[]) {

	int ID = 0, flag = 0;
	char grade, YOrNo;;
	int countA = 0, countB = 0, countC = 0, countF = 0;
	int i;

	for(i=0; i<Max_Students; i++) {
		if(student[i].score >= 80) {
			student[i].grade = 'A';
			countA++;
		} else if(student[i].score >= 60 && student[i].score <80) {
			student[i].grade = 'B';
			countB++;
		} else if(student[i].score >= 40 && student[i].score <60) {
			student[i].grade = 'C';
			countC++;
		} else {
			student[i].grade = 'F';
			countF++;
		}
	}

	while(1) {

		flag = 0;
		int i;

		printf("\nEnter the student ID to display details: ");
		scanf("%d", &ID);
		getchar();

		for(i=0; i<Max_Students; i++) {
			if (student[i].studentID == ID) {
				flag = 0;
				printf("\n Student ID: %d", student[i].studentID);
				printf("\n Subject 1 mark: %d", student[i].mark[0]);
				printf("\n Subject 2 mark: %d", student[i].mark[1]);
				printf("\n Subject 3 mark: %d", student[i].mark[2]);
				printf("\n Student grade: %c", student[i].grade);
				printf("\n*****");
				break;
			} else {
				flag = 1;
				continue;
			}
		}

		if(flag == 1) printf("\nStudent ID Not Found");
		printf("\nDo you want to display details of another student: Y/N: ");
		YOrNo = getchar();
		if(toupper(YOrNo) != 'Y') break;
	}

	printf("\n **GRADE SUMMARY****");
	printf("\n Number of Students with A grade: %d students", countA);
	printf("\n Number of Students with B grade: %d students", countB);
	printf("\n Number of Students with C grade: %d students", countC);
	printf("\n Number of Students with F grade: %d students", countF);
}


void main() {
	CaptureData();
	//DisplayData();
}


