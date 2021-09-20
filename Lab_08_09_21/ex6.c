//
// Created by Антон Нехаев on 08.09.2021.
//

#include <stdio.h>


struct Node {
    int data;
    struct Node *next;
    struct Node *prev;
};

int main() {
    struct Node head;
    struct Node first;
    struct Node second;

    head.prev = NULL;
    head.data = 0;
    head.next = &first;

    first.prev = &head;
    first.data = 1;
    first.next = &second;

    second.prev = &first;
    second.data = 2;
    second.next = NULL;

    struct Node *Cursor = &head;

    while (1) {
        printf("%d ", Cursor->data);
        if (Cursor->next == NULL) {
            break;
        }
        Cursor = Cursor->next;
    }
    printf("\n");
    while (1) {
        printf("%d ", Cursor->data);
        if (Cursor->prev == NULL) {
            break;
        }
        Cursor = Cursor->prev;

    }
    return 0;
}


