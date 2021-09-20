#include <stdio.h>

#define SIZE 3000


void swap(int *a, int *b) {
    int tmp = *a;
    *a = *b;
    *b = tmp;
}

int get_size_of_str(char arr[]) {
    int size = 0;
    while (arr[size] != '\0') {
        size += 1;
    }
    return size;
}

void reverse(char arr[], int size, int index) {
    if(index >= size - index){
        return;
    }
    char tmp = arr[index];
    arr[index] = arr[size - index - 1];
    arr[size - index - 1] = tmp;
    //    printf("%d - %d\n", index, size - index - 1);
    reverse(arr, size, index + 1);
}

int main() {
    int a = 1, b = 2;
    printf("%d - %d\n", a, b);
    swap(&a, &b);
    printf("%d - %d\n", a, b);


    char arr[SIZE];
    scanf("%s", arr);
    int size = get_size_of_str(arr);
    reverse(arr, size, 0);
    for(int i = 0; i < size; i++){
        printf("%c", arr[i]);
    }
    return 0;
}
