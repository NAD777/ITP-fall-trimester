#include <stdio.h>

#define LEN 200

int convert(char *arr) {
    int ans = 0;
    int i = 0;
    int k = 1;
    if (arr[0] == '-') {
        i += 1;
        k = -1;
    }
    while (arr[i] != 0) {
        ans = ans * 10 + (arr[i] - '0');
        i += 1;

    }
    return k * ans;
}


char get_upper(char a, int n) {
    char upper[26] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int index = 0;
    for (int i = 0; i < 26; i++) {
        if (upper[i] == a) {
            index = i;
            break;
        }
    }
    return upper[((index + n) % 26 + 26) % 26];
}

char get_lower(char a, int n) {
    char lower[26] = "abcdefghijklmnopqrstuvwxyz";
    int index = 0;
    for (int i = 0; i < 26; i++) {
        if (lower[i] == a) {
            index = i;
            break;
        }
    }
//    printf("%d %d ", index, ((index + n) % 26 + 26) % 26);
    return lower[((index + n) % 26 + 26) % 26];
}

int main() {
    char arr[LEN][LEN];
    FILE *input = fopen("input.txt", "r");
    FILE *output = fopen("output.txt", "w");
    for (int i = 0; i < LEN; i++) {
        for (int j = 0; j < LEN; j++) {
            arr[i][j] = 0;
        }
    }
    int col = 0;
    while (1) {
        if (feof(input))
            break;
        fgets(arr[col], 1000, input);
        col += 1;
    }
    int n = convert(arr[col - 1]);
//    printf("%d\n", n);
//    printf("%d\n", n);
    for (int i = 0; i < col - 1; i++) {
        int j = 0;
        while (arr[i][j] != '\n') {
//            printf("%c ", arr[i][j]);
            if ('A' <= arr[i][j] && arr[i][j] <= 'Z') {
                printf("%c", get_upper(arr[i][j], n));
                fputc(get_upper(arr[i][j], n), output);
            } else if ('a' <= arr[i][j] && arr[i][j] <= 'z') {
                printf("%c", get_lower(arr[i][j], n));
                fputc(get_lower(arr[i][j], n), output);
            } else {
                printf("%c", arr[i][j]);
                fputc(arr[i][j], output);
            }
            j += 1;
//            printf("\n");
        }
        if (i != col - 2) {
            printf("\n");
            fputc('\n', output);
        }

    }
//    for (int i = 0; i < col; i++) {
//        fputc(arr[i], output);
//    }

    return 0;
}
