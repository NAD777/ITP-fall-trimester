#include <stdio.h>
#include <stdlib.h>

int calc_factorial(int n){
    int ans = 1;
    for(int i = 1; i <= n; i++){
        ans *= i;
    }
    return ans;
}

int main() {
    int start, end;
    int index = 0;
    int *arr = (int *) malloc(sizeof(int) * 10000);
    scanf("%d%d", &start, &end);
    for(int x = start; x <= end; x++){
        int res = 0, tmp = x;
        while(tmp){
            res += calc_factorial(tmp % 10);
            tmp /= 10;
        }
        if(res == x){
            arr[index] = x;
            index += 1;
        }
    }
    printf("The strong numbers are: ");
    for(int i = 0; i < index; i++){
        if(i == index - 1)
            printf("%d", arr[i]);
        else
            printf("%d, ", arr[i]);
    }
    return 0;
}