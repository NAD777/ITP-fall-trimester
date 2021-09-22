#include <stdio.h>

#define us unsigned short

struct foobar {
    us day: 5;
    us mon: 4;
    us year: 7;
};


int main() {
    struct foobar foo;
    foo.day = 7;
    foo.mon = 7;
    foo.year = 3;
    printf("%d - %d - %d\n", foo.day, foo.mon, foo.year);
    printf("SIZE: %d Bytes", sizeof(foo));
    return 0;
}
// year: 7 mon: 4 day: 5 bits