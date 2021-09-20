#include <stdio.h>
#include <string.h>
#include <stdlib.h>


#define SIZE 1000

int main() {
    int *lower = (int *) malloc(sizeof(int) * 26);
    int *upper = (int *) malloc(sizeof(int) * 26);
    memset(lower, 0, 26);
    memset(upper, 0, 26);

    char *inp = (char *) malloc(sizeof(char) * 1000);

    gets(inp);
    //    printf("%s\n", inp);

    int max_val = 0;
    for (int i = 0; i < strlen(inp); i++) {
        char sym = inp[i];
        if ('a' <= sym && sym <= 'z') {
            lower[sym - 'a'] += 1;
            max_val = max_val < lower[sym - 'a'] ? lower[sym - 'a'] : max_val;
        }
        if ('A' <= sym && sym <= 'Z') {
            upper[sym - 'a'] += 1;
            max_val = max_val < upper[sym - 'a'] ? upper[sym - 'a'] : max_val;
        }
    }
    int *lower_done = (int *) malloc(sizeof(int) * 26);
    int *upper_done = (int *) malloc(sizeof(int) * 26);
    memset(lower_done, 0, 26);
    memset(upper_done, 0, 26);

    for (int i = 0; i < strlen(inp); i++) {
        char sym = inp[i];
        if ('a' <= sym && sym <= 'z' && !lower_done[sym - 'a']) {
            printf("%c ", sym);
            lower_done[sym - 'a'] = 1;
        }
        if ('A' <= sym && sym <= 'Z' && !lower_done[sym - 'A']) {
            printf("%c ", sym);
            lower_done[sym - 'A'] = 1;
        }
    }
    printf("\n");

    for (int col = 0; col < max_val; col++) {
        for (int z = 0; z < 26; z++) {
            lower_done[z] = 0;
            upper_done[z] = 0;
        }

        for (int i = 0; i < strlen(inp); i++) {
            char sym = inp[i];
            if ('a' <= sym && sym <= 'z' && !lower_done[sym - 'a']) {
                if (lower[sym - 'a'] > col) {
                    printf(". ");
                } else {
                    printf("  ");
                }
                lower_done[sym - 'a'] = 1;
            }
            if ('A' <= sym && sym <= 'Z' && !upper_done[sym - 'A']) {
                if (lower[sym - 'A'] > col) {
                    printf(". ");
                } else {
                    printf("  ");
                }
                upper_done[sym - 'A'] = 1;
            }
        }
        printf("\n");
    }
    return 0;
}