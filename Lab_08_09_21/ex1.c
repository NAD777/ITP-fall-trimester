#include <stdio.h>
#include <string.h>

#define SIZE 3000

int get_size_of_str(char arr[]) {
    int size = 0;
    while (arr[size] != '\0') {
        size += 1;
    }
    return size;
}


int main() {
    char arr[10];
    scanf("%s", arr);
    int size = get_size_of_str(arr);
    int size1 = strlen(arr);
    printf("%d - %d\n", size, size1);
//    for (int i = size - 1; i >= 0; i--) {
//        printf("%c", arr[i]);
//    }
    return 0;
}


