#include <stdio.h>
#include <stdlib.h>

#define SIZE 1000

struct student {
    char name[SIZE];
    char surname[SIZE];
    int groupNo;
    struct exam_data *exam;
};

struct exam_dat {
    int day;
    char month[SIZE];
    int year;
};

void pprint(const struct student *student1) {
    printf("..............................\n");
    printf("Name: %s\nSurname: %s\nGroup: %d\n\n", student1->name, student1->surname, student1->groupNo);

    struct exam_dat *exam = (struct exam_dat *) student1->exam;

    printf("Day: %d\nMon: %s\nYear: %d\n", exam->day, exam->month, exam->year);
    printf("..............................\n");
}

int main() {
    struct student *student1 = (struct student *) malloc(sizeof(struct student));
    scanf("%s%s%d", student1->name, student1->surname, &student1->groupNo);

    struct exam_dat *exam1 = (struct exam_dat *) malloc(sizeof(struct exam_dat));
    scanf("%d%s%d", &exam1->day, exam1->month, &exam1->year);

    student1->exam = (struct exam_data *) exam1;

    pprint(student1);

    free(exam1);
    free(student1);
    return 0;
}
