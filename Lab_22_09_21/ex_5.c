#include <stdio.h>
#include <stdlib.h>

#define SIZE 1000

struct ingredient {
    char name[SIZE];
    int amount;
};

struct recipe {
    char name[100];
    struct ingredient ings[10000];
    int col_ing;
};


int main() {
    int n;
    printf("Enter number of recipes: ");
    scanf("%d", &n);
    //    printf("\n");

    struct recipe *recipes = (struct recipe *) malloc(sizeof(struct recipe) * n);

    for (int i = 0; i < n; i++) {
        printf("Enter name of recipe: ");
        scanf("%s", recipes[i].name);
        //        printf("\n");

        printf("Enter number of ingredients: ");
        scanf("%d", &recipes[i].col_ing);
        //        printf("\n");

        for (int j = 0; j < recipes[i].col_ing; j++) {
            printf("Enter name of ingredient: ");
            scanf("%s", recipes[i].ings[j].name);
            //            printf("\n");

            printf("Enter amount of ingredient %s: ", recipes[i].ings[j].name);
            scanf("%d", &recipes[i].ings[j].amount);
            //            printf("\n");
        }
    }


    for (int i = 0; i < n; i++) {
        printf("************\n");
        printf("Name: %s", recipes[i].name);
        printf("\n");

        for (int j = 0; j < recipes[i].col_ing; j++) {
            printf("Ingredients:");
            printf("%d - %s: %d", j + 1, recipes[i].ings[j].name, recipes[i].ings[j].amount);
            printf("\n");
        }
        printf("************\n\n");
    }


    return 0;
}