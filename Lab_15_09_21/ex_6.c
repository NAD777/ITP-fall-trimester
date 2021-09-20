#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    char *arr = (char *) malloc(sizeof(char) * 3);
    scanf("%s", arr);
    int s_len = strlen(arr), attempts = 0;
    if (s_len == 1) {
        for (int i = 32; i <= 126; i++) {
            if (i == arr[0]) {
                printf("found = %s\nnumber of attempts = %d", arr, attempts);
                return 0;
            }
            attempts += 1;
        }
    } else if (s_len == 2) {
        for (int i = 32; i <= 126; i++) {
            for (int j = 32; j <= 126; j++) {
                if (i == arr[0] && j == arr[1]) {
                    printf("found = %s\nnumber of attempts = %d", arr, attempts);
                    return 0;
                }
                attempts += 1;
            }
        }
    } else if (s_len == 3) {
        for (int i = 32; i <= 126; i++) {
            for (int j = 32; j <= 126; j++) {
                for (int z = 32; z <= 126; z++) {
                    if (i == arr[0] && j == arr[1] && z == arr[2]) {
                        printf("found = %s\nnumber of attempts = %d", arr, attempts);
                        return 0;
                    }
                    attempts += 1;
                }
            }

        }
    } else {
        printf("STRING NOT FIT");
    }
    return 0;
}