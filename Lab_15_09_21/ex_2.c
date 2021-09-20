#include <stdio.h>
#include <string.h>
#include <stdlib.h>


#define SIZE 1000

struct str {
    char x;
    int num;
};

int cmp(struct str *a, struct str *b){
    if(a -> num == b -> num){
        return a -> x > b -> x;
    }
    else{
        return a -> num < b ->num;
    }
}

int main() {
    int *lower = (int *) malloc(sizeof(int) * 26);
    memset(lower, 0, 26);

    char *inp = (char *) malloc(sizeof(char) * 1000);

    gets(inp);

    int col = 0;
    for (int i = 0; i < strlen(inp); i++) {
        char sym = inp[i];
        if ('a' <= sym && sym <= 'z') {
            if (lower[sym - 'a'] == 0) {
                col += 1;
            }
            lower[sym - 'a'] += 1;
        }
    }

    struct str *arr = malloc(sizeof(struct str) * col);
    int index = 0;
    for (int i = 0; i < 26; i++) {
        if (lower[i] != 0) {
            arr[index].num = lower[i];
            arr[index].x = i + 'a';
            index += 1;
        }
    }

    qsort(arr, col, sizeof(struct str), cmp);

    for(int i = 0; i < col; i++){
        printf("%c ", arr[i].x);
        for(int j = 0; j < arr[i].num; j++){
            printf(".");
        }
        printf("\n");
    }
    return 0;
}