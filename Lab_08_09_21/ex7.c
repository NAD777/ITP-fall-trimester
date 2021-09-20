//
// Created by Антон Нехаев on 08.09.2021.
//

#include <stdio.h>

#define SIZE 300

int main() {
    FILE *output = fopen("output.txt", "w");
    char buf[SIZE];
    printf("Enter '0' for end of input\n");
    while (1) {
        scanf("%s", buf);
        if (buf[0] == '0' && buf[1] == '\0') {
            break;
        }
        fprintf(output, "%s\n", buf);
    }
    return 0;
}


