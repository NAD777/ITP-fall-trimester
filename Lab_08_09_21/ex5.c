//
// Created by Антон Нехаев on 08.09.2021.
//

#include <stdio.h>

#define SIZE 3000

struct Node {
    int data;
    struct Node *next;
};

int main() {
    struct Node head;
    struct Node first;
    struct Node second;


    head.data = 0;
    head.next = &first;
    first.data = 1;
    first.next = &second;
    second.data = 2;
    second.next = NULL;
    //    printf("%d", (-7) % 6);
    struct Node *Cursor = &head;

    while (1) {
        printf("%d\n", Cursor->data);
        if (Cursor->next == NULL) {
            break;
        }
        Cursor = Cursor->next;
    }

    return 0;
}


