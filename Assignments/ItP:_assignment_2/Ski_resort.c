#include <stdio.h>
#include <string.h>

#define SIZE 1000
#define DEBUG 0
#define or ||
#define and &&

struct Item {
    char name[SIZE];
    float size;
    int measurement;
    int num;
    int item_validation;
};

struct Person {
    char full_name[30];
    char data[30];
    char time[30];

    struct Item items[15];
    int num;

    int name_validation;
    int date_time_validation;
};


// also gets data
int validation_of_name(char s[], char *full_name) {
    // returns 1 if name valid else 0
    // check that all elements are characters
    int flag_all_letters = 1;
    for (int i = 0; i < strlen(s); i++) {
        if (!(('a' <= s[i] && s[i] <= 'z') || (('A' <= s[i] && s[i] <= 'Z'))) && s[i] != ' ') {
            flag_all_letters = 0;
            break;
        }
    }
    if (!flag_all_letters) {
        return 0;
    }

    strcpy(full_name, s); // copy name to container

    return 1;
}


// also gets data
int validation_of_date_time(char s[], char *data, char *time) {
    // returns 1 if date and time valid else 0
    // check for length of string "00:00:00 dd/mm/yyyy hh/mm/ss" format has len = 19
    if (strlen(s) != 19) {
        return 0;
    }
    // check for valid form "00:00:00 dd/mm/yyyy hh/mm/ss" that all of them a digits
    if (!(('0' <= s[0] && s[0] <= '9') && ('0' <= s[1] && s[1] <= '9') &&
          s[2] == '/' && ('0' <= s[3] && s[3] <= '9') && ('0' <= s[4] && s[4] <= '9') &&
          s[5] == '/' && ('0' <= s[6] && s[6] <= '9') && ('0' <= s[7] && s[7] <= '9') &&
          ('0' <= s[8] && s[8] <= '9') && ('0' <= s[9] && s[9] <= '9') &&
          s[10] == ' ' && ('0' <= s[11] && s[11] <= '9') && ('0' <= s[12] && s[12] <= '9') &&
          s[13] == ':' && ('0' <= s[14] && s[14] <= '9') && ('0' <= s[15] && s[15] <= '9') &&
          s[16] == ':' && ('0' <= s[17] && s[17] <= '9') && ('0' <= s[18] && s[18] <= '9'))) {
        return 0;
    }

    int day, mon, year, hours, minutes, sec;
    sscanf(s, "%d/%d/%d %d:%d:%d", &day, &mon, &year, &hours, &minutes, &sec);
    if (!(0 <= sec && sec < 60)) { // check secs
        return 0;
    }

    if (!(0 <= minutes && minutes < 60)) { // check minutes
        return 0;
    }

    if (!(0 <= hours && hours < 24)) { // check hours
        return 0;
    }

    if (!(0 <= year)) { // check year
        return 0;
    }

    if (!(1 <= mon && mon <= 12)) { // check month
        return 0;
    }

    //begin check day of the month
    int max_mon_days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) { // leap year check
        max_mon_days[2] = 29;
    }
    if (!(1 <= day and day <= max_mon_days[mon])) { // check days per month
        return 0;
    }
    //end check day

    for (int i = 0; i < 10; i++) { // pars "dd/mm/yyyy" to data
        data[i] = s[i];
    }

    for (int i = 11; i < 19; i++) { // pars "hh:mm:ss" to time
        time[i - 11] = s[i];
    }
    return 1;
}


// also gets data
int validation_of_item(char s[], char *name, float *size, int *num, int *measurement) {
    // begin check number of words
    int num_spaces = 0;
    for (int i = 0; i < strlen(s); i++) {
        if (s[i] == ' ') {
            num_spaces += 1;
        }
    }
    if (num_spaces < 3) {
        return 0;
    }
    // end check number of words

    // start of finding and copying name and surname
    num_spaces = 0;
    int index_end_name = strlen(s) - 1;
    while (index_end_name >= 0) {
        if (s[index_end_name] == ' ') {
            num_spaces += 1;
            if (num_spaces == 3) {
                break;
            }
        }
        index_end_name -= 1;
    }
    for (int i = 0; i < index_end_name; i++) {
        name[i] = s[i];
    }
    name[index_end_name] = '\0';
    // end of finding and copying name and surname

    // start of parsing size num and measurement of item
    char buffer[100];
    for (int i = index_end_name + 1; i < strlen(s); i++) {
        buffer[i - index_end_name - 1] = s[i];
    }
    buffer[strlen(s) - index_end_name - 1] = '\0';

    char measur[5];
    sscanf(buffer, "%f %d %s", size, num, measur);
    // end of parsing size num and measurement of item

    int name_len = strlen(name);

    if (!(4 <= name_len && name_len <= 15)) { // check length of name [4; 15]
        return 0;
    }

    // checking that name of the item consists only букв и пробелов
    for (int i = 0; i < strlen(name); ++i) {
        if (!(('a' <= name[i] and name[i] <= 'z') or ('A' <= name[i] and name[i] <= 'Z') or name[i] == ' ')) {
            return 0;
        }
    }

    if (!(0 < *size && *size <= 200)) { // checking size (0; 200];
        return 0;
    }

    if (!(0 < *num && *num <= 30)) { // checking Amount (0; 30];
        return 0;
    }

    // sets type of measurement: pcs = 0, pair = 1
    if (measur[0] == 'p' and measur[1] == 'c' and measur[2] == 's') {
        *measurement = 0;
    } else if (measur[0] == 'p' and measur[1] == 'a' and measur[2] == 'i' and measur[3] == 'r') {
        *measurement = 1;
    } else {
        return 0;
    }
    return 1;
}

