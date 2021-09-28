//
// Created by Антон Нехаев on 09.09.2021.
//

#include <stdio.h>

#define SIZE 300

void swap(int *a, int *b) {
    int tmp = *a;
    *a = *b;
    *b = tmp;
}

int main() {
    FILE *input = fopen("input.txt", "r");
    FILE *output = fopen("output.txt", "w");
    int arr[SIZE];
    for (int i = 0; i < SIZE; i++) {
        arr[i] = 0;
    }
    char str[SIZE];
    fgets(str, SIZE, input);
    int size = 0, tmp = 0;
    for (int i = 0; i < SIZE && str[i] != '\0'; i++) {
        if (str[i] == ' ') {
            arr[size] = tmp;
            size += 1;
            tmp = 0;
        } else {
            if ('0' <= str[i] && str[i] <= '9') {
                tmp = tmp * 16 + (str[i] - '0');
            } else if ('A' <= str[i] && str[i] <= 'Z') {
                tmp = tmp * 16 + (str[i] - 'A' + 10);
            }
        }
    }
    arr[size] = tmp;

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {

            if (arr[j] > arr[j + 1]) {

                swap(&arr[j], &arr[j + 1]);
            }
        }
    }

    for (int i = 0; i <= size; i++) {
        int tmp = arr[i], index = 0;
        char out[SIZE];
        while (tmp) {
            int remainder = tmp % 16;
            out[index] = "0123456789ABCDEF"[remainder];
            tmp /= 16;
            index += 1;
        }

        for (int j = index - 1; j >= 0; j--) {
            fprintf(output, "%c", out[j]);
        }
        if (i != size)
            fprintf(output, " ");
    }
    return 0;
}
