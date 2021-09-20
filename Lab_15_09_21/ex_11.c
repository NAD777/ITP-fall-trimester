#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define SIZE 100

void read_array(int **arr, int n, int m) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%d", &arr[i][j]);
        }
    }
}

void print_array(int **arr, int n, int m) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("%d ", arr[i][j]);
        }
        printf("\n");
    }
}

int main() {
    int n, m;
    scanf("%d %d", &n, &m);
    int **arr = malloc(sizeof(char *) * n);
    for (int i = 0; i < n; arr[i] = malloc(sizeof(int) * m), i++);
    read_array(arr, n, m);
    print_array(arr, n, m);
    return 0;
}