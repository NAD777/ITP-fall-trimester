#include <stdio.h>
#include <string.h>
#include <stdlib.h>


#define SIZE 1000

int main() {
    int inp[] = {0, 1, 1, 3, 1, 1, 4, 2, 5, 4, 0, 0, 5};
    int flags[SIZE];

    int ans[SIZE];
    int index = 0;
    for (int i = 0; i < SIZE; flags[i] = 0, i++);

    for (int i = 0; i < sizeof(inp) / sizeof(inp[0]); i++) {
        if (!flags[inp[i]]) {
            ans[index] = inp[i];
            flags[inp[i]] = 1;
            index += 1;
        }
    }
    for(int i = 0; i < index; i++){
        printf("%d ", ans[i]);
    }
    return 0;
}