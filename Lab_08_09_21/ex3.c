#include <stdio.h>

#define SIZE 3000

void out_put_triangle(int *len) {
    int n = *len;
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


void out_second(int *n) {
    int len = *n / 2;
    int cnt = 1;
    for (int i = 0; i < len; i++) {
        for (int j = 0; j < cnt; j++) {
            printf("*");
        }
        cnt += 1;
        printf("\n");
    }
    cnt -= 1;
    for (int i = 0; i < len; i++) {
        for (int j = 0; j < cnt; j++) {
            printf("*");
        }
        cnt -= 1;
        printf("\n");
    }

}

void out_col(int *n, int *m) {
    int rows = *n;
    int cols = *m;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            printf("*");
        }
        printf("\n");
    }
}

int main() {
    int n, m;
    scanf("%d%d", &n, &m);
    out_put_triangle(&n);
    out_second(&n);

    out_col(&n, &m);

    return 0;
}