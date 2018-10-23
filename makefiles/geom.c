#include <stdio.h>
#include <math.h>

double get_double(char *prompt, double min, double max);

int main()
{
    double x = get_double("x value: ", 0, 1000);
    double y = get_double("y value: ", 0, 100);
    double d = sqrt(pow(x, 2) + pow(y, 2));
    printf("Distance is %lf\n", d);
    return 0;
}

