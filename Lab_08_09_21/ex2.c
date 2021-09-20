#include <stdio.h>

#define SIZE 3000

void out_put_triangle(int n) {
    for (int i = 1; i <= n; i++) {
        int cur_spaces = 2 * n - 1 - i - 3;
        for (int j = 0; j < cur_spaces; j++) {
            printf(" ");
        }
        for (int j = 0; j < 2 * i - 1; j++) {
            printf("*");
        }
        printf("\n");
    }
}


int main() {
    int n;
    scanf("%d", &n);
    out_put_triangle(n);
    return 0;
}


