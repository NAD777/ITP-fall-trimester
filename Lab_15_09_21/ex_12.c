#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    char *s = (char*) malloc(sizeof(char) * 100);
    scanf("%s", s);
    char *pos = s;
    for(;*(pos++););
    printf("%ld", pos - s);
    return 0;
}