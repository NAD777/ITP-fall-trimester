#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 1000
#define DEBUG 0

int main() {
    FILE *input = freopen("input.txt", "r", stdin);
    FILE *output = freopen("output.txt", "w", stdout);

    char inp[SIZE][SIZE];
    int cnt = 0;
    while (scanf("%s", inp[cnt]), cnt += 1, !feof(input)); // input words from file

    int maxWidth = atoi(inp[cnt - 1]); // convert maxWidth from input to integer
    cnt = cnt - 1;
    int i = 0;
    while (i < cnt) {
        int sum_len = 0;
        int j = i;
        int flag = 0;
        while (j < cnt) {
            sum_len += strlen(inp[j]);
            if (sum_len + (j - i) > maxWidth) {
                flag = 1;
                break;
            }
            j += 1;
        }
        if (flag)
            sum_len -= strlen(inp[j]);
        else {
            for (int z = i; z < j; z++) {
                printf("%s", inp[z]);
                if (z != j - 1) {
                    printf(" ");
                }
            }
            return 0;
        }
        j -= 1;

//        int avg_space = (maxWidth - sum_len) / ((j - i) != 0 ? (j - i) : 1);
//        int remainder_spaces = maxWidth - sum_len - avg_space * (j - i);
        if (DEBUG) {
            printf("%d : %d\n", sum_len, (j - i));
//            printf("%d - %d\n", avg_space, remainder_spaces);
        }
        // block of printing a line

        int size = (j - i);
        int *spaces = malloc(sizeof(int) * size);
        for(int t = 0; t < size; t++){
            spaces[t] = 0;
        }
        int index = 0, col_spaces = maxWidth - sum_len;
        while(col_spaces){
            spaces[index] += 1;
            index = (index + 1) % size;
            col_spaces -= 1;
        }
        // print spaces after first word of sentence
//        for (int z = 0; z < remainder_spaces + avg_space; z++) {
//            printf(" ");
//        }
        for (int t = i; t <= j; t++) {
            printf("%s", inp[t]);
            if (t != j) {
                for (int z = 0; z < spaces[t - i]; z++) {
                    printf(" ");
                }
            }
        }
        // end block of printing line
        if (DEBUG) {
            printf("\n...........\n");
        }

        printf("\n");

        i = j + 1;
    }

    return 0;
}
