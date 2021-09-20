#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    char *s1 = (char *) malloc(sizeof(char) * 100);
    char *s2 = (char *) malloc(sizeof(char) * 100);

    scanf("%s", s1);
    char *p1 = s1, *p2 = s2;

    while (*(p2++) = *(p1++));

    printf("%s\n", s1);
    printf("%s", s2);

    return 0;
}