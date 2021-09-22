#include <stdio.h>
#include <stdlib.h>

#define SIZE 1000
#define ull unsigned long long
#define uc unsigned char

union foobar {
    ull x;
    uc bytes[8];
};

void swap(uc *foo, uc *bar) {
    int tmp = *foo;
    *foo = *bar;
    *bar = tmp;
}

void encript(uc arr[]) {
    for (int i = 0; i < 8; i = i + 2) {
        swap(&arr[i], &arr[i + 1]);
    }
}

int main() {
    union foobar u1;
    scanf("%llu", &u1.x);
    printf("%llu\n", u1.x);
    encript(u1.bytes);
    printf("%llu\n", u1.x);
    encript(u1.bytes);
    printf("%llu\n", u1.x);
    return 0;
}