void person_print(struct Person *person) { // function for Debug output
    printf("***************\n");

    printf("%s\n", person->full_name);
    printf("%s\n", person->data);
    printf("%s\n", person->time);
    printf("name_validation: %d\n", person->name_validation);
    printf("data_time_validation: %d\n", person->date_time_validation);
    printf("Items:\n");
    for (int i = 0; i < person->num; i++) {
        printf("Item %s: status %d | mes: %d\n", person->items[i].name, person->items[i].item_validation,
               person->items[i].measurement);
    }

    printf("***************\n");
}

void out(struct Person *person) { // function for printing a Person and items of this Person
    //ex. Mike Vazovski has rented 1 pcs of Snowboard of size 90, 1 pair of Googles of size 49 and 1 pcs of Helmet of size 51 on 01/02/2021 at 08:55:12.
    printf("%s has rented ", person->full_name);
    for (int i = 0; i < person->num; i++) { // measurement == 0 => pcs, measurement == 1 => pair
        struct Item *it = &person->items[i];
        if (it->measurement == 0) {
            printf("%d pcs of ", it->num);
        }
        if (it->measurement == 1) {
            if (it->num == 1) {
                printf("%d pair of ", it->num);
            } else {
                printf("%d pairs of ", it->num);
            }
        }
        printf("%s of size %g", it->name, it->size);
        if (i == person->num - 2) {
            printf(" and ");
        } else if (i != person->num - 1) {
            printf(", ");
        } else {
            printf(" ");
        }
    }
    printf("on %s at %s.\n", person->data, person->time);
}

int main() {
    FILE *input = freopen("input.txt", "r", stdin);
    FILE *output = freopen("output.txt", "w", stdout);

    char s1[SIZE];
    int state = 0, col_items = 0;
    struct Person arr[100];
    int index = 0;
    while (!feof(input)) { // while file did not end
        struct Person *person = &arr[index];
        gets(s1);

        // start deleting spaces from left and right
        char s[SIZE];
        int left_index = 0, right_index = strlen(s1) - 1;
        while (s1[left_index] == ' ') {
            left_index += 1;
        }
        while (s1[right_index] == ' ') {
            right_index -= 1;
        }

        for (int i = left_index; i <= right_index; i++) {
            s[i - left_index] = s1[i];
        }
        s[right_index + 1] = '\0';
        // end spaces from left and right

        if (s[0] == '\0') { // if line is empty
            state = 0;
            index += 1;
            person->num = col_items;
            col_items = 0;
            continue;
        }

        if (state == 0) { // state for getting name
            person->num = 0;
            int res_check = validation_of_name(s, person->full_name);
//            printf("%d\n", res_check);
            if (DEBUG)
                person->name_validation = res_check;

            if (!res_check) {
                printf("Invalid input!\n");
                if (DEBUG) {
                    state += 1;
                    continue;
                }
                return 0;
            }
            state += 1;
        } else if (state == 1) { // state for getting date and time
            int res_check = validation_of_date_time(s, person->data, person->time);
            if (!res_check) {
                printf("Invalid input!\n");
                return 0;
            }
            state += 1;
        } else {
            // state for getting items
            struct Item *it = (struct Item *) &person->items[col_items];
            int res_check = validation_of_item(s, it->name, &it->size, &it->num, &it->measurement);
            it->item_validation = res_check;
            if (!res_check) {
                printf("Invalid input!\n");
                return 0;
            }
            person->num += 1;
            col_items += 1;
        }
    }

    // writing an output
    for (int i = 0; i <= index; i++) {
        out(&arr[i]);
    }

    return 0;
}
