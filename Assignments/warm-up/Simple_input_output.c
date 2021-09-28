#include <stdio.h>

int main() {
    char arr[100];
    FILE *input = fopen("input.txt", "r");
    FILE *output = fopen("output.txt", "w");
    while(fgets(arr, 100, input) != NULL){
        fputs(arr, output);
    }
    return 0;
}
