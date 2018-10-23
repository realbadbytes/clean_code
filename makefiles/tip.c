#include <stdio.h>

/* function prototype, this is defined in another object file that will be linked in later */
/* dont need this declaration if we include gd.h */
// double get_double(char *prompt, double min, double max);
#include "gd.h"

int main()
{
    double price, tip;
    price = get_double("Price: ", 0, 1000);
    tip = get_double("Tip: ", 0, 100);
    double tipAmt = price * tip / 100.0;
    double total = price + tipAmt;
    printf("Tip amount: %lf\n", tipAmt);
    printf("Total amount: %lf\n", total);
    return 0;
}
