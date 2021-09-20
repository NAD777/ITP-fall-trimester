#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);
    int number_all = n * (n + 1) / 2 / 2;
    int cur = 1;
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < number_all - i - 1; j++) {
            printf(" ");
        }
        for (int j = 1; j <= i; j++) {
            printf("%d", cur);
            cur += 1;
        }
        printf("\n");

    }
    return 0;
